package com.ruoyi.hrm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.json.JSONObject.JSONArray;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.service.IHrmEmployeeContractService;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dingtalk.domain.DdEmployee;
import com.ruoyi.dingtalk.service.IDdEmployeeService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工统计Controller
 * 
 * @author ruoyi
 * @date 2021-06-08
 */
@Controller
@RequestMapping("/hrm/employee")
public class HrmEmployeeController extends BaseController
{
    private String prefix = "hrm/employee";
    //上传的路径在这里配置，下载的路径就管不着了，由浏览器配置了。
    private String uploadPath_avatar;
    private String uploadPath_resume;
    private String uploadPath_profile;
    String getLoginName() {
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		//System.out.println(loginName);
        	}
        }
		return loginName;
    }
    void cleanDefault() {
    	HrmEmployee e = new HrmEmployee();
    	e.setEmployeeName("default name");
    	//e.setLoginName("default login name");
    	List<HrmEmployee> previousDefault = new ArrayList<HrmEmployee>();
    	previousDefault = hrmEmployeeService.selectHrmEmployeeList(e);
    	for(HrmEmployee i : previousDefault) {
    		hrmEmployeeService.deleteHrmEmployeeById(i.getEmployeeId());
    	}
    }

    @Autowired
    private IHrmEmployeeService hrmEmployeeService;
    @Autowired
    private IHrmEmployeeContractService hrmEmployeeContractService;
    @Autowired
	private IDdEmployeeService ddEmployeeService;

    @RequiresPermissions("hrm:employee:view")
    @GetMapping()
    public String employee()
    {
    	uploadPath_avatar = RuoYiConfig.getAvatarPath()+"/all Employee System";
    	uploadPath_resume = RuoYiConfig.getProfile()+"/all Employee Resume";
    	uploadPath_profile = RuoYiConfig.getProfile();
    	System.out.println("hrmEMCon::get() config-------"+RuoYiConfig.getAvatarPath()+"/all Employee System"); 
    	System.out.println("hrmEMCon::get() uploadPath---"+uploadPath_avatar);
    	//难道是因为执行顺序不对？如果没有第一句话uploadPath就会出null
        return prefix + "/employee";
    }
    
    @RequiresPermissions("hrm:employee:view")
    @GetMapping("/view/{employeeId}")
    public String view(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmEmployee hrmEmployee = hrmEmployeeService.selectHrmEmployeeById(employeeId);
        mmap.put("hrmEmployee", hrmEmployee);
        return prefix + "/view";
    }

    /**
     * 查询员工统计列表
     */
    @RequiresPermissions("hrm:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmEmployee hrmEmployee)
    {
        startPage();
        cleanDefault();
        List<HrmEmployee> list = hrmEmployeeService.selectHrmEmployeeList(hrmEmployee);
        return getDataTable(list);
    }

    /**
     * 查询自己
     */
    @GetMapping("/my")
    public String my(ModelMap mmap)
    {
		/*
		 * uploadPath_avatar = RuoYiConfig.getAvatarPath()+"/all Employee System";
		 * uploadPath_profile = RuoYiConfig.getProfile();
		 */
    	
    	HrmEmployee me = new HrmEmployee();
    	me.setLoginName(ShiroUtils.getLoginName());
    	List<HrmEmployee> rst = hrmEmployeeService.selectHrmEmployeeList(me);
    	if(rst==null||rst.size()==0) {
    		me.setEmployeeId((long) 0);
    		mmap.put("hrmEmployee", me);
    	}
    	else {
    		mmap.put("hrmEmployee", rst.get(0));
    	}
        return prefix + "/view";
    }
	/*
	 * @PostMapping("/listmy")
	 * 
	 * @ResponseBody public TableDataInfo listmy(HrmEmployee hrmEmployee) {
	 * startPage(); hrmEmployee.setLoginName(getLoginName()); List<HrmEmployee> list
	 * = hrmEmployeeService.selectHrmEmployeeList(hrmEmployee); return
	 * getDataTable(list); }
	 */
    
    /**
     * 导出员工统计列表
     */
    @RequiresPermissions("hrm:employee:export")
    @Log(title = "员工统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmEmployee hrmEmployee)
    {
        List<HrmEmployee> list = hrmEmployeeService.selectHrmEmployeeList(hrmEmployee);
        ExcelUtil<HrmEmployee> util = new ExcelUtil<HrmEmployee>(HrmEmployee.class);
        return util.exportExcel(list, "员工统计数据");
    }

    /**
     * 新增员工统计
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	
    	HrmEmployee e = new HrmEmployee();
    	String time = new Date().getTime()+"";
    	e.setRemark(time);
    	e.setEmployeeName("default name");
    	e.setLoginName(time);
    	hrmEmployeeService.insertHrmEmployee(e);
    	e = hrmEmployeeService.selectHrmEmployeeList(e).get(0);
    	mmap.put("employeeId",e.getEmployeeId());
        return prefix + "/add";
    }

    /**
     * 新增保存员工统计
     */
    @RequiresPermissions("hrm:employee:add")
    @Log(title = "员工统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmEmployee hrmEmployee)
    {
		return toAjax(hrmEmployeeService.updateHrmEmployee(hrmEmployee));
    }

    /**
     * 修改员工统计
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmEmployee hrmEmployee = hrmEmployeeService.selectHrmEmployeeById(employeeId);
        mmap.put("hrmEmployee", hrmEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工统计
     */
    @RequiresPermissions("hrm:employee:edit")
    @Log(title = "员工统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmEmployee hrmEmployee)
    {
		return toAjax(hrmEmployeeService.updateHrmEmployee(hrmEmployee));
    }

    /**
     * 删除员工统计
     */
    @RequiresPermissions("hrm:employee:remove")
    @Log(title = "员工统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
    	hrmEmployeeContractService.deleteHrmEmployeeContractByIds(ids);
        return toAjax(hrmEmployeeService.deleteHrmEmployeeByIds(ids));
    }
    
    @PostMapping("/uploadAvatar/{employeeId}")
    @ResponseBody
    public String uploadAvatar(@RequestParam(value="file",required=false) MultipartFile file, @PathVariable("employeeId") Long employeeId, ModelMap mmap) {
    	String s = "";
    	try {
    		File f= new File(uploadPath_avatar);
    		if(!f.exists())f.mkdirs();
    		//System.out.println("hrmEC::Pm/uploadAvatar uploadAvatar,"+employeeId);
    		s = FileUploadUtils.upload(uploadPath_avatar,file);
			//System.out.println("uploadAvatar,"+s);
			HrmEmployee e = hrmEmployeeService.selectHrmEmployeeById(employeeId);
			e.setPhoto(s);
			hrmEmployeeService.updateHrmEmployee(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	JSONArray list = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("name", s);
        item.put("type", "file");
        list.add(item);
        mmap.put("tasks", list);
        return list.toString();
    }
    
    /**
     * 自己写的测试上传
     */
	/*
	 * @PostMapping("/uploadResume/{employeeId}")
	 * 
	 * @ResponseBody public String
	 * myupload(@RequestParam(value="file",required=false) MultipartFile
	 * file,@PathVariable("employeeId") Long employeeId, ModelMap mmap) { String
	 * s=""; try { File f= new File(uploadPath_resume); if(!f.exists())f.mkdirs();
	 * //System.out.println("hrmEC::Pm/uploadResume uploadResume,"+employeeId); s =
	 * FileUploadUtils.upload(uploadPath_resume,file);
	 * //System.out.println("uploadAvatar,"+s); HrmEmployee e =
	 * hrmEmployeeService.selectHrmEmployeeById(employeeId); e.setResume(s);
	 * hrmEmployeeService.updateHrmEmployee(e); } catch (IOException e) {
	 * e.printStackTrace(); } JSONArray list = new JSONArray(); JSONObject item =
	 * new JSONObject(); item.put("name", s); item.put("type", "file");
	 * list.add(item); mmap.put("tasks", list); return list.toString(); }
	 */
    	
    	
    
    /**
     * 自己写的测试下载
     */
    @RequestMapping("/download")
    @ResponseBody
    public void mydownload(HttpServletResponse response, @RequestParam(value="filename",required=false)String filename){
    	
    	filename = filename.replaceFirst("/profile", uploadPath_profile);
    	File f = new File(filename);
    	if(f.exists()) {
    		try {
				OutputStream os = new BufferedOutputStream(response.getOutputStream());
				response.reset();
				response.setHeader("Content-Disposition", "attachment; filename="+f.getName());
				response.setContentType("application/octet-stream");
				InputStream is = new BufferedInputStream(new FileInputStream(f));
				byte[] buffer = new byte[2048];
				int len;
				while((len=is.read(buffer))!=-1) {
					os.write(buffer);
				}
				os.flush();
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    	
        return;
    }
    
    /**通过钉钉用户获取信息*/
    @PostMapping("/getInfo")
    @ResponseBody
    public AjaxResult getInfo(HrmEmployee e) {
    	
    	//System.out.println("getInfo from ding");
    	AjaxResult a = new AjaxResult();
    	HrmEmployee ee = hrmEmployeeService.selectHrmEmployeeByUserId(e.getUserId());
    	if(ee!=null) {
    		a.put("code", "404");
    		a.put("msg", "钉钉id已存在");
    		return a;
    	}
    	DdEmployee d = ddEmployeeService.selectDdEmployeeByDingId(e.getUserId());
    	a.put("employeeName", d.getName());
    	a.put("idCardNumber", d.getCertNo());
    	a.put("employeePost", d.getPosition());
    	a.put("employeeDepartment", d.getMainDept());
    	a.put("phoneNumber", d.getMobile());
    	
    	String s = d.getMarriage();
    	if(s!=null) {
    		//System.out.println("mirrage code is "+s);
    		if(s.equals("1"))a.put("mirrage", "single");
        	else if (s.equals("2"))a.put("mirrage", "married");
    	}
    	s = d.getEmployeeStatus();
    	if(s!=null) {
    		if(s.equals("1"))a.put("employeeStatus", "trail");
        	else if (s.equals("2"))a.put("employeeStatus", "formal");
    	}
    	s = d.getEmployeeType();
    	if(s!=null) {
    		if(s.equals("1"))a.put("employeeType", "registered");
        	else if (s.equals("6"))a.put("employeeType", "temporary");
    	}
    	s = d.getSexType();
    	if(s!=null) {
    		if(s.equals("0"))a.put("gender", "male");
        	else if (s.equals("1"))a.put("gender", "female");
    	}
    	
    	a.put("birthDate", DateUtils.parseDate( d.getBirthTime() ));
    	a.put("wageCardBank", d.getAccountBank());
    	a.put("wageCardNumber", d.getBankAccountNo());
    	a.put("employeeAddress", d.getCertAddress());
    	a.put("dateStartWorking", DateUtils.parseDate( d.getJoinWorkingTime()));
    	a.put("emailAddress", d.getEmail());
    	a.put("dateEnrolled", d.getConfirmJoinTime());
    	a.put("university", d.getGraduateSchool());
    	a.put("nationality", d.getNationType());
    	a.put("major", d.getMajor());
    	a.put("graduateTime", DateUtils.parseDate(d.getGraduationTime()));
    	
    	
    	
    	
    	//System.out.println(a);
		return a;
    }
}
