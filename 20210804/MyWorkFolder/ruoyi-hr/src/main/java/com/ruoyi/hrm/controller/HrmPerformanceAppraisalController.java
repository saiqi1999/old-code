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
import com.ruoyi.hrm.domain.HrmPerformanceAppraisal;
import com.ruoyi.hrm.service.IHrmPerformanceAppraisalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工考核Controller
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Controller
@RequestMapping("/hrm/appraisal")
public class HrmPerformanceAppraisalController extends BaseController
{
    private String prefix = "hrm/appraisal";

    @Autowired
    private IHrmPerformanceAppraisalService hrmPerformanceAppraisalService;

    @RequiresPermissions("hrm:appraisal:view")
    @GetMapping()
    public String appraisal()
    {
        return prefix + "/appraisal";
    }

    /**
     * 查询员工考核列表
     */
    @RequiresPermissions("hrm:appraisal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        startPage();
        List<HrmPerformanceAppraisal> list = hrmPerformanceAppraisalService.selectHrmPerformanceAppraisalList(hrmPerformanceAppraisal);
        return getDataTable(list);
    }

    /**
     * 导出员工考核列表
     */
    @RequiresPermissions("hrm:appraisal:export")
    @Log(title = "员工考核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        List<HrmPerformanceAppraisal> list = hrmPerformanceAppraisalService.selectHrmPerformanceAppraisalList(hrmPerformanceAppraisal);
        ExcelUtil<HrmPerformanceAppraisal> util = new ExcelUtil<HrmPerformanceAppraisal>(HrmPerformanceAppraisal.class);
        return util.exportExcel(list, "员工考核数据");
    }

    /**
     * 新增员工考核
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工考核
     */
    @RequiresPermissions("hrm:appraisal:add")
    @Log(title = "员工考核", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        return toAjax(hrmPerformanceAppraisalService.insertHrmPerformanceAppraisal(hrmPerformanceAppraisal));
    }

    /**
     * 修改员工考核
     */
    @GetMapping("/edit/{appraisalId}")
    public String edit(@PathVariable("appraisalId") Long appraisalId, ModelMap mmap)
    {
        HrmPerformanceAppraisal hrmPerformanceAppraisal = hrmPerformanceAppraisalService.selectHrmPerformanceAppraisalById(appraisalId);
        mmap.put("hrmPerformanceAppraisal", hrmPerformanceAppraisal);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工考核
     */
    @RequiresPermissions("hrm:appraisal:edit")
    @Log(title = "员工考核", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        return toAjax(hrmPerformanceAppraisalService.updateHrmPerformanceAppraisal(hrmPerformanceAppraisal));
    }

    /**
     * 删除员工考核
     */
    @RequiresPermissions("hrm:appraisal:remove")
    @Log(title = "员工考核", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmPerformanceAppraisalService.deleteHrmPerformanceAppraisalByIds(ids));
    }
}
