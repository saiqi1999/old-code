package com.ruoyi.hr.controller;

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
import com.ruoyi.hr.domain.HrRecruitPlan;
import com.ruoyi.hr.service.IHrRecruitPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘计划Controller
 * 
 * @author zy
 * @date 2019-10-30
 */
@Controller
@RequestMapping("/hr/RecruitPlan")
public class HrRecruitPlanController extends BaseController
{
    private String prefix = "hr/RecruitPlan";

    @Autowired
    private IHrRecruitPlanService hrRecruitPlanService;

    @RequiresPermissions("hr:RecruitPlan:view")
    @GetMapping()
    public String RecruitPlan()
    {
        return prefix + "/RecruitPlan";
    }

    /**
     * 查询招聘计划列表
     */
    @RequiresPermissions("hr:RecruitPlan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrRecruitPlan hrRecruitPlan)
    {
        startPage();
        List<HrRecruitPlan> list = hrRecruitPlanService.selectHrRecruitPlanList(hrRecruitPlan);
        return getDataTable(list);
    }

    /**
     * 导出招聘计划列表
     */
    @RequiresPermissions("hr:RecruitPlan:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrRecruitPlan hrRecruitPlan)
    {
        List<HrRecruitPlan> list = hrRecruitPlanService.selectHrRecruitPlanList(hrRecruitPlan);
        ExcelUtil<HrRecruitPlan> util = new ExcelUtil<HrRecruitPlan>(HrRecruitPlan.class);
        return util.exportExcel(list, "RecruitPlan");
    }

    /**
     * 新增招聘计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招聘计划
     */
    @RequiresPermissions("hr:RecruitPlan:add")
    @Log(title = "招聘计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrRecruitPlan hrRecruitPlan)
    {
        return toAjax(hrRecruitPlanService.insertHrRecruitPlan(hrRecruitPlan));
    }

    /**
     * 修改招聘计划
     */
    @GetMapping("/edit/{recruitPlanId}")
    public String edit(@PathVariable("recruitPlanId") Long recruitPlanId, ModelMap mmap)
    {
        HrRecruitPlan hrRecruitPlan = hrRecruitPlanService.selectHrRecruitPlanById(recruitPlanId);
        mmap.put("hrRecruitPlan", hrRecruitPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存招聘计划
     */
    @RequiresPermissions("hr:RecruitPlan:edit")
    @Log(title = "招聘计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrRecruitPlan hrRecruitPlan)
    {
        return toAjax(hrRecruitPlanService.updateHrRecruitPlan(hrRecruitPlan));
    }

    /**
     * 删除招聘计划
     */
    @RequiresPermissions("hr:RecruitPlan:remove")
    @Log(title = "招聘计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrRecruitPlanService.deleteHrRecruitPlanByIds(ids));
    }
}
