package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工合同对象 hrm_employee_contract
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public class HrmEmployeeContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工ID */
    private Long employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 员工部门 */
    @Excel(name = "员工部门")
    private String employeeDepartment;

    /** 合同状态 */
    @Excel(name = "合同状态")
    private String employeeContractStatus;

    /** 员工合同 */
    @Excel(name = "员工合同")
    private String employeeContract;

    /** 有效期至 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireDate;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

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
    public void setEmployeeDepartment(String employeeDepartment) 
    {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeDepartment() 
    {
        return employeeDepartment;
    }
    public void setEmployeeContractStatus(String employeeContractStatus) 
    {
        this.employeeContractStatus = employeeContractStatus;
    }

    public String getEmployeeContractStatus() 
    {
        return employeeContractStatus;
    }
    public void setEmployeeContract(String employeeContract) 
    {
        this.employeeContract = employeeContract;
    }

    public String getEmployeeContract() 
    {
        return employeeContract;
    }
    public void setExpireDate(Date expireDate) 
    {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() 
    {
        return expireDate;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("employeeDepartment", getEmployeeDepartment())
            .append("employeeContractStatus", getEmployeeContractStatus())
            .append("employeeContract", getEmployeeContract())
            .append("expireDate", getExpireDate())
            .append("attachment", getAttachment())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
