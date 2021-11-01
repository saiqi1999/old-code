package com.ruoyi.hrm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每周日程对象 hrm_diary
 * 
 * @author 羊驼
 * @date 2021-06-03
 */
public class HrmDiary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件ID */
    private Long diaryId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String aboutUser;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String diaryTitle;

    /** 事件信息 */
    @Excel(name = "事件信息")
    private String diaryInfo;

    /** 星期几 */
    @Excel(name = "星期几")
    private Integer dayOfWeek;

    /** 时间段 */
    @Excel(name = "时间段")
    private String diaryPeriod;

    public void setDiaryId(Long diaryId) 
    {
        this.diaryId = diaryId;
    }

    public Long getDiaryId() 
    {
        return diaryId;
    }
    public void setAboutUser(String aboutUser) 
    {
        this.aboutUser = aboutUser;
    }

    public String getAboutUser() 
    {
        return aboutUser;
    }
    public void setDiaryTitle(String diaryTitle) 
    {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryTitle() 
    {
        return diaryTitle;
    }
    public void setDiaryInfo(String diaryInfo) 
    {
        this.diaryInfo = diaryInfo;
    }

    public String getDiaryInfo() 
    {
        return diaryInfo;
    }
    public void setDayOfWeek(Integer dayOfWeek) 
    {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfWeek() 
    {
        return dayOfWeek;
    }
    public void setDiaryPeriod(String diaryPeriod) 
    {
        this.diaryPeriod = diaryPeriod;
    }

    public String getDiaryPeriod() 
    {
        return diaryPeriod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("diaryId", getDiaryId())
            .append("aboutUser", getAboutUser())
            .append("diaryTitle", getDiaryTitle())
            .append("diaryInfo", getDiaryInfo())
            .append("dayOfWeek", getDayOfWeek())
            .append("diaryPeriod", getDiaryPeriod())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
