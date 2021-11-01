package com.ruoyi.hrm.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.hrm.domain.HrmCalendar;

/**
 * 个人日历Service接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface IHrmCalendarService 
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
     * 批量删除个人日历
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmCalendarByIds(String ids);

    /**
     * 删除个人日历信息
     * 
     * @param eventId 个人日历ID
     * @return 结果
     */
    public int deleteHrmCalendarById(Long eventId);

	public List<HrmCalendar> selectHrmCalendarBetween(HrmCalendar hrmCalendar, Date day5);

	public List<HrmCalendar> selectHrmCalendarSearch(HrmCalendar hrmCalendar);
}
