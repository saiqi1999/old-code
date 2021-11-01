package com.ruoyi.hrm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.hrm.domain.HrmCalendar;
import com.ruoyi.hrm.domain.HrmMyLog;


/**
 * 个人驾驶舱Mapper接口
 * 
 * @author ruoyi1
 * @date 2021-06-07
 */
public interface HrmMyLogMapper 
{
    /**
     * 查询个人驾驶舱
     * 
     * @param operId 个人驾驶舱ID
     * @return 个人驾驶舱
     */
    public HrmMyLog selectHrmMyLogById(Long operId);

    /**
     * 查询个人驾驶舱列表
     * 
     * @param HrmMyLog 个人驾驶舱
     * @return 个人驾驶舱集合
     */
    public List<HrmMyLog> selectHrmMyLogList(HrmMyLog hrmMyLog);
    
    /**
     * 选取指定时间跟用户的操作记录
     * @param hrmCalendar
     * @param day5
     * @return
     */
	public List<HrmMyLog> selectHrmMyLogBetween(@Param("operName")String operName, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    /**
     * 新增个人驾驶舱
     * 
     * @param HrmMyLog 个人驾驶舱
     * @return 结果
     */
    public int insertHrmMyLog(HrmMyLog hrmMyLog);

    /**
     * 修改个人驾驶舱
     * 
     * @param HrmMyLog 个人驾驶舱
     * @return 结果
     */
    public int updateHrmMyLog(HrmMyLog hrmMyLog);

    /**
     * 删除个人驾驶舱
     * 
     * @param operId 个人驾驶舱ID
     * @return 结果
     */
    public int deleteHrmMyLogById(Long operId);

    /**
     * 批量删除个人驾驶舱
     * 
     * @param operIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmMyLogByIds(String[] operIds);
}

