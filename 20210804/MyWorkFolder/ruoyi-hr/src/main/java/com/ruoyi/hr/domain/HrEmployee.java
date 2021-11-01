package com.ruoyi.hr.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 员工档案基本信息对象 hr_employee
 * 
 * @author zy
 * @date 2019-10-28
 */
public class HrEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工ID */
    private Long employeeId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;
    
    /** 钉钉花名册ID */
    private String dingempId;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeeNo;

    /** 员工岗位ID */
    @Excel(name = "员工岗位ID")
    private Long postId;

    /** 岗位级别 */
    @Excel(name = "岗位级别")
    private String positionLevel;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String name;

    /** 员工性别，取值为 F:女 M:男 N:不确定 */
    @Excel(name = "员工性别，取值为 F:女 M:男 N:不确定")
    private String gender;

    /** 员工出生日期，格式为 YYYYMMDD */
    @Excel(name = "员工出生日期，格式为 YYYYMMDD", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 婚姻状况(1未婚2已婚) */
    @Excel(name = "婚姻状况(1未婚2已婚)")
    private String marital;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identyNo;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String telephone;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String homesite;

    /** 状态(1在职2离职3退休4试用期) */
    @Excel(name = "状态(1在职2离职3退休4试用期)")
    private String status;

    /** 员工类别 */
    @Excel(name = "员工类别")
    private String type;

    /** 入职时间 */
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 试用期限(月) */
    @Excel(name = "试用期限(月)")
    private String trialPeriod;

    /** 转正时间 */
    @Excel(name = "转正时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date positiveTime;

    /** 首次参加工作时间 */
    @Excel(name = "首次参加工作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstWork;

    /** 离职时间 */
    @Excel(name = "离职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 办公地点 */
    @Excel(name = "办公地点")
    private String jobSite;

    /** 工龄 */
    @Excel(name = "工龄")
    private Integer workingYear;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String polity;

    /** 技术职称ID */
    @Excel(name = "技术职称ID")
    private Long positionId;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String school;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 毕业时间 */
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationDate;

    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setEmployeeNo(String employeeNo) 
    {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeNo() 
    {
        return employeeNo;
    }
    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
    }
    public void setPositionLevel(String positionLevel) 
    {
        this.positionLevel = positionLevel;
    }

    public String getPositionLevel() 
    {
        return positionLevel;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setMarital(String marital) 
    {
        this.marital = marital;
    }

    public String getMarital() 
    {
        return marital;
    }
    public void setIdentyNo(String identyNo) 
    {
        this.identyNo = identyNo;
    }

    public String getIdentyNo() 
    {
        return identyNo;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setHomesite(String homesite) 
    {
        this.homesite = homesite;
    }

    public String getHomesite() 
    {
        return homesite;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setEntryTime(Date entryTime) 
    {
        this.entryTime = entryTime;
    }

    public Date getEntryTime() 
    {
        return entryTime;
    }
    public void setTrialPeriod(String trialPeriod) 
    {
        this.trialPeriod = trialPeriod;
    }

    public String getTrialPeriod() 
    {
        return trialPeriod;
    }
    public void setPositiveTime(Date positiveTime) 
    {
        this.positiveTime = positiveTime;
    }

    public Date getPositiveTime() 
    {
        return positiveTime;
    }
    public void setFirstWork(Date firstWork) 
    {
        this.firstWork = firstWork;
    }

    public Date getFirstWork() 
    {
        return firstWork;
    }
    public void setDepartureTime(Date departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() 
    {
        return departureTime;
    }
    public void setJobSite(String jobSite) 
    {
        this.jobSite = jobSite;
    }

    public String getJobSite() 
    {
        return jobSite;
    }
    public void setWorkingYear(Integer workingYear) 
    {
        this.workingYear = workingYear;
    }

    public Integer getWorkingYear() 
    {
        return workingYear;
    }
    public void setPolity(String polity) 
    {
        this.polity = polity;
    }

    public String getPolity() 
    {
        return polity;
    }
    public void setPositionId(Long positionId) 
    {
        this.positionId = positionId;
    }

    public Long getPositionId() 
    {
        return positionId;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setGraduationDate(Date graduationDate) 
    {
        this.graduationDate = graduationDate;
    }

    public Date getGraduationDate() 
    {
        return graduationDate;
    }
    
    

    public String getDingempId() {
		return dingempId;
	}

	public void setDingempId(String dingempId) {
		this.dingempId = dingempId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employeeId", getEmployeeId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("dingempId",getDingempId())
            .append("employeeNo", getEmployeeNo())
            .append("postId", getPostId())
            .append("positionLevel", getPositionLevel())
            .append("name", getName())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("age", getAge())
            .append("nation", getNation())
            .append("marital", getMarital())
            .append("identyNo", getIdentyNo())
            .append("telephone", getTelephone())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("homesite", getHomesite())
            .append("status", getStatus())
            .append("type", getType())
            .append("entryTime", getEntryTime())
            .append("trialPeriod", getTrialPeriod())
            .append("positiveTime", getPositiveTime())
            .append("firstWork", getFirstWork())
            .append("departureTime", getDepartureTime())
            .append("jobSite", getJobSite())
            .append("workingYear", getWorkingYear())
            .append("polity", getPolity())
            .append("positionId", getPositionId())
            .append("education", getEducation())
            .append("school", getSchool())
            .append("major", getMajor())
            .append("graduationDate", getGraduationDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
