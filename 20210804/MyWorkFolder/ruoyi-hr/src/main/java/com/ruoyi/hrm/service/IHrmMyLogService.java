package com.ruoyi.hrm.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.hrm.domain.HrmMyLog;

public interface IHrmMyLogService {
	public List<HrmMyLog> selectHrmMylogList(HrmMyLog hrmMyLog);
	public List<HrmMyLog> selectHrmMyLogBetween(String operName, Date startDate, Date endDate);
}
