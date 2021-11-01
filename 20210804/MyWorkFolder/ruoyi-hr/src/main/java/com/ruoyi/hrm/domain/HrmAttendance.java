package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工考勤对象 hrm_attendance
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public class HrmAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤ID */
    private Long attendanceId;

    /** 员工ID */
    @Excel(name = "员工ID")
    private Long employeeId;

    /** 员工名称 */
    @Excel(name = "员工名称")
    private String employeeName;

    /** 考勤时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考勤时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceDate;

    /** 考勤结果 */
    @Excel(name = "考勤结果")
    private String attendanceType;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    public void setAttendanceId(Long attendanceId) 
    {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId() 
    {
        return attendanceId;
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
    public void setAttendanceDate(Date attendanceDate) 
    {
        this.attendanceDate = attendanceDate;
    }

    public Date getAttendanceDate() 
    {
        return attendanceDate;
    }
    public void setAttendanceType(String attendanceType) 
    {
        this.attendanceType = attendanceType;
    }

    public String getAttendanceType() 
    {
        return attendanceType;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attendanceId", getAttendanceId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("attendanceDate", getAttendanceDate())
            .append("attendanceType", getAttendanceType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
