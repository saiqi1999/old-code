package com.ruoyi.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.ruoyi.hrm.domain.HrmCalendar;
import com.ruoyi.hrm.service.IHrmCalendarService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人日历Controller
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
@Controller
@RequestMapping("/hrm/calendar")
public class HrmCalendarController extends BaseController
{
    private String prefix = "hrm/calendar";

    @Autowired
    private IHrmCalendarService hrmCalendarService;

    @RequiresPermissions("hrm:calendar:view")
    @GetMapping()
    public String calendar(ModelMap mmap)
    {
    	System.out.println("++++++++++++++get calendar page+++++++++++++++");
//    	ArrayList<HrmCalendar> hrmL = new ArrayList<>();
//    	HrmCalendar hrmC = new HrmCalendar();
//    	hrmC.setEventStartDate(null);
//    	hrmC.setEventStartTime("11:00");
//    	hrmC.setEventEndTime("12:00");
//    	hrmL.add(hrmC);
//    	HrmCalendar hrmC2 = new HrmCalendar();
//    	hrmC2.setEventStartTime("12:00");
//    	hrmC2.setEventEndTime("13:00");
//    	hrmL.add(hrmC2);
//    	mmap.put("hrmC", hrmC);
//    	mmap.put("hrmL", hrmL);
//    	mmap.put("date", new Date());

    	//首先查到要显示的日程，按照date去找
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	//System.out.println(i);
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
        HrmCalendar hrmCalendar = new HrmCalendar();
        hrmCalendar.setAboutUser(loginName);
        //时分秒毫秒被网页端选择控件刷掉了，如果想利用原有接口，就把自己的也刷掉
        Date d = new Date();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        try {
			d = dfs.parse(DateUtils.parseDateToStr("YYYY-MM-dd", d));
		} catch (ParseException e) {
			// nothing TODO Auto-generated catch block
			e.printStackTrace();
		}
        hrmCalendar.setEventStartDate(d);
        mmap.put("date", DateUtils.parseDateToStr("YYYY-MM-dd", d));
        //查找想要显示的日程时，使用一个新的服务，内容是查找当日到当日五天后的所有日程
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        c.add(Calendar.DATE, 5);
        Date day5 = c.getTime();
        List<HrmCalendar> list = hrmCalendarService.selectHrmCalendarBetween(hrmCalendar,day5);
    	//System.out.print("要显示的日程门"+list.toString()+d.toString());
//        List<HrmCalendar> list = hrmCalendarService.selectHrmCalendarList(hrmCalendar);
//    	System.out.print("要显示的日程门"+list.toString()+d.toString());
    	mmap.put("list", list);
        return prefix + "/calendar";
    }

