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
import com.ruoyi.hr.domain.HrCandidateInfo;
import com.ruoyi.hr.service.IHrCandidateInfoService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应聘人员信息Controller
 * 
 * @author zy
 * @date 2021-03-16
 */
@Controller
@RequestMapping("/hr/CandidateInfo")
public class HrCandidateInfoController extends BaseController
{
    private String prefix = "hr/CandidateInfo";

    @Autowired
    private IHrCandidateInfoService hrCandidateInfoService;
    
    @Autowired
    private ISysPostService postService;

    @RequiresPermissions("hr:CandidateInfo:view")
    @GetMapping()
    public String CandidateInfo()
    {
        return prefix + "/CandidateInfo";
    }

    /**
     * 查询应聘人员信息列表
     */
    @RequiresPermissions("hr:CandidateInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrCandidateInfo hrCandidateInfo)
    {
        startPage();
        List<HrCandidateInfo> list = hrCandidateInfoService.selectHrCandidateInfoList(hrCandidateInfo);
        return getDataTable(list);
    }

    /**
     * 导出应聘人员信息列表
     */
    @RequiresPermissions("hr:CandidateInfo:export")
    @Log(title = "应聘人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrCandidateInfo hrCandidateInfo)
    {
        List<HrCandidateInfo> list = hrCandidateInfoService.selectHrCandidateInfoList(hrCandidateInfo);
        ExcelUtil<HrCandidateInfo> util = new ExcelUtil<HrCandidateInfo>(HrCandidateInfo.class);
        return util.exportExcel(list, "CandidateInfo");
    }

    /**
     * 新增应聘人员信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 新增保存应聘人员信息
     */
    @RequiresPermissions("hr:CandidateInfo:add")
    @Log(title = "应聘人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrCandidateInfo hrCandidateInfo)
    {
    	hrCandidateInfo.setStatus("0");
        return toAjax(hrCandidateInfoService.insertHrCandidateInfo(hrCandidateInfo));
    }

    /**
     * 修改应聘人员信息
     */
    @GetMapping("/edit/{candidateId}")
    public String edit(@PathVariable("candidateId") Long candidateId, ModelMap mmap)
    {
        HrCandidateInfo hrCandidateInfo = hrCandidateInfoService.selectHrCandidateInfoById(candidateId);
        mmap.put("hrCandidateInfo", hrCandidateInfo);
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/edit";
    }

    /**
     * 修改保存应聘人员信息
     */
    @RequiresPermissions("hr:CandidateInfo:edit")
    @Log(title = "应聘人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrCandidateInfo hrCandidateInfo)
    {
        return toAjax(hrCandidateInfoService.updateHrCandidateInfo(hrCandidateInfo));
    }

    /**
     * 删除应聘人员信息
     */
    @RequiresPermissions("hr:CandidateInfo:remove")
    @Log(title = "应聘人员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrCandidateInfoService.deleteHrCandidateInfoByIds(ids));
    }
    
    
    /**
     * 外部链接填写应聘人员信息
     */
    @GetMapping("/inputadd")
    public String inputadd()
    {
        return prefix + "/inputAdd";
    }
    
    
    /**
     * 外部链接填写应聘人员信息保存记录
     */
    @PostMapping("/inputsave")
    @ResponseBody
    public AjaxResult inputsave(HrCandidateInfo hrCandidateInfo)
    {
    	 hrCandidateInfo.setStatus("0");
    	 hrCandidateInfo.setSourceFor("外部链接填写");
    	 return toAjax(hrCandidateInfoService.insertHrCandidateInfo(hrCandidateInfo));
    }

    
    /**
     * 填写完成跳转
     */
    @GetMapping("/inputsucess")
    public String inputsucess()
    {
        return prefix + "/inputsucess";
    }
}
