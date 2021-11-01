package com.ruoyi.hrm.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.hrm.domain.HrmMyLog;
import com.ruoyi.hrm.service.IHrmMyLogService;

@Controller
@RequestMapping("/hrm/log")
public class HrmMyLogController extends BaseController {

	@Autowired
	IHrmMyLogService hrmMyLogService;
	
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
	
	@RequiresPermissions("hrm:log:view")
	@GetMapping()
	public String myLog(ModelMap mmap) {
		Date endDate = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(endDate);
		c.add(Calendar.MONTH, -1);
		Date startDate = c.getTime();
		List<HrmMyLog> list = hrmMyLogService.selectHrmMyLogBetween(getLoginName(), startDate, endDate);
		HashMap<String,Integer> saveMap = new HashMap<>();
		HashMap<String,String> urlMap = new HashMap<>();
		for(HrmMyLog cur : list) {
			if(saveMap.get(cur.getTitle())!=null) {
				saveMap.put(cur.getTitle(), saveMap.get(cur.getTitle())+1);
				String[] frags = cur.getOperUrl().split("/");
				urlMap.put(cur.getTitle(), "/"+frags[1]+"/"+frags[2]);
			}
			else {
				saveMap.put(cur.getTitle(), 1);
				String[] frags = cur.getOperUrl().split("/");
				urlMap.put(cur.getTitle(), "/"+frags[1]+"/"+frags[2]);
			}
		}
		mmap.put("list", saveMap);
		mmap.put("urlList", urlMap);
		return("hrm/log/log");
	}
	
}
