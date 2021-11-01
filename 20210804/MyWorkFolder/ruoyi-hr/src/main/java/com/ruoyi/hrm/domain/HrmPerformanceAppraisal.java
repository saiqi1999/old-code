package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工考核对象 hrm_performance_appraisal
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public class HrmPerformanceAppraisal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考核ID */
    private Long appraisalId;

    /** 员工ID */
    @Excel(name = "员工ID")
    private Long employeeId;

    /** 员工名称 */
    @Excel(name = "员工名称")
    private String employeeName;

    /** 考核类型 */
    @Excel(name = "考核类型")
    private String appraisalType;

    /** 考核期间 */
    @Excel(name = "考核期间")
    private String appraisalReferTime;

    /** 考核成绩 */
    @Excel(name = "考核成绩")
    private String appraisalGrade;

    /** 考核等级 */
    @Excel(name = "考核等级")
    private String appraisalLevel;

    /** 考核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appraisalDate;

    public void setAppraisalId(Long appraisalId) 
    {
        this.appraisalId = appraisalId;
    }

    public Long getAppraisalId() 
    {
        return appraisalId;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setAppraisalType(String appraisalType) 
    {
        this.appraisalType = appraisalType;
    }

    public String getAppraisalType() 
    {
        return appraisalType;
    }
    public void setAppraisalReferTime(String appraisalReferTime) 
    {
        this.appraisalReferTime = appraisalReferTime;
    }

    public String getAppraisalReferTime() 
    {
        return appraisalReferTime;
    }
    public void setAppraisalGrade(String appraisalGrade) 
    {
        this.appraisalGrade = appraisalGrade;
    }

    public String getAppraisalGrade() 
    {
        return appraisalGrade;
    }
    public void setAppraisalLevel(String appraisalLevel) 
    {
        this.appraisalLevel = appraisalLevel;
    }

    public String getAppraisalLevel() 
    {
        return appraisalLevel;
    }
    public void setAppraisalDate(Date appraisalDate) 
    {
        this.appraisalDate = appraisalDate;
    }

    public Date getAppraisalDate() 
    {
        return appraisalDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appraisalId", getAppraisalId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("appraisalType", getAppraisalType())
            .append("appraisalReferTime", getAppraisalReferTime())
            .append("appraisalGrade", getAppraisalGrade())
            .append("appraisalLevel", getAppraisalLevel())
            .append("appraisalDate", getAppraisalDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
