package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人日历对象 hrm_calendar
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public class HrmCalendar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件ID */
    private Long eventId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String aboutUser;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String eventTitle;

    /** 事件信息 */
    @Excel(name = "事件信息")
    private String eventInfo;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventStartDate;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String eventStartTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String eventEndTime;

    public void setEventId(Long eventId) 
    {
        this.eventId = eventId;
    }

    public Long getEventId() 
    {
        return eventId;
    }
    public void setAboutUser(String aboutUser) 
    {
        this.aboutUser = aboutUser;
    }

    public String getAboutUser() 
    {
        return aboutUser;
    }
    public void setEventTitle(String eventTitle) 
    {
        this.eventTitle = eventTitle;
    }

    public String getEventTitle() 
    {
        return eventTitle;
    }
    public void setEventInfo(String eventInfo) 
    {
        this.eventInfo = eventInfo;
    }

    public String getEventInfo() 
    {
        return eventInfo;
    }
    public void setEventStartDate(Date eventStartDate) 
    {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventStartDate() 
    {
        return eventStartDate;
    }
    public void setEventStartTime(String eventStartTime) 
    {
        this.eventStartTime = eventStartTime;
    }

    public String getEventStartTime() 
    {
        return eventStartTime;
    }
    public void setEventEndTime(String eventEndTime) 
    {
        this.eventEndTime = eventEndTime;
    }

    public String getEventEndTime() 
    {
        return eventEndTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eventId", getEventId())
            .append("aboutUser", getAboutUser())
            .append("eventTitle", getEventTitle())
            .append("eventInfo", getEventInfo())
            .append("eventStartDate", getEventStartDate())
            .append("eventStartTime", getEventStartTime())
            .append("eventEndTime", getEventEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
