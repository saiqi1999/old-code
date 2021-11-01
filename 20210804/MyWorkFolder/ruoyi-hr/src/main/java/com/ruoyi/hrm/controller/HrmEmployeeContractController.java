package com.ruoyi.hrm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
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
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.json.JSONObject.JSONArray;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.domain.HrmEmployeeContract;
import com.ruoyi.hrm.service.IHrmEmployeeContractService;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工合同Controller
 * 员工合同建立在已经存在员工的基础上，且每名员工只有一份合同。因此修改，增加员工合同的时候应该只需要显示员工列表，然后后面按钮编辑即可
 * list：显示员工列表
 * edit：弹出合同信息，提交后检查，如果数据库里有id--contract就update，如果没有就insert。
 * upload：提供上传功能，有fileinput.js链接
 * download：提供下载功能。
 * @author alpk
 * @date 2021-06-15
 */
@Controller
@RequestMapping("/hrm/contract")
public class HrmEmployeeContractController extends BaseController
{
    private String prefix = "hrm/contract";
    private String uploadPath_profile;
    private String uploadPath_contract;
    void cleanDefault() {
    	HrmEmployeeContract e = new HrmEmployeeContract();
    	e.setEmployeeName("default name");
    	e.setEmployeeId((long)0);
    	List<HrmEmployeeContract> previousDefault = new ArrayList<HrmEmployeeContract>();
    	previousDefault = hrmEmployeeContractService.selectHrmEmployeeContractList(e);
    	for(HrmEmployeeContract i : previousDefault) {
    		hrmEmployeeContractService.deleteHrmEmployeeContractById(i.getEmployeeId());
    	}
    }
	String getLoginName() { return ShiroUtils.getLoginName(); }

    @Autowired
    private IHrmEmployeeContractService hrmEmployeeContractService;
    
    @Autowired
    private IHrmEmployeeService hrmEmployeeService;

    @RequiresPermissions("hrm:contract:view")
    @GetMapping()
    public String contract()
    {
    	uploadPath_profile = RuoYiConfig.getProfile();
    	uploadPath_contract = RuoYiConfig.getProfile()+"/contracts";
        return prefix + "/contract";
    }

