package com.ruoyi.hrm.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
import com.ruoyi.hrm.domain.HrmDiary;
import com.ruoyi.hrm.service.IHrmDiaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 每周日程Controller
 * 
 * @author 羊驼
 * @date 2021-06-03
 */
@Controller
@RequestMapping("/hrm/diary")
public class HrmDiaryController extends BaseController
{
    private String prefix = "hrm/diary";
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

    @Autowired
    private IHrmDiaryService hrmDiaryService;

    @RequiresPermissions("hrm:diary:view")
    @GetMapping()
    public String diary(ModelMap mmap)
    {
    	HrmDiary hrmDiary = new HrmDiary();
    	hrmDiary.setAboutUser(getLoginName());
    	List<HrmDiary> list = hrmDiaryService.selectHrmDiaryList(hrmDiary);
    	mmap.put("list", list);
    	
    	Calendar c = new GregorianCalendar();
    	
		/*
		 * for(int i = 1; i < 10; i++) { c.set(Calendar.DATE, i);
		 * System.out.println(c.get(Calendar.DAY_OF_WEEK)); }
		 */
    	
    	c.set(Calendar.DATE, 1);
    	//System.out.println(c);
    	int ofWeek = c.get(Calendar.DAY_OF_WEEK);
    	//System.out.println(ofWeek);
    	Integer month = c.get(Calendar.MONTH)+1;
    	Integer year = c.get(Calendar.YEAR);
    	c.set(year, month, 0);
    	int numDays = c.get(Calendar.DAY_OF_MONTH);
    	mmap.put("ofWeek", ofWeek);
    	mmap.put("numDays", numDays);
    	
        return prefix + "/diary";
    }

    /**
     * 查询每周日程列表
     */
    @RequiresPermissions("hrm:diary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmDiary hrmDiary)
    {
        startPage();
        hrmDiary.setAboutUser(getLoginName());
        List<HrmDiary> list = hrmDiaryService.selectHrmDiaryList(hrmDiary);
        return getDataTable(list);
    }

    /**
     * 导出每周日程列表
     */
    @RequiresPermissions("hrm:diary:export")
    @Log(title = "每周日程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmDiary hrmDiary)
    {
    	hrmDiary.setAboutUser(getLoginName());
        List<HrmDiary> list = hrmDiaryService.selectHrmDiaryList(hrmDiary);
        ExcelUtil<HrmDiary> util = new ExcelUtil<HrmDiary>(HrmDiary.class);
        return util.exportExcel(list, "每周日程数据");
    }

    /**
     * 新增每周日程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存每周日程
     */
    @RequiresPermissions("hrm:diary:add")
    @Log(title = "每周日程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmDiary hrmDiary)
    {
    	hrmDiary.setAboutUser(getLoginName());
    	HrmDiary sample = new HrmDiary();
    	sample.setAboutUser(getLoginName());
    	sample.setDayOfWeek(hrmDiary.getDayOfWeek());
    	sample.setDiaryPeriod(hrmDiary.getDiaryPeriod());
    	List<HrmDiary> collide = hrmDiaryService.selectHrmDiaryList(sample);
    	if(collide.size()!=0) return AjaxResult.error("时间冲突");
        return toAjax(hrmDiaryService.insertHrmDiary(hrmDiary));
    }

    /**
     * 修改每周日程
     */
    @GetMapping("/edit/{diaryId}")
    public String edit(@PathVariable("diaryId") Long diaryId, ModelMap mmap)
    {
        HrmDiary hrmDiary = hrmDiaryService.selectHrmDiaryById(diaryId);
        mmap.put("hrmDiary", hrmDiary);
        return prefix + "/edit";
    }

    /**
     * 修改保存每周日程
     */
    @RequiresPermissions("hrm:diary:edit")
    @Log(title = "每周日程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmDiary hrmDiary)
    {
    	hrmDiary.setAboutUser(getLoginName());
        return toAjax(hrmDiaryService.updateHrmDiary(hrmDiary));
    }

    /**
     * 删除每周日程
     */
    @RequiresPermissions("hrm:diary:remove")
    @Log(title = "每周日程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmDiaryService.deleteHrmDiaryByIds(ids));
    }
}
