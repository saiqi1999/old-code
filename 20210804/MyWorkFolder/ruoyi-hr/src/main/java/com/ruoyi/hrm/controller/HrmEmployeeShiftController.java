package com.ruoyi.hrm.controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.domain.HrmEmployeeContract;
import com.ruoyi.hrm.domain.HrmEmployeeShift;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.hrm.service.IHrmEmployeeShiftService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工调动Controller
 * 
 * @author alpk
 * @date 2021-06-16
 */
@Controller
@RequestMapping("/hrm/shift")
public class HrmEmployeeShiftController extends BaseController
{
    private String prefix = "hrm/shift";
    String getLoginName() {
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	//System.out.print(i);
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		//System.out.println(loginName);
        	}
        }
		return loginName;
    }
    @Autowired
    private IHrmEmployeeShiftService hrmEmployeeShiftService;
    
    @Autowired
    private IHrmEmployeeService hrmEmployeeService;

    @RequiresPermissions("hrm:shift:view")
    @GetMapping()
    public String shift()
    {
        return prefix + "/shift";
    }

    /**
     * 查询员工调动列表
     */
    @RequiresPermissions("hrm:shift:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmEmployeeShift hrmEmployeeShift)
    {
        startPage();
        List<HrmEmployeeShift> list = hrmEmployeeShiftService.selectHrmEmployeeShiftList(hrmEmployeeShift);
        return getDataTable(list);
    }

    /**
     * 导出员工调动列表
     */
    @RequiresPermissions("hrm:shift:export")
    @Log(title = "员工调动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmEmployeeShift hrmEmployeeShift)
    {
        List<HrmEmployeeShift> list = hrmEmployeeShiftService.selectHrmEmployeeShiftList(hrmEmployeeShift);
        ExcelUtil<HrmEmployeeShift> util = new ExcelUtil<HrmEmployeeShift>(HrmEmployeeShift.class);
        return util.exportExcel(list, "员工调动数据");
    }

    /**
     * 新增员工调动
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工调动
     */
    @RequiresPermissions("hrm:shift:add")
    @Log(title = "员工调动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmEmployeeShift hrmEmployeeShift)
    {
    	HrmEmployee e = hrmEmployeeService.selectHrmEmployeeById(hrmEmployeeShift.getEmployeeId());
    	if(e==null) {
    		AjaxResult a = new AjaxResult();
    		a.put("msg", "不存在用户");
    		a.put("code", 1);
    		return a;
    	}
    	if(hrmEmployeeShift.getEmployeeName().equals(""))hrmEmployeeShift.setEmployeeName(e.getEmployeeName());
    	hrmEmployeeShift.setEmployeeExDepartment(e.getEmployeeDepartment());
    	hrmEmployeeShift.setEmployeeExJob(e.getEmployeeJob());
    	hrmEmployeeShift.setEmployeeExPost(e.getEmployeePost());
    	hrmEmployeeShift.setEmployeeExTitle(e.getEmployeeTitle());
    	hrmEmployeeShift.setEmployeeExType(e.getEmployeeType());
    	e.setEmployeeDepartment(hrmEmployeeShift.getEmployeeDepartment());
    	e.setEmployeeJob(hrmEmployeeShift.getEmployeeJob());
    	e.setEmployeePost(hrmEmployeeShift.getEmployeePost());
    	e.setEmployeeTitle(hrmEmployeeShift.getEmployeeTitle());
    	e.setEmployeeType(hrmEmployeeShift.getEmployeeType());
    	hrmEmployeeService.updateHrmEmployee(e);
        return toAjax(hrmEmployeeShiftService.insertHrmEmployeeShift(hrmEmployeeShift));
    }

    /**
     * 修改员工调动
     * 禁止修改，调动会修改员工档案
     */
	/*
	 * @GetMapping("/edit/{employeeId}") public String
	 * edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap) {
	 * HrmEmployeeShift hrmEmployeeShift =
	 * hrmEmployeeShiftService.selectHrmEmployeeShiftById(employeeId);
	 * mmap.put("hrmEmployeeShift", hrmEmployeeShift); return prefix + "/edit"; }
	 */

    /**
     * 修改保存员工调动
     */
	/*
	 * @RequiresPermissions("hrm:shift:edit")
	 * 
	 * @Log(title = "员工调动", businessType = BusinessType.UPDATE)
	 * 
	 * @PostMapping("/edit")
	 * 
	 * @ResponseBody public AjaxResult editSave(HrmEmployeeShift hrmEmployeeShift) {
	 * return
	 * toAjax(hrmEmployeeShiftService.updateHrmEmployeeShift(hrmEmployeeShift)); }
	 */
    /**
     * 删除员工调动
     * 禁止删除
     */
	/*
	 * @RequiresPermissions("hrm:shift:remove")
	 * 
	 * @Log(title = "员工调动", businessType = BusinessType.DELETE)
	 * 
	 * @PostMapping( "/remove")
	 * 
	 * @ResponseBody public AjaxResult remove(String ids) { return
	 * toAjax(hrmEmployeeShiftService.deleteHrmEmployeeShiftByIds(ids)); }
	 */
    
    /**
     * 查询自己
     */
    @GetMapping("/my")
    public String my()
    {
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
        Long id = list.get(0).getEmployeeId();
        HrmEmployeeShift hrmEmployeeShift = new HrmEmployeeShift();
        hrmEmployeeShift.setEmployeeId(id);
        List<HrmEmployeeShift> shiftList = hrmEmployeeShiftService.selectHrmEmployeeShiftList(hrmEmployeeShift);
        //System.out.println("/listmy"+shiftList.toString()+hrmEmployeeShift.toString()+list.toString());
        return getDataTable(shiftList);
		/*
		 * if(list.size()!=0) { HrmEmployeeShift hrmEmployeeShift = new
		 * HrmEmployeeShift();
		 * hrmEmployeeShift.setEmployeeId(list.get(0).getEmployeeId());
		 * System.out.println(hrmEmployeeShift.toString()); List<HrmEmployeeShift> cList
		 * = new LinkedList<>(); cList =
		 * hrmEmployeeShiftService.selectHrmEmployeeShiftList(hrmEmployeeShift);
		 * 
		 * return getDataTable(cList); } else { return null; }
		 */
        
    }
}