    /**
     * 查询员工合同列表
     */
    @RequiresPermissions("hrm:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmEmployee hrmEmployee)
    {
        startPage();
        List<HrmEmployee> list = hrmEmployeeService.selectHrmEmployeeList(hrmEmployee);
        return getDataTable(list);
    }
    
    /**
     * 查询自己
     */
    @GetMapping("/my")
    public String my()
    {
    	uploadPath_profile = RuoYiConfig.getProfile();
    	uploadPath_contract = RuoYiConfig.getProfile()+"/contracts";
        return prefix + "/my";
    }
    @PostMapping("/listmy")
    @ResponseBody
    public TableDataInfo listmy(HrmEmployee hrmEmployee)
    {
        startPage();
        hrmEmployee.setLoginName(getLoginName());
        List<HrmEmployee> list = hrmEmployeeService.selectHrmEmployeeList(hrmEmployee);
        if(list.size()==0)return new TableDataInfo();
        HrmEmployeeContract hrmEmployeeContract = new
        HrmEmployeeContract();
      	hrmEmployeeContract.setEmployeeId(list.get(0).getEmployeeId());
      	//System.out.println(hrmEmployeeContract.toString()); 
      	List<HrmEmployeeContract> cList = new LinkedList<>(); 
      	hrmEmployeeContract = hrmEmployeeContractService.selectHrmEmployeeContractById(hrmEmployeeContract.getEmployeeId());
      	cList.add(hrmEmployeeContract); 
      	return getDataTable(cList);
		
		  
		 
        
    }

    /**
     * 导出员工合同列表
     */
	/*
	 * @RequiresPermissions("hrm:contract:export")
	 * 
	 * @Log(title = "员工合同", businessType = BusinessType.EXPORT)
	 * 
	 * @PostMapping("/export")
	 * 
	 * @ResponseBody public AjaxResult export(HrmEmployeeContract
	 * hrmEmployeeContract) { List<HrmEmployeeContract> list =
	 * hrmEmployeeContractService.selectHrmEmployeeContractList(hrmEmployeeContract)
	 * ; ExcelUtil<HrmEmployeeContract> util = new
	 * ExcelUtil<HrmEmployeeContract>(HrmEmployeeContract.class); return
	 * util.exportExcel(list, "员工合同数据"); }
	 */

    /**
     * 新增员工合同
     */
	/*
	 * @GetMapping("/add") public String add(ModelMap mmap) { cleanDefault();
	 * HrmEmployeeContract e = new HrmEmployeeContract(); String time = new
	 * Date().getTime()+""; e.setRemark(time); e.setEmployeeId((long)0);
	 * e.setEmployeeName("default name");
	 * hrmEmployeeContractService.insertHrmEmployeeContract(e); e =
	 * hrmEmployeeContractService.selectHrmEmployeeContractList(e).get(0);
	 * mmap.put("employeeId",e.getEmployeeId()); return prefix + "/add"; }
	 */

    /**
     * 新增保存员工合同
     */
	/*
	 * @RequiresPermissions("hrm:contract:add")
	 * 
	 * @Log(title = "员工合同", businessType = BusinessType.INSERT)
	 * 
	 * @PostMapping("/add")
	 * 
	 * @ResponseBody public AjaxResult addSave(HrmEmployeeContract
	 * hrmEmployeeContract) {
	 * //System.out.println(hrmEmployeeContract.getEmployeeId());
	 * hrmEmployeeContractService.updateContractId(hrmEmployeeContract.getEmployeeId
	 * ());
	 * if(hrmEmployeeService.selectHrmEmployeeById(hrmEmployeeContract.getEmployeeId
	 * ())==null)return null;
	 * if(hrmEmployeeContractService.selectHrmEmployeeContractById(
	 * hrmEmployeeContract.getEmployeeId())!=null) { cleanDefault(); return null; }
	 * return toAjax(hrmEmployeeContractService.updateHrmEmployeeContract(
	 * hrmEmployeeContract)); }
	 */

    /**
     * 修改员工合同
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrmEmployeeContract hrmEmployeeContract = hrmEmployeeContractService.selectHrmEmployeeContractById(employeeId);
        if(hrmEmployeeContract!=null)mmap.put("hrmEmployeeContract", hrmEmployeeContract);
        else {
        	HrmEmployee thePerson = hrmEmployeeService.selectHrmEmployeeById(employeeId);
        	System.out.println("contract/edit/id "+thePerson.toString());
        	HrmEmployeeContract e = new HrmEmployeeContract();
        	e.setEmployeeId(employeeId);
        	e.setEmployeeName(thePerson.getEmployeeName());
        	hrmEmployeeContractService.insertHrmEmployeeContract(e);
        	mmap.put("hrmEmployeeContract", e);
        }
        return prefix + "/edit";
    }

    /**
     * 修改保存员工合同
     */
    @RequiresPermissions("hrm:contract:edit")
    @Log(title = "员工合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmEmployeeContract hrmEmployeeContract)
    {
    	
        return toAjax(hrmEmployeeContractService.updateHrmEmployeeContract(hrmEmployeeContract));
    }

    /**
     * 删除员工合同
     */
    @RequiresPermissions("hrm:contract:remove")
    @Log(title = "员工合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmEmployeeContractService.deleteHrmEmployeeContractByIds(ids));
    }
    
    /**
     * 查看
     * @param employeeId
     * @param mmap
     * @return
     */
	/*
	 * @RequiresPermissions("hrm:contract:view")
	 * 
	 * @GetMapping("/view/{employeeId}") public String view(HttpServletResponse
	 * response, @PathVariable("employeeId") Long employeeId, ModelMap mmap) {
	 * //System.out.println("hrm contract view");
	 * 
	 * mydownload(response,filename); mmap.put("hrmEmployeeContract", e); return
	 * prefix + "/view"; }
	 */
    
    /**
     * 自己写的测试上传
     */
    @PostMapping("/uploadContract/{employeeId}")
    @ResponseBody
    public String myupload(@PathVariable("employeeId") Long employeeId, @RequestParam(value="file",required=false) MultipartFile file,ModelMap mmap) {
    	System.out.println("post /uploCon/id::");
    	try {
    		File f = new File(uploadPath_contract);
    		if(!f.exists())f.mkdirs();
    		String s = FileUploadUtils.upload(uploadPath_contract,file);
    		System.out.println("post /uploadCon/Id:"+s+employeeId);
			HrmEmployeeContract e = hrmEmployeeContractService.selectHrmEmployeeContractById(employeeId);
			e.setEmployeeContract(s);
			System.out.println(s);
			System.out.println(e.toString());
			hrmEmployeeContractService.updateHrmEmployeeContract(e);
			System.out.println(hrmEmployeeContractService.selectHrmEmployeeContractById(e.getEmployeeId()).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//bootstrap-fileupload是把file塞到reques里面传过来的，如果想在后台接收file，需要借用spring的@requesparam注解找传过来的file
    	JSONArray list = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("type", "上传文件");
        item.put("date", new Date().toString());
        list.add(item);
        mmap.put("tasks", list);
        //System.out.print(list);
        return list.toString();
    }
    
    /**
     * 自己写的测试下载
     */
    @RequestMapping("/download/{employeeId}")
    //@ResponseBody
    public String mydownload(@PathVariable("employeeId") Long employeeId,HttpServletResponse response, HttpServletRequest request, ModelMap mmap){
    	HrmEmployeeContract e = hrmEmployeeContractService.selectHrmEmployeeContractById(employeeId);
    	if(e==null) {
    		//return "没有文件";
    		mmap.put("msg", "no file");
    		return prefix+"/contract";
    	}
        String filename = e.getEmployeeContract();
    	System.out.println(filename);
    	System.out.println(uploadPath_profile);
    	filename = filename.replace("/profile", uploadPath_profile);
    	System.out.println(filename);
    	filename = filename.replaceFirst("/profile", uploadPath_profile);
    	System.out.println(filename);
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
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
        return null;
    }
    @RequestMapping("/download")
    @ResponseBody
    public void mydownloadInEditPage(String filename, HttpServletResponse response){
    	System.out.println(filename);
    	System.out.println(uploadPath_profile);
    	filename = filename.replace("/profile", uploadPath_profile);
    	System.out.println(filename);
    	filename = filename.replaceFirst("/profile", uploadPath_profile);
    	System.out.println(filename);
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
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
        return;
    }
}
