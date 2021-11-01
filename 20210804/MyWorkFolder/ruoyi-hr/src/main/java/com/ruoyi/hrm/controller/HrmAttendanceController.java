package com.ruoyi.hrm.controller;

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
import com.ruoyi.hrm.domain.HrmAttendance;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.service.IHrmAttendanceService;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工考勤Controller
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Controller
@RequestMapping("/hrm/attendance")
public class HrmAttendanceController extends BaseController
{
    private String prefix = "hrm/attendance";

    @Autowired
    private IHrmAttendanceService hrmAttendanceService;
    @Autowired
    private IHrmEmployeeService hrmEmployeeService;

    @RequiresPermissions("hrm:attendance:view")
    @GetMapping()
    public String attendance()
    {
        return prefix + "/attendance";
    }

    /**
     * 查询员工考勤列表
     */
    @RequiresPermissions("hrm:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmAttendance hrmAttendance)
    {
        startPage();
        List<HrmAttendance> list = hrmAttendanceService.selectHrmAttendanceList(hrmAttendance);
        return getDataTable(list);
    }

    /**
     * 导出员工考勤列表
     */
    @RequiresPermissions("hrm:attendance:export")
    @Log(title = "员工考勤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmAttendance hrmAttendance)
    {
        List<HrmAttendance> list = hrmAttendanceService.selectHrmAttendanceList(hrmAttendance);
        ExcelUtil<HrmAttendance> util = new ExcelUtil<HrmAttendance>(HrmAttendance.class);
        return util.exportExcel(list, "员工考勤数据");
    }

    /**
     * 新增员工考勤
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工考勤
     */
    @RequiresPermissions("hrm:attendance:add")
    @Log(title = "员工考勤", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmAttendance hrmAttendance)
    {
    	HrmEmployee e = hrmEmployeeService.selectHrmEmployeeById(hrmAttendance.getEmployeeId());
    	if(e==null) {
    		AjaxResult a = new AjaxResult();
    		a.put("msg", "不存在用户");
    		a.put("code", 1);
    		return a;
    	}
        return toAjax(hrmAttendanceService.insertHrmAttendance(hrmAttendance));
    }

    /**
     * 修改员工考勤
     */
    @GetMapping("/edit/{attendanceId}")
    public String edit(@PathVariable("attendanceId") Long attendanceId, ModelMap mmap)
    {
        HrmAttendance hrmAttendance = hrmAttendanceService.selectHrmAttendanceById(attendanceId);
        mmap.put("hrmAttendance", hrmAttendance);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工考勤
     */
    @RequiresPermissions("hrm:attendance:edit")
    @Log(title = "员工考勤", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmAttendance hrmAttendance)
    {
        return toAjax(hrmAttendanceService.updateHrmAttendance(hrmAttendance));
    }

    /**
     * 删除员工考勤
     */
    @RequiresPermissions("hrm:attendance:remove")
    @Log(title = "员工考勤", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmAttendanceService.deleteHrmAttendanceByIds(ids));
    }
}
