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
import com.ruoyi.hrm.domain.HrmEmployNeed;
import com.ruoyi.hrm.service.IHrmEmployNeedService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘需求Controller
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
@Controller
@RequestMapping("/hrm/need")
public class HrmEmployNeedController extends BaseController
{
    private String prefix = "hrm/need";

    @Autowired
    private IHrmEmployNeedService hrmEmployNeedService;

    @RequiresPermissions("hrm:need:view")
    @GetMapping()
    public String need()
    {
        return prefix + "/need";
    }

    /**
     * 查询招聘需求列表
     */
    @RequiresPermissions("hrm:need:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmEmployNeed hrmEmployNeed)
    {
        startPage();
        List<HrmEmployNeed> list = hrmEmployNeedService.selectHrmEmployNeedList(hrmEmployNeed);
        return getDataTable(list);
    }

    /**
     * 导出招聘需求列表
     */
    @RequiresPermissions("hrm:need:export")
    @Log(title = "招聘需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmEmployNeed hrmEmployNeed)
    {
        List<HrmEmployNeed> list = hrmEmployNeedService.selectHrmEmployNeedList(hrmEmployNeed);
        ExcelUtil<HrmEmployNeed> util = new ExcelUtil<HrmEmployNeed>(HrmEmployNeed.class);
        return util.exportExcel(list, "招聘需求数据");
    }

    /**
     * 新增招聘需求
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招聘需求
     */
    @RequiresPermissions("hrm:need:add")
    @Log(title = "招聘需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmEmployNeed hrmEmployNeed)
    {
        return toAjax(hrmEmployNeedService.insertHrmEmployNeed(hrmEmployNeed));
    }

    /**
     * 修改招聘需求
     */
    @GetMapping("/edit/{employId}")
    public String edit(@PathVariable("employId") Long employId, ModelMap mmap)
    {
        HrmEmployNeed hrmEmployNeed = hrmEmployNeedService.selectHrmEmployNeedById(employId);
        mmap.put("hrmEmployNeed", hrmEmployNeed);
        return prefix + "/edit";
    }

    /**
     * 修改保存招聘需求
     */
    @RequiresPermissions("hrm:need:edit")
    @Log(title = "招聘需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmEmployNeed hrmEmployNeed)
    {
        return toAjax(hrmEmployNeedService.updateHrmEmployNeed(hrmEmployNeed));
    }

    /**
     * 删除招聘需求
     */
    @RequiresPermissions("hrm:need:remove")
    @Log(title = "招聘需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmEmployNeedService.deleteHrmEmployNeedByIds(ids));
    }
}
