package com.ruoyi.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.hrm.domain.HrmCalendar;
import com.ruoyi.hrm.mapper.HrmCalendarMapper;
import com.ruoyi.hrm.service.IHrmCalendarService;

@Service
public class HrmCalendarServiceImpl implements IHrmCalendarService {

	@Autowired
	HrmCalendarMapper hrmCalendarMapper;
	@Override
	public HrmCalendar selectHrmCalendarById(Long eventId) {
		
		return hrmCalendarMapper.selectHrmCalendarById(eventId);
	}

	@Override
	public List<HrmCalendar> selectHrmCalendarList(HrmCalendar hrmCalendar) {
		return hrmCalendarMapper.selectHrmCalendarList(hrmCalendar);
	}

	@Override
	public int insertHrmCalendar(HrmCalendar hrmCalendar) {
		return hrmCalendarMapper.insertHrmCalendar(hrmCalendar);
	}

	@Override
	public int updateHrmCalendar(HrmCalendar hrmCalendar) {
		return hrmCalendarMapper.updateHrmCalendar(hrmCalendar);
	}

	@Override
	public int deleteHrmCalendarByIds(String ids) {
		return hrmCalendarMapper.deleteHrmCalendarByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteHrmCalendarById(Long eventId) {
		return hrmCalendarMapper.deleteHrmCalendarById(eventId);
	}

	@Override
	public List<HrmCalendar> selectHrmCalendarBetween(HrmCalendar hrmCalendar, Date day5) {
		return hrmCalendarMapper.selectHrmCalendarBetween(hrmCalendar.getAboutUser(), hrmCalendar.getEventStartDate(), day5);
	}

	@Override
	public List<HrmCalendar> selectHrmCalendarSearch(HrmCalendar hrmCalendar) {
		return hrmCalendarMapper.selectHrmCalendarSearch(hrmCalendar);
	}

}
