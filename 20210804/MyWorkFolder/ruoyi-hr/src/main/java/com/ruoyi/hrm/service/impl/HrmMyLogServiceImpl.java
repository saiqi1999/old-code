package com.ruoyi.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.hrm.domain.HrmMyLog;
import com.ruoyi.hrm.mapper.HrmMyLogMapper;
import com.ruoyi.hrm.service.IHrmMyLogService;
@Service
public class HrmMyLogServiceImpl implements IHrmMyLogService {

	@Autowired
	HrmMyLogMapper hrmMyLogMapper;
	
	@Override
	public List<HrmMyLog> selectHrmMylogList(HrmMyLog hrmMyLog) {
		
		return hrmMyLogMapper.selectHrmMyLogList(hrmMyLog);
	}

	@Override
	public List<HrmMyLog> selectHrmMyLogBetween(String operName, Date startDate, Date endDate) {

		return hrmMyLogMapper.selectHrmMyLogBetween(operName, startDate, endDate);
	}

}
