package com.ruoyi.hrm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.json.JSONObject.JSONArray;
import com.ruoyi.hrm.domain.HrmEmployNeed;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.domain.HrmPreEmployee;
import com.ruoyi.hrm.service.IHrmEmployNeedService;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.hrm.service.IHrmPreEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员录用Controller
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
@Controller
@RequestMapping("/hrm/toEmploy")
public class HrmPreEmployeeController extends BaseController
{
    private String prefix = "hrm/toEmploy";
    private String uploadPath = "D:\\java\\Jweb\\RuoYi\\ruoyi-admin\\target\\classes\\static\\img\\myImg\\HrmPreEmployee\\";
    private String enrollPath = "D:\\java\\Jweb\\RuoYi\\ruoyi-admin\\target\\classes\\static\\img\\myImg\\HrmEmployee\\";
    String getLoginName() {
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
		return loginName;
    }
    void filecpy(String sourceName, String destName) {
    	File source = new File(sourceName);
		File dest = new File(destName);
		try {
			InputStream is = new FileInputStream(source);
			OutputStream os = new FileOutputStream(dest);
			byte[] b = new byte[1024];
			int len;
			while((len=is.read(b))!=-1) {
				os.write(b);
			};
			os.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

    @Autowired
    private IHrmPreEmployeeService hrmPreEmployeeService;
    
    @Autowired
    private IHrmEmployeeService hrmEmployeeService;

    @Autowired
    private IHrmEmployNeedService hrmEmployNeedService;
    
    @RequiresPermissions("hrm:toEmploy:view")
    @GetMapping()
    public String toEmploy()
    {
        return prefix + "/toEmploy";
    }

    /**
     * 查询人员录用列表
     */
    @RequiresPermissions("hrm:toEmploy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmPreEmployee hrmPreEmployee)
    {
        startPage();
        List<HrmPreEmployee> list = hrmPreEmployeeService.selectHrmPreEmployeeList(hrmPreEmployee);
        return getDataTable(list);
    }

    /**
     * 导出人员录用列表
     */
    @RequiresPermissions("hrm:toEmploy:export")
    @Log(title = "人员录用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmPreEmployee hrmPreEmployee)
    {
        List<HrmPreEmployee> list = hrmPreEmployeeService.selectHrmPreEmployeeList(hrmPreEmployee);
        ExcelUtil<HrmPreEmployee> util = new ExcelUtil<HrmPreEmployee>(HrmPreEmployee.class);
        return util.exportExcel(list, "人员录用数据");
    }

    /**
     * 新增人员录用
     */
    @GetMapping("/add")
    public String add()
    {
    	System.out.println("page requested: preEmploy-add");
        return prefix + "/add";
    }

    /**
     * 新增保存人员录用
     */
    @RequiresPermissions("hrm:toEmploy:add")
    @Log(title = "人员录用", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmPreEmployee hrmPreEmployee)
    {
    	if(!hrmPreEmployee.getPhoto().equals(""))hrmPreEmployee.setPhoto(getLoginName()+"_"+hrmPreEmployee.getPhoto());
    	if(!hrmPreEmployee.getResume().equals(""))hrmPreEmployee.setResume(getLoginName()+"_"+hrmPreEmployee.getResume());
    	String filename = hrmPreEmployee.getResume();
    	filename = filename.replace('(', '_');
    	filename = filename.replace(')', '_');
    	File f = new File(uploadPath+filename);
    	if(!f.exists()) {
    		System.out.println("file not exist: "+filename);
    		hrmPreEmployee.setResume("");
    	}
    	hrmPreEmployee.setResume(filename);
        return toAjax(hrmPreEmployeeService.insertHrmPreEmployee(hrmPreEmployee));
    }
    
    /**
     * 查看
     */
    @RequiresPermissions("hrm:toEmploy:view")
    @GetMapping("/view/{employeeId}")
    public String view(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmPreEmployee hrmPreEmployee = hrmPreEmployeeService.selectHrmPreEmployeeById(employeeId);
        mmap.put("hrmEmployee", hrmPreEmployee);
        return prefix + "/view";
    }
    
    /**
     * 录用，提供录用批次ID和个人ID将其录用。
     */
    @RequiresPermissions("hrm:toEmploy:view")
    @GetMapping("/enroll/{employeeId}")
    public String enroll(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmPreEmployee hrmPreEmployee = hrmPreEmployeeService.selectHrmPreEmployeeById(employeeId);
        mmap.put("hrmEmployee", hrmPreEmployee);
        return prefix + "/enroll";
    }
    /**
     * 录用，这回是在数据库中保存
     * @param hrmPreEmployee
     * @return
     */
    @RequiresPermissions("hrm:toEmploy:add")
    @Log(title = "人员录用", businessType = BusinessType.INSERT)
    @PostMapping("/enroll")
    @ResponseBody
    public AjaxResult enrollSave(HttpServletRequest request)
    {
    	Long employeeId = (long)Integer.parseInt(request.getParameter("employeeId"));
    	Long employerId = (long)Integer.parseInt(request.getParameter("employerId"));
		System.out.println(request.getParameter("employeeId"));
		System.out.println(request.getParameter("employerId"));
		HrmEmployNeed need = hrmEmployNeedService.selectHrmEmployNeedById(employerId);
		HrmPreEmployee pre = hrmPreEmployeeService.selectHrmPreEmployeeById(employeeId);
		HrmEmployee now = new HrmEmployee();
		if(need.getNumberNeed()>0)need.setNumberNeed(need.getNumberNeed()-1);
		else now.setRemark("exceed maximum capacity enrolled: ");
		now.setEmployeeId(employeeId);
		if(now.getRemark()!=null){now.setRemark(now.getRemark() +" enrolled by "+ getLoginName());}
		else now.setRemark(" enrolled by "+ getLoginName());
		
		now.setAttachment(pre.getAttachment());
		now.setBloodType(pre.getBloodType());//etc.
		now.setEmployeeName(pre.getEmployeeName());
		now.setLoginName(pre.getLoginName());
		filecpy(uploadPath+pre.getResume(),enrollPath+pre.getResume());
		
		
		
		
		hrmEmployeeService.insertHrmEmployee(now);
		hrmEmployNeedService.updateHrmEmployNeed(need);
    	return toAjax(hrmPreEmployeeService.deleteHrmPreEmployeeById(employeeId));
    	
    }

    /**
     * 修改人员录用
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmPreEmployee hrmPreEmployee = hrmPreEmployeeService.selectHrmPreEmployeeById(employeeId);
        mmap.put("hrmEmployee", hrmPreEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员录用
     */
    @RequiresPermissions("hrm:toEmploy:edit")
    @Log(title = "人员录用", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmPreEmployee hrmPreEmployee)
    {
    	if(!hrmPreEmployee.getPhoto().equals("")&&!hrmPreEmployee.getPhoto().startsWith(getLoginName()+"_"))hrmPreEmployee.setPhoto(getLoginName()+"_"+hrmPreEmployee.getPhoto());
    	if(!hrmPreEmployee.getResume().equals("")&&!hrmPreEmployee.getResume().startsWith(getLoginName()+"_"))hrmPreEmployee.setResume(getLoginName()+"_"+hrmPreEmployee.getResume());
    	String filename = hrmPreEmployee.getResume();
    	filename = filename.replace('(', '_');
    	filename = filename.replace(')', '_');
    	File f = new File(uploadPath+filename);
    	if(!f.exists()) {
    		System.out.println("file not exist: "+filename);
    		hrmPreEmployee.setResume("");
    	}
    	hrmPreEmployee.setResume(filename);
    	System.out.print(hrmPreEmployee.toString());
        return toAjax(hrmPreEmployeeService.updateHrmPreEmployee(hrmPreEmployee));
    }

    /**
     * 删除人员录用
     */
    @RequiresPermissions("hrm:toEmploy:remove")
    @Log(title = "人员录用", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmPreEmployeeService.deleteHrmPreEmployeeByIds(ids));
    }
    
    /**
     * 自己写的测试上传
     */
    @PostMapping("/upload")
    @ResponseBody
    public String myupload(@RequestParam(value="file",required=false) MultipartFile[] file,ModelMap mmap) {
    	try {
    		InputStream is = file[0].getInputStream();
    		//这里可以加判断但是我不知道要传什么格式
    		//file[0].getOriginalFilename().endsWith(".jpg");
    		File f = new File(uploadPath);
    		if(!f.exists())f.mkdirs();
    		String filename = file[0].getOriginalFilename();
    		FileOutputStream os = new FileOutputStream(uploadPath+getLoginName()+"_"+filename);
			byte[] b = new byte[1024];
			int len;
			while((len=is.read(b))!=-1) {
				os.write(b);
			}
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//bootstrap-fileupload是把file塞到reques里面传过来的，如果想在后台接收file，需要借用spring的@requesparam注解找传过来的file
    	JSONArray list = new JSONArray();
        JSONObject item = new JSONObject();
        
        item.put("type", "新增");
        item.put("date", "2021.06.09");
        list.add(item);
		/*
		 * item = new JSONObject();
		 * 
		 * item.put("type", "新增"); item.put("date", "2018.06.12"); list.add(item);
		 */
        mmap.put("tasks", list);
        //System.out.print(list);
        return list.toString();
    }
    
    /**
     * 自己写的测试下载
     */
    @RequestMapping("/download")
    @ResponseBody
    public void mydownload(HttpServletResponse response, @RequestParam(value="filename",required=false)String filename){
    	
    	System.out.println(filename);
    	File f = new File(uploadPath+filename);
    	System.out.println(filename);
    	if(f.exists()) {
    		try {
				OutputStream os = new BufferedOutputStream(response.getOutputStream());
				response.reset();
				response.setHeader("Content-Disposition", "attachment; filename="+filename);
				//response.setHeader("Content-Length","" + f.length());
				//这个属性会让浏览器自己跳回去的吗？？所以用href原生方法访问就可以，jq和ajax会提前断开连接导致传输失败？
				//能不能用别的方法？这个方法会跳回到表头
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
    		
    	}else {
    		
    	}
        return;
    }
}
