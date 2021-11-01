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
import com.ruoyi.hrm.domain.HrmTraining;
import com.ruoyi.hrm.service.IHrmTrainingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工培训Controller
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
@Controller
@RequestMapping("/hrm/training")
public class HrmTrainingController extends BaseController
{
    private String prefix = "hrm/training";

    @Autowired
    private IHrmTrainingService hrmTrainingService;

    @RequiresPermissions("hrm:training:view")
    @GetMapping()
    public String training()
    {
        return prefix + "/training";
    }

    /**
     * 查询员工培训列表
     */
    @RequiresPermissions("hrm:training:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmTraining hrmTraining)
    {
        startPage();
        List<HrmTraining> list = hrmTrainingService.selectHrmTrainingList(hrmTraining);
        return getDataTable(list);
    }

    /**
     * 导出员工培训列表
     */
    @RequiresPermissions("hrm:training:export")
    @Log(title = "员工培训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmTraining hrmTraining)
    {
        List<HrmTraining> list = hrmTrainingService.selectHrmTrainingList(hrmTraining);
        ExcelUtil<HrmTraining> util = new ExcelUtil<HrmTraining>(HrmTraining.class);
        return util.exportExcel(list, "员工培训数据");
    }

    /**
     * 新增员工培训
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工培训
     */
    @RequiresPermissions("hrm:training:add")
    @Log(title = "员工培训", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmTraining hrmTraining)
    {
        return toAjax(hrmTrainingService.insertHrmTraining(hrmTraining));
    }

    /**
     * 修改员工培训
     */
    @GetMapping("/edit/{programId}")
    public String edit(@PathVariable("programId") Long programId, ModelMap mmap)
    {
        HrmTraining hrmTraining = hrmTrainingService.selectHrmTrainingById(programId);
        mmap.put("hrmTraining", hrmTraining);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工培训
     */
    @RequiresPermissions("hrm:training:edit")
    @Log(title = "员工培训", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmTraining hrmTraining)
    {
        return toAjax(hrmTrainingService.updateHrmTraining(hrmTraining));
    }

    /**
     * 删除员工培训
     */
    @RequiresPermissions("hrm:training:remove")
    @Log(title = "员工培训", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmTrainingService.deleteHrmTrainingByIds(ids));
    }
}
