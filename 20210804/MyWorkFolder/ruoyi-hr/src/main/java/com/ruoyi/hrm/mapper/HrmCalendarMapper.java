package com.ruoyi.hrm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.hrm.domain.HrmCalendar;

/**
 * 个人日历Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface HrmCalendarMapper 
{
    /**
     * 查询个人日历
     * 
     * @param eventId 个人日历ID
     * @return 个人日历
     */
    public HrmCalendar selectHrmCalendarById(Long eventId);

    /**
     * 查询个人日历列表
     * 
     * @param hrmCalendar 个人日历
     * @return 个人日历集合
     */
    public List<HrmCalendar> selectHrmCalendarList(HrmCalendar hrmCalendar);

    /**
     * 新增个人日历
     * 
     * @param hrmCalendar 个人日历
     * @return 结果
     */
    public int insertHrmCalendar(HrmCalendar hrmCalendar);

    /**
     * 修改个人日历
     * 
     * @param hrmCalendar 个人日历
     * @return 结果
     */
    public int updateHrmCalendar(HrmCalendar hrmCalendar);

    /**
     * 删除个人日历
     * 
     * @param eventId 个人日历ID
     * @return 结果
     */
    public int deleteHrmCalendarById(Long eventId);

    /**
     * 批量删除个人日历
     * 
     * @param eventIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmCalendarByIds(String[] eventIds);
    
    /**
     * 选取指定时间跟用户的个人日力
     * @param hrmCalendar
     * @param day5
     * @return
     */
	public List<HrmCalendar> selectHrmCalendarBetween(@Param("aboutUser")String aboutUser, @Param("startDate")Date day, @Param("endDate")Date day5);

	/**
	 * 修复一下改了list查询的副作用
	 * @param hrmCalendar
	 * @return
	 */
	public List<HrmCalendar> selectHrmCalendarSearch(HrmCalendar hrmCalendar);
}
