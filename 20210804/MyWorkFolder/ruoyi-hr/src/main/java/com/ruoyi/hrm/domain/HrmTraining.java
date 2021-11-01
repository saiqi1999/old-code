package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工培训对象 hrm_training
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public class HrmTraining extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 培训批次ID */
    @Excel(name = "培训批次ID")
    private Long programId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private Long programName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 培训类型 */
    @Excel(name = "培训类型")
    private String programType;

    /** 培训方式 */
    @Excel(name = "培训方式")
    private String programMethod;

    /** 培训年份 */
    @Excel(name = "培训年份")
    private String programYear;

    /** 培训地点 */
    @Excel(name = "培训地点")
    private String programPlace;

    /** 主持人 */
    @Excel(name = "主持人")
    private String programHost;

    /** 记录人员 */
    @Excel(name = "记录人员")
    private String programDocument;

    /** 培训单位 */
    @Excel(name = "培训单位")
    private String programDepartment;

    /** 培训目标 */
    @Excel(name = "培训目标")
    private String programGoal;

    /** 培训内容 */
    @Excel(name = "培训内容")
    private String programContent;

    public void setProgramId(Long programId) 
    {
        this.programId = programId;
    }

    public Long getProgramId() 
    {
        return programId;
    }
    public void setProgramName(Long programName) 
    {
        this.programName = programName;
    }

    public Long getProgramName() 
    {
        return programName;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setProgramType(String programType) 
    {
        this.programType = programType;
    }

    public String getProgramType() 
    {
        return programType;
    }
    public void setProgramMethod(String programMethod) 
    {
        this.programMethod = programMethod;
    }

    public String getProgramMethod() 
    {
        return programMethod;
    }
    public void setProgramYear(String programYear) 
    {
        this.programYear = programYear;
    }

    public String getProgramYear() 
    {
        return programYear;
    }
    public void setProgramPlace(String programPlace) 
    {
        this.programPlace = programPlace;
    }

    public String getProgramPlace() 
    {
        return programPlace;
    }
    public void setProgramHost(String programHost) 
    {
        this.programHost = programHost;
    }

    public String getProgramHost() 
    {
        return programHost;
    }
    public void setProgramDocument(String programDocument) 
    {
        this.programDocument = programDocument;
    }

    public String getProgramDocument() 
    {
        return programDocument;
    }
    public void setProgramDepartment(String programDepartment) 
    {
        this.programDepartment = programDepartment;
    }

    public String getProgramDepartment() 
    {
        return programDepartment;
    }
    public void setProgramGoal(String programGoal) 
    {
        this.programGoal = programGoal;
    }

    public String getProgramGoal() 
    {
        return programGoal;
    }
    public void setProgramContent(String programContent) 
    {
        this.programContent = programContent;
    }

    public String getProgramContent() 
    {
        return programContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("programId", getProgramId())
            .append("programName", getProgramName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("programType", getProgramType())
            .append("programMethod", getProgramMethod())
            .append("programYear", getProgramYear())
            .append("programPlace", getProgramPlace())
            .append("programHost", getProgramHost())
            .append("programDocument", getProgramDocument())
            .append("programDepartment", getProgramDepartment())
            .append("programGoal", getProgramGoal())
            .append("programContent", getProgramContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
