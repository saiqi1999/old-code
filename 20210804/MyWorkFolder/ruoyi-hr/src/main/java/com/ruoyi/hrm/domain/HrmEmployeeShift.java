package com.ruoyi.hrm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工调动对象 hrm_employee_shift
 * 
 * @author ruoyi
 * @date 2021-06-24
 */
public class HrmEmployeeShift extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 调动信息ID */
    private Long shiftId;

    /** 员工ID */
    @Excel(name = "员工ID")
    private Long employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 前部门 */
    @Excel(name = "前部门")
    private String employeeExDepartment;

    /** 前岗位 */
    private String employeeExPost;

    /** 前工种 */
    private String employeeExType;

    /** 前职务 */
    private String employeeExJob;

    /** 前职称 */
    private String employeeExTitle;

    /** 员工部门 */
    @Excel(name = "员工部门")
    private String employeeDepartment;

    /** 员工岗位 */
    private String employeePost;

    /** 员工工种 */
    private String employeeType;

    /** 员工职务 */
    private String employeeJob;

    /** 员工职称 */
    private String employeeTitle;

    /** 员工状态 */
    @Excel(name = "员工状态")
    private String employeeStatus;

    public void setShiftId(Long shiftId) 
    {
        this.shiftId = shiftId;
    }

    public Long getShiftId() 
    {
        return shiftId;
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
    public void setEmployeeExDepartment(String employeeExDepartment) 
    {
        this.employeeExDepartment = employeeExDepartment;
    }

    public String getEmployeeExDepartment() 
    {
        return employeeExDepartment;
    }
    public void setEmployeeExPost(String employeeExPost) 
    {
        this.employeeExPost = employeeExPost;
    }

    public String getEmployeeExPost() 
    {
        return employeeExPost;
    }
    public void setEmployeeExType(String employeeExType) 
    {
        this.employeeExType = employeeExType;
    }

    public String getEmployeeExType() 
    {
        return employeeExType;
    }
    public void setEmployeeExJob(String employeeExJob) 
    {
        this.employeeExJob = employeeExJob;
    }

    public String getEmployeeExJob() 
    {
        return employeeExJob;
    }
    public void setEmployeeExTitle(String employeeExTitle) 
    {
        this.employeeExTitle = employeeExTitle;
    }

    public String getEmployeeExTitle() 
    {
        return employeeExTitle;
    }
    public void setEmployeeDepartment(String employeeDepartment) 
    {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeDepartment() 
    {
        return employeeDepartment;
    }
    public void setEmployeePost(String employeePost) 
    {
        this.employeePost = employeePost;
    }

    public String getEmployeePost() 
    {
        return employeePost;
    }
    public void setEmployeeType(String employeeType) 
    {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() 
    {
        return employeeType;
    }
    public void setEmployeeJob(String employeeJob) 
    {
        this.employeeJob = employeeJob;
    }

    public String getEmployeeJob() 
    {
        return employeeJob;
    }
    public void setEmployeeTitle(String employeeTitle) 
    {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeTitle() 
    {
        return employeeTitle;
    }
    public void setEmployeeStatus(String employeeStatus) 
    {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeStatus() 
    {
        return employeeStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shiftId", getShiftId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("employeeExDepartment", getEmployeeExDepartment())
            .append("employeeExPost", getEmployeeExPost())
            .append("employeeExType", getEmployeeExType())
            .append("employeeExJob", getEmployeeExJob())
            .append("employeeExTitle", getEmployeeExTitle())
            .append("employeeDepartment", getEmployeeDepartment())
            .append("employeePost", getEmployeePost())
            .append("employeeType", getEmployeeType())
            .append("employeeJob", getEmployeeJob())
            .append("employeeTitle", getEmployeeTitle())
            .append("employeeStatus", getEmployeeStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
