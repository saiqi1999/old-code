package com.ruoyi.hr.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 招聘计划对象 hr_recruit_plan
 * 
 * @author zy
 * @date 2019-10-30
 */
public class HrRecruitPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘计划ID */
    private Long recruitPlanId;

    /** 招聘申请ID */
    @Excel(name = "招聘申请ID")
    private Long recruitId;

    /** 实际完成时间 */
    @Excel(name = "实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planCompleteTime;

    /** 实际招聘人数 */
    @Excel(name = "实际招聘人数")
    private Long pepCompleteNum;

    public void setRecruitPlanId(Long recruitPlanId) 
    {
        this.recruitPlanId = recruitPlanId;
    }

    public Long getRecruitPlanId() 
    {
        return recruitPlanId;
    }
    public void setRecruitId(Long recruitId) 
    {
        this.recruitId = recruitId;
    }

    public Long getRecruitId() 
    {
        return recruitId;
    }
    public void setPlanCompleteTime(Date planCompleteTime) 
    {
        this.planCompleteTime = planCompleteTime;
    }

    public Date getPlanCompleteTime() 
    {
        return planCompleteTime;
    }
    public void setPepCompleteNum(Long pepCompleteNum) 
    {
        this.pepCompleteNum = pepCompleteNum;
    }

    public Long getPepCompleteNum() 
    {
        return pepCompleteNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recruitPlanId", getRecruitPlanId())
            .append("recruitId", getRecruitId())
            .append("planCompleteTime", getPlanCompleteTime())
            .append("pepCompleteNum", getPepCompleteNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
