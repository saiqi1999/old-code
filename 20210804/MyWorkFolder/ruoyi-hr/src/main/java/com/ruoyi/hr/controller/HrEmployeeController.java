package com.ruoyi.hr.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.service.IHrEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dingtalk.domain.DdEmployee;
import com.ruoyi.dingtalk.service.IDdEmployeeService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工档案基本信息Controller
 * 
 * @author zy
 * @date 2019-10-28
 */
@Controller
@RequestMapping("/hr/employee")
public class HrEmployeeController extends BaseController
{
    private String prefix = "hr/employee";

    @Autowired
    private IHrEmployeeService hrEmployeeService;
    
    @Autowired
	private IDdEmployeeService ddEmployeeService;

    
    /**
	 * 系统花名册数据同步到系统员工档案
	 * 
	 * @throws Exception
	 */
	@GetMapping("/empsyn")
	@ResponseBody
	public AjaxResult synchronization() throws Exception {
		int count = 0;
		List<DdEmployee> selectDdEmployeeList = ddEmployeeService.selectDdEmployeeList(null);
		for (DdEmployee ddEmployee : selectDdEmployeeList) 
		{
			
			LocalDate today = LocalDate.now();
			HrEmployee selectHrEmployeeByDingId = hrEmployeeService.selectHrEmployeeByDingId(ddEmployee.getEmpId().toString());
			if(selectHrEmployeeByDingId!=null) {
				selectHrEmployeeByDingId.setDingempId(ddEmployee.getEmpId().toString());
				selectHrEmployeeByDingId.setName(ddEmployee.getName());
				selectHrEmployeeByDingId.setGender(ddEmployee.getSexType());
				//计算年龄
				if(ddEmployee.getBirthTime()!=null) {
					LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(ddEmployee.getBirthTime()));
					int age = (int) ChronoUnit.YEARS.between(playerDate, today);
					selectHrEmployeeByDingId.setAge(age);
					selectHrEmployeeByDingId.setBirthday(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getBirthTime()));
				}
				selectHrEmployeeByDingId.setNation(ddEmployee.getNationType());
				selectHrEmployeeByDingId.setMarital(ddEmployee.getMarriage());
				selectHrEmployeeByDingId.setIdentyNo(ddEmployee.getCertNo());
				selectHrEmployeeByDingId.setTelephone(ddEmployee.getMobile());
				selectHrEmployeeByDingId.setEmail(ddEmployee.getEmail());
				selectHrEmployeeByDingId.setAddress(ddEmployee.getAddress());
				selectHrEmployeeByDingId.setHomesite(ddEmployee.getCertAddress());
				selectHrEmployeeByDingId.setStatus(ddEmployee.getEmployeeStatus());
				selectHrEmployeeByDingId.setType(ddEmployee.getEmployeeType());
				if(ddEmployee.getConfirmJoinTime()!=null) {
					selectHrEmployeeByDingId.setEntryTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getConfirmJoinTime()));
				}
				selectHrEmployeeByDingId.setTrialPeriod(ddEmployee.getProbationPeriodType());
				if(ddEmployee.getRegularTime()!=null) {
					selectHrEmployeeByDingId.setPositiveTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getRegularTime()));
				}
				if(ddEmployee.getJoinWorkingTime()!=null) {
					selectHrEmployeeByDingId.setFirstWork(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getJoinWorkingTime()));
				}
				selectHrEmployeeByDingId.setJobSite(ddEmployee.getWorkPlace());
				selectHrEmployeeByDingId.setPolity(ddEmployee.getPoliticalStatus());
				selectHrEmployeeByDingId.setEducation(ddEmployee.getHighestEdu());
				selectHrEmployeeByDingId.setSchool(ddEmployee.getGraduateSchool());
				if(ddEmployee.getGraduationTime()!=null) {
					selectHrEmployeeByDingId.setGraduationDate(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getGraduationTime()));
				}
				selectHrEmployeeByDingId.setMajor(ddEmployee.getMajor());
				hrEmployeeService.updateHrEmployee(selectHrEmployeeByDingId);
				
			}else {
				HrEmployee hrEmployee =new HrEmployee();
				hrEmployee.setDingempId(ddEmployee.getEmpId().toString());
				hrEmployee.setName(ddEmployee.getName());
				hrEmployee.setGender(ddEmployee.getSexType());
				//计算年龄
				if(ddEmployee.getBirthTime()!=null) {
					LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(ddEmployee.getBirthTime()));
					int age = (int) ChronoUnit.YEARS.between(playerDate, today);
					hrEmployee.setAge(age);
					hrEmployee.setBirthday(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getBirthTime()));
				}
				hrEmployee.setNation(ddEmployee.getNationType());
				hrEmployee.setMarital(ddEmployee.getMarriage());
				hrEmployee.setIdentyNo(ddEmployee.getCertNo());
				hrEmployee.setTelephone(ddEmployee.getMobile());
				hrEmployee.setEmail(ddEmployee.getEmail());
				hrEmployee.setAddress(ddEmployee.getAddress());
				hrEmployee.setHomesite(ddEmployee.getCertAddress());
				hrEmployee.setStatus(ddEmployee.getEmployeeStatus());
				hrEmployee.setType(ddEmployee.getEmployeeType());
				if(ddEmployee.getConfirmJoinTime()!=null) {
					hrEmployee.setEntryTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getConfirmJoinTime()));
				}
				hrEmployee.setTrialPeriod(ddEmployee.getProbationPeriodType());
				if(ddEmployee.getRegularTime()!=null) {
					hrEmployee.setPositiveTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getRegularTime()));
				}
				if(ddEmployee.getJoinWorkingTime()!=null) {
					hrEmployee.setFirstWork(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getJoinWorkingTime()));
				}
				hrEmployee.setJobSite(ddEmployee.getWorkPlace());
				hrEmployee.setPolity(ddEmployee.getPoliticalStatus());
				hrEmployee.setEducation(ddEmployee.getHighestEdu());
				hrEmployee.setSchool(ddEmployee.getGraduateSchool());
				if(ddEmployee.getGraduationTime()!=null) {
					hrEmployee.setGraduationDate(DateUtils.dateTime(DateUtils.YYYY_MM_DD, ddEmployee.getGraduationTime()));
				}
				hrEmployee.setMajor(ddEmployee.getMajor());
				hrEmployeeService.insertHrEmployee(hrEmployee);
			}
			count++;
		}
		
		return AjaxResult.success("钉钉花名册总条数：" + count + ",已同步完成！");

	}
	
    @RequiresPermissions("hr:employee:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }

    /**
     * 查询员工档案基本信息列表
     */
    @RequiresPermissions("hr:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrEmployee hrEmployee)
    {
        startPage();
        List<HrEmployee> list = hrEmployeeService.selectHrEmployeeList(hrEmployee);
        return getDataTable(list);
    }

    /**
     * 导出员工档案基本信息列表
     */
    @RequiresPermissions("hr:employee:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrEmployee hrEmployee)
    {
        List<HrEmployee> list = hrEmployeeService.selectHrEmployeeList(hrEmployee);
        ExcelUtil<HrEmployee> util = new ExcelUtil<HrEmployee>(HrEmployee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工档案基本信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工档案基本信息
     */
    @RequiresPermissions("hr:employee:add")
    @Log(title = "员工档案基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrEmployee hrEmployee)
    {
        return toAjax(hrEmployeeService.insertHrEmployee(hrEmployee));
    }

    /**
     * 修改员工档案基本信息
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        HrEmployee hrEmployee = hrEmployeeService.selectHrEmployeeById(employeeId);
        mmap.put("hrEmployee", hrEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工档案基本信息
     */
    @RequiresPermissions("hr:employee:edit")
    @Log(title = "员工档案基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrEmployee hrEmployee)
    {
        return toAjax(hrEmployeeService.updateHrEmployee(hrEmployee));
    }

    /**
     * 删除员工档案基本信息
     */
    @RequiresPermissions("hr:employee:remove")
    @Log(title = "员工档案基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrEmployeeService.deleteHrEmployeeByIds(ids));
    }
}