    /**
     * 查询个人日历列表
     */
    @RequiresPermissions("hrm:calendar:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrmCalendar hrmCalendar)
    {
        startPage();
        //System.out.println(hrmCalendar.toString());
        String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
        hrmCalendar.setAboutUser(loginName);
        
        if(hrmCalendar.getEventStartDate()!=null) {
        	//说明是搜索来的，不是初始化来的，就去搜索那个值
        	List<HrmCalendar> list = hrmCalendarService.selectHrmCalendarSearch(hrmCalendar);
            return getDataTable(list);
        }
        
        Date d = new Date();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        try {
			d = dfs.parse(DateUtils.parseDateToStr("YYYY-MM-dd", d));
		} catch (ParseException e) {
			// nothing TODO Auto-generated catch block
			e.printStackTrace();
		}
        hrmCalendar.setEventStartDate(d);
        
        //直接修改了SQL语句，只能查出今天以后的日程（过期的日程是没用的）
        List<HrmCalendar> list = hrmCalendarService.selectHrmCalendarList(hrmCalendar);
        return getDataTable(list);
    }

    /**
     * 导出个人日历列表
     */
    @RequiresPermissions("hrm:calendar:export")
    @Log(title = "个人日历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrmCalendar hrmCalendar)
    {
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
        hrmCalendar.setAboutUser(loginName);
        
        
        Date d = new Date();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        try {
			d = dfs.parse(DateUtils.parseDateToStr("YYYY-MM-dd", d));
		} catch (ParseException e) {
			// nothing TODO Auto-generated catch block
			e.printStackTrace();
		}
        hrmCalendar.setEventStartDate(d);
        List<HrmCalendar> list = hrmCalendarService.selectHrmCalendarList(hrmCalendar);
        ExcelUtil<HrmCalendar> util = new ExcelUtil<HrmCalendar>(HrmCalendar.class);
        return util.exportExcel(list, "个人日历数据");
    }

    /**
     * 新增个人日历
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人日历
     */
    @RequiresPermissions("hrm:calendar:add")
    @Log(title = "个人日历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrmCalendar hrmCalendar)
    {
    	
    	System.out.println("---------------hrm calendar add--------------");
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
        hrmCalendar.setAboutUser(loginName);
        HrmCalendar sample = new HrmCalendar();
        sample.setAboutUser(loginName);
        List<HrmCalendar> userEvent = hrmCalendarService.selectHrmCalendarList(sample); 
        
        for(HrmCalendar h : userEvent) {
        	if(h.getEventStartDate().equals(hrmCalendar.getEventStartDate())) {
        		int sampleStartHour = Integer.parseInt(h.getEventStartTime().split(":")[0].trim());
        		int sampleStartMin = Integer.parseInt(h.getEventStartTime().split(":")[1].trim());
        		int myStartHour = Integer.parseInt(hrmCalendar.getEventStartTime().split(":")[0].trim());
        		int myStartMin = Integer.parseInt(hrmCalendar.getEventStartTime().split(":")[1].trim());
        		
        		int sampleEndHour = Integer.parseInt(h.getEventEndTime().split(":")[0].trim());
        		int sampleEndMin = Integer.parseInt(h.getEventEndTime().split(":")[1].trim());
        		int myEndHour = Integer.parseInt(hrmCalendar.getEventEndTime().split(":")[0].trim());
        		int myEndMin = Integer.parseInt(hrmCalendar.getEventEndTime().split(":")[1].trim());
        		
        		
        		if(myEndHour<myStartHour||(myEndHour==myStartHour&&myEndMin<myStartMin)) {
        			//System.out.println(1);
        			
        			return AjaxResult.error("日程的开始与结束时间不匹配");
        		}
        		if(sampleStartHour==myEndHour&&sampleStartMin<myEndMin&&myStartHour<sampleEndHour) {
        			//System.out.println(2);
        			return AjaxResult.error("日程结束时间冲突，无法设置日程");
        		}
    			if(sampleEndMin>myStartMin&&sampleEndHour==myStartHour&&myEndHour>sampleStartHour) {
    				//System.out.println(3);
    				return AjaxResult.error("日程开始时间冲突，无法设置日程");
    			}
        		if(sampleStartHour>=myEndHour||sampleEndHour<=myStartHour) {
        			//System.out.println("passed_1");
        			continue;
        			//每个人的计划只是一小部分，所以可以全部取出来逐一比对是否有时间冲突。
        	        //在数据较多的场合，借用sql语句筛选应该能优化不少
        	        //System.out.println(hrmCalendar.toString());
        		}else {
        			//System.out.println("collision on start hour");
        			return AjaxResult.error("时间冲突，无法设置日程");
        		}
        		
        	}
        }
        AjaxResult ar = toAjax(hrmCalendarService.insertHrmCalendar(hrmCalendar));
        System.out.println("---------------hrm calendar add--------------");
        return ar;
        
    }

    /**
     * 修改个人日历
     */
    @GetMapping("/edit/{eventId}")
    public String edit(@PathVariable("eventId") Long eventId, ModelMap mmap)
    {
        HrmCalendar hrmCalendar = hrmCalendarService.selectHrmCalendarById(eventId);
        mmap.put("hrmCalendar", hrmCalendar);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人日历
     */
    @RequiresPermissions("hrm:calendar:edit")
    @Log(title = "个人日历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrmCalendar hrmCalendar)
    {
    	String loginName = "";
        String[] frags = SecurityUtils.getSubject().getPrincipal().toString().split(" ");
        for(String i : frags) {
        	if(i.startsWith("loginName")) {
        		loginName=i.split("=")[1].trim();
        		System.out.println(loginName);
        	}
        }
        hrmCalendar.setAboutUser(loginName);
        HrmCalendar sample = new HrmCalendar();
        sample.setAboutUser(loginName);
        List<HrmCalendar> userEvent = hrmCalendarService.selectHrmCalendarList(sample); 
        
        for(HrmCalendar h : userEvent) {
        	if(h.getEventId().equals(hrmCalendar.getEventId()))continue;
        	if(h.getEventStartDate().equals(hrmCalendar.getEventStartDate())) {
        		int sampleStartHour = Integer.parseInt(h.getEventStartTime().split(":")[0].trim());
        		int sampleStartMin = Integer.parseInt(h.getEventStartTime().split(":")[1].trim());
        		int myStartHour = Integer.parseInt(hrmCalendar.getEventStartTime().split(":")[0].trim());
        		int myStartMin = Integer.parseInt(hrmCalendar.getEventStartTime().split(":")[1].trim());
        		
        		int sampleEndHour = Integer.parseInt(h.getEventEndTime().split(":")[0].trim());
        		int sampleEndMin = Integer.parseInt(h.getEventEndTime().split(":")[1].trim());
        		int myEndHour = Integer.parseInt(hrmCalendar.getEventEndTime().split(":")[0].trim());
        		int myEndMin = Integer.parseInt(hrmCalendar.getEventEndTime().split(":")[1].trim());
        		
        		
        		if(myEndHour<myStartHour||(myEndHour==myStartHour&&myEndMin<myStartMin)) {
        			//System.out.println(1);
        			
        			return AjaxResult.error("日程的开始与结束时间不匹配");
        		}
        		if(sampleStartHour==myEndHour&&sampleStartMin<myEndMin&&myStartHour<sampleEndHour) {
        			//System.out.println(2);
        			return AjaxResult.error("日程结束时间冲突，无法设置日程");
        		}
    			if(sampleEndMin>myStartMin&&sampleEndHour==myStartHour&&myEndHour>sampleStartHour) {
    				//System.out.println(3);
    				return AjaxResult.error("日程开始时间冲突，无法设置日程");
    			}
        		if(sampleStartHour>=myEndHour||sampleEndHour<=myStartHour) {
        			//System.out.println("passed_1");
        			continue;
        			//每个人的计划只是一小部分，所以可以全部取出来逐一比对是否有时间冲突。
        	        //在数据较多的场合，借用sql语句筛选应该能优化不少
        	        //System.out.println(hrmCalendar.toString());
        		}else {
        			//System.out.println("collision on start hour");
        			return AjaxResult.error("时间冲突，无法设置日程");
        		}
        		
        	}
        }
        AjaxResult ar = toAjax(hrmCalendarService.updateHrmCalendar(hrmCalendar));
        System.out.println("---------------hrm calendar edit--------------");
        return ar;
    }

    /**
     * 删除个人日历
     */
    @RequiresPermissions("hrm:calendar:remove")
    @Log(title = "个人日历", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrmCalendarService.deleteHrmCalendarByIds(ids));
    }
}
