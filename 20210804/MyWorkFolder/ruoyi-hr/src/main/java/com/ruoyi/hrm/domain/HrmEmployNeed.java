package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 招聘需求对象 hrm_employ_need
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
public class HrmEmployNeed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘批次ID */
    @Excel(name = "招聘批次ID")
    private Long employId;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long numberNeed;

    /** 员工部门 */
    @Excel(name = "员工部门")
    private String employeeDepartment;

    /** 员工岗位 */
    @Excel(name = "员工岗位")
    private String employeePost;

    /** 员工工种 */
    @Excel(name = "员工工种")
    private String employeeType;

    /** 员工职务 */
    @Excel(name = "员工职务")
    private String employeeJob;

    /** 基础工资 */
    @Excel(name = "基础工资")
    private Long baseSalary;

    /** 员工性别 */
    @Excel(name = "员工性别")
    private String gender;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marriage;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalStatus;

    /** 工作年限 */
    @Excel(name = "工作年限")
    private String timeWorked;

    /** 学历 */
    @Excel(name = "学历")
    private String degree;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduateTime;

    /** 掌握外语 */
    @Excel(name = "掌握外语")
    private String foreignLanguage;

    /** 外语等级 */
    @Excel(name = "外语等级")
    private String foreignLanguageLevel;

    /** 计算机操作 */
    @Excel(name = "计算机操作")
    private String computerSkill;

    /** 计算机操作等级 */
    @Excel(name = "计算机操作等级")
    private String computerSkillLevel;

    /** 员工职级 */
    @Excel(name = "员工职级")
    private String employeeRank;

    /** 员工等级 */
    @Excel(name = "员工等级")
    private String employeeLevel;

    /** 员工证书 */
    @Excel(name = "员工证书")
    private String certificate;

    /** 身高 */
    @Excel(name = "身高")
    private String height;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    public void setEmployId(Long employId) 
    {
        this.employId = employId;
    }

    public Long getEmployId() 
    {
        return employId;
    }
    public void setNumberNeed(Long numberNeed) 
    {
        this.numberNeed = numberNeed;
    }

    public Long getNumberNeed() 
    {
        return numberNeed;
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
    public void setBaseSalary(Long baseSalary) 
    {
        this.baseSalary = baseSalary;
    }

    public Long getBaseSalary() 
    {
        return baseSalary;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setMarriage(String marriage) 
    {
        this.marriage = marriage;
    }

    public String getMarriage() 
    {
        return marriage;
    }
    public void setPoliticalStatus(String politicalStatus) 
    {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatus() 
    {
        return politicalStatus;
    }
    public void setTimeWorked(String timeWorked) 
    {
        this.timeWorked = timeWorked;
    }

    public String getTimeWorked() 
    {
        return timeWorked;
    }
    public void setDegree(String degree) 
    {
        this.degree = degree;
    }

    public String getDegree() 
    {
        return degree;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setGraduateTime(Date graduateTime) 
    {
        this.graduateTime = graduateTime;
    }

    public Date getGraduateTime() 
    {
        return graduateTime;
    }
    public void setForeignLanguage(String foreignLanguage) 
    {
        this.foreignLanguage = foreignLanguage;
    }

    public String getForeignLanguage() 
    {
        return foreignLanguage;
    }
    public void setForeignLanguageLevel(String foreignLanguageLevel) 
    {
        this.foreignLanguageLevel = foreignLanguageLevel;
    }

    public String getForeignLanguageLevel() 
    {
        return foreignLanguageLevel;
    }
    public void setComputerSkill(String computerSkill) 
    {
        this.computerSkill = computerSkill;
    }

    public String getComputerSkill() 
    {
        return computerSkill;
    }
    public void setComputerSkillLevel(String computerSkillLevel) 
    {
        this.computerSkillLevel = computerSkillLevel;
    }

    public String getComputerSkillLevel() 
    {
        return computerSkillLevel;
    }
    public void setEmployeeRank(String employeeRank) 
    {
        this.employeeRank = employeeRank;
    }

    public String getEmployeeRank() 
    {
        return employeeRank;
    }
    public void setEmployeeLevel(String employeeLevel) 
    {
        this.employeeLevel = employeeLevel;
    }

    public String getEmployeeLevel() 
    {
        return employeeLevel;
    }
    public void setCertificate(String certificate) 
    {
        this.certificate = certificate;
    }

    public String getCertificate() 
    {
        return certificate;
    }
    public void setHeight(String height) 
    {
        this.height = height;
    }

    public String getHeight() 
    {
        return height;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employId", getEmployId())
            .append("numberNeed", getNumberNeed())
            .append("employeeDepartment", getEmployeeDepartment())
            .append("employeePost", getEmployeePost())
            .append("employeeType", getEmployeeType())
            .append("employeeJob", getEmployeeJob())
            .append("baseSalary", getBaseSalary())
            .append("gender", getGender())
            .append("marriage", getMarriage())
            .append("politicalStatus", getPoliticalStatus())
            .append("timeWorked", getTimeWorked())
            .append("degree", getDegree())
            .append("major", getMajor())
            .append("graduateTime", getGraduateTime())
            .append("foreignLanguage", getForeignLanguage())
            .append("foreignLanguageLevel", getForeignLanguageLevel())
            .append("computerSkill", getComputerSkill())
            .append("computerSkillLevel", getComputerSkillLevel())
            .append("employeeRank", getEmployeeRank())
            .append("employeeLevel", getEmployeeLevel())
            .append("certificate", getCertificate())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
