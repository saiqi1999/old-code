package com.ruoyi.hrm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员录用对象 hrm_pre_employee
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
public class HrmPreEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工ID */
    @Excel(name = "员工ID")
    private Long employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 用户名 */
    @Excel(name = "用户名")
    private String loginName;

    /** 员工性别 */
    @Excel(name = "员工性别")
    private String gender;

    /** 员工生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "员工生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String comeFrom;

    /** 民族 */
    @Excel(name = "民族")
    private String nationality;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marriage;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalStatus;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCardNumber;

    /** 健康状况 */
    @Excel(name = "健康状况")
    private String healthStatus;

    /** 参加工作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "参加工作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateStartWorking;

    /** 工作年限 */
    @Excel(name = "工作年限")
    private String timeWorked;

    /** 学历 */
    @Excel(name = "学历")
    private String degree;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String university;

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

    /** 教育简历 */
    @Excel(name = "教育简历")
    private String resume;

    /** 特长爱好 */
    @Excel(name = "特长爱好")
    private String favorite;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String emailAddress;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String employeeAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String zipCode;

    /** 身高 */
    @Excel(name = "身高")
    private String height;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    /** 血型 */
    @Excel(name = "血型")
    private String bloodType;

    /** 对工作要求 */
    @Excel(name = "对工作要求")
    private String employeeOrder;

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateEnrolled;

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

    /** 员工职称 */
    @Excel(name = "员工职称")
    private String employeeTitle;

    /** 员工状态 */
    @Excel(name = "员工状态")
    private String employeeStatus;

    /** 基础工资 */
    @Excel(name = "基础工资")
    private Long baseSalary;

    /** 工资卡开户银行 */
    @Excel(name = "工资卡开户银行")
    private String wageCardBank;

    /** 工资卡账户 */
    @Excel(name = "工资卡账户")
    private String wageCardNumber;

    /** 照片 */
    @Excel(name = "照片")
    private String photo;

    /** 其他关系 */
    @Excel(name = "其他关系")
    private String otherRelationship;

    /** 学习经历 */
    @Excel(name = "学习经历")
    private String studyExperience;

    /** 工作经历 */
    @Excel(name = "工作经历")
    private String workingExperience;

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
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setComeFrom(String comeFrom) 
    {
        this.comeFrom = comeFrom;
    }

    public String getComeFrom() 
    {
        return comeFrom;
    }
    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getNationality() 
    {
        return nationality;
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
    public void setIdCardNumber(String idCardNumber) 
    {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardNumber() 
    {
        return idCardNumber;
    }
    public void setHealthStatus(String healthStatus) 
    {
        this.healthStatus = healthStatus;
    }

    public String getHealthStatus() 
    {
        return healthStatus;
    }
    public void setDateStartWorking(Date dateStartWorking) 
    {
        this.dateStartWorking = dateStartWorking;
    }

    public Date getDateStartWorking() 
    {
        return dateStartWorking;
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
    public void setUniversity(String university) 
    {
        this.university = university;
    }

    public String getUniversity() 
    {
        return university;
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
    public void setResume(String resume) 
    {
        this.resume = resume;
    }

    public String getResume() 
    {
        return resume;
    }
    public void setFavorite(String favorite) 
    {
        this.favorite = favorite;
    }

    public String getFavorite() 
    {
        return favorite;
    }
    public void setEmailAddress(String emailAddress) 
    {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() 
    {
        return emailAddress;
    }
    public void setEmployeeAddress(String employeeAddress) 
    {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeAddress() 
    {
        return employeeAddress;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setZipCode(String zipCode) 
    {
        this.zipCode = zipCode;
    }

    public String getZipCode() 
    {
        return zipCode;
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
    public void setBloodType(String bloodType) 
    {
        this.bloodType = bloodType;
    }

    public String getBloodType() 
    {
        return bloodType;
    }
    public void setEmployeeOrder(String employeeOrder) 
    {
        this.employeeOrder = employeeOrder;
    }

    public String getEmployeeOrder() 
    {
        return employeeOrder;
    }
    public void setDateEnrolled(Date dateEnrolled) 
    {
        this.dateEnrolled = dateEnrolled;
    }

    public Date getDateEnrolled() 
    {
        return dateEnrolled;
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
    public void setBaseSalary(Long baseSalary) 
    {
        this.baseSalary = baseSalary;
    }

    public Long getBaseSalary() 
    {
        return baseSalary;
    }
    public void setWageCardBank(String wageCardBank) 
    {
        this.wageCardBank = wageCardBank;
    }

    public String getWageCardBank() 
    {
        return wageCardBank;
    }
    public void setWageCardNumber(String wageCardNumber) 
    {
        this.wageCardNumber = wageCardNumber;
    }

    public String getWageCardNumber() 
    {
        return wageCardNumber;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setOtherRelationship(String otherRelationship) 
    {
        this.otherRelationship = otherRelationship;
    }

    public String getOtherRelationship() 
    {
        return otherRelationship;
    }
    public void setStudyExperience(String studyExperience) 
    {
        this.studyExperience = studyExperience;
    }

    public String getStudyExperience() 
    {
        return studyExperience;
    }
    public void setWorkingExperience(String workingExperience) 
    {
        this.workingExperience = workingExperience;
    }

    public String getWorkingExperience() 
    {
        return workingExperience;
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
            .append("loginName", getLoginName())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("comeFrom", getComeFrom())
            .append("nationality", getNationality())
            .append("marriage", getMarriage())
            .append("politicalStatus", getPoliticalStatus())
            .append("idCardNumber", getIdCardNumber())
            .append("healthStatus", getHealthStatus())
            .append("dateStartWorking", getDateStartWorking())
            .append("timeWorked", getTimeWorked())
            .append("degree", getDegree())
            .append("university", getUniversity())
            .append("major", getMajor())
            .append("graduateTime", getGraduateTime())
            .append("foreignLanguage", getForeignLanguage())
            .append("foreignLanguageLevel", getForeignLanguageLevel())
            .append("computerSkill", getComputerSkill())
            .append("computerSkillLevel", getComputerSkillLevel())
            .append("employeeRank", getEmployeeRank())
            .append("employeeLevel", getEmployeeLevel())
            .append("certificate", getCertificate())
            .append("resume", getResume())
            .append("favorite", getFavorite())
            .append("emailAddress", getEmailAddress())
            .append("employeeAddress", getEmployeeAddress())
            .append("phoneNumber", getPhoneNumber())
            .append("zipCode", getZipCode())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("bloodType", getBloodType())
            .append("employeeOrder", getEmployeeOrder())
            .append("dateEnrolled", getDateEnrolled())
            .append("employeeDepartment", getEmployeeDepartment())
            .append("employeePost", getEmployeePost())
            .append("employeeType", getEmployeeType())
            .append("employeeJob", getEmployeeJob())
            .append("employeeTitle", getEmployeeTitle())
            .append("employeeStatus", getEmployeeStatus())
            .append("baseSalary", getBaseSalary())
            .append("wageCardBank", getWageCardBank())
            .append("wageCardNumber", getWageCardNumber())
            .append("photo", getPhoto())
            .append("otherRelationship", getOtherRelationship())
            .append("studyExperience", getStudyExperience())
            .append("workingExperience", getWorkingExperience())
            .append("attachment", getAttachment())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
