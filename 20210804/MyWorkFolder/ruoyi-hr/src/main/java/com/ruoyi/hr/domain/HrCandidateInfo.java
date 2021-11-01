package com.ruoyi.hr.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应聘人员信息对象 hr_candidate_info
 * 
 * @author zy
 * @date 2021-03-16
 */
public class HrCandidateInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 应聘人员信息ID */
    private Long candidateId;

    /** 应聘时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应聘时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date candiTime;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String position;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String sex;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String certNo;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthTime;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 民族 */
    @Excel(name = "民族")
    private String nationType;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marriage;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 首次参加工作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首次参加工作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinWorkingTime;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalStatus;

    /** 学历 */
    @Excel(name = "学历")
    private String highestEdu;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String graduateSchool;

    /** 毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationTime;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 住址 */
    @Excel(name = "住址")
    private String address;

    /** 招聘部门ID */
    @Excel(name = "招聘部门ID")
    private Long mainDeptId;

    /** 招聘部门 */
    @Excel(name = "招聘部门")
    private String mainDept;

    /** 推荐岗位ID */
    @Excel(name = "推荐岗位ID")
    private Long postId;

    /** 推荐岗位 */
    @Excel(name = "推荐岗位")
    private String postName;

    /** 是否面试 */
    @Excel(name = "是否面试")
    private String whetherInterview;

    /** 是否录用 */
    @Excel(name = "是否录用")
    private String whetherEmploy;

    /** 是否入职 */
    @Excel(name = "是否入职")
    private String whetherCareer;

    /** 渠道来源 */
    @Excel(name = "渠道来源")
    private String sourceFor;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setCandidateId(Long candidateId) 
    {
        this.candidateId = candidateId;
    }

    public Long getCandidateId() 
    {
        return candidateId;
    }
    public void setCandiTime(Date candiTime) 
    {
        this.candiTime = candiTime;
    }

    public Date getCandiTime() 
    {
        return candiTime;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setCertNo(String certNo) 
    {
        this.certNo = certNo;
    }

    public String getCertNo() 
    {
        return certNo;
    }
    public void setBirthTime(Date birthTime) 
    {
        this.birthTime = birthTime;
    }

    public Date getBirthTime() 
    {
        return birthTime;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setNationType(String nationType) 
    {
        this.nationType = nationType;
    }

    public String getNationType() 
    {
        return nationType;
    }
    public void setMarriage(String marriage) 
    {
        this.marriage = marriage;
    }

    public String getMarriage() 
    {
        return marriage;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setJoinWorkingTime(Date joinWorkingTime) 
    {
        this.joinWorkingTime = joinWorkingTime;
    }

    public Date getJoinWorkingTime() 
    {
        return joinWorkingTime;
    }
    public void setPoliticalStatus(String politicalStatus) 
    {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatus() 
    {
        return politicalStatus;
    }
    public void setHighestEdu(String highestEdu) 
    {
        this.highestEdu = highestEdu;
    }

    public String getHighestEdu() 
    {
        return highestEdu;
    }
    public void setGraduateSchool(String graduateSchool) 
    {
        this.graduateSchool = graduateSchool;
    }

    public String getGraduateSchool() 
    {
        return graduateSchool;
    }
    public void setGraduationTime(Date graduationTime) 
    {
        this.graduationTime = graduationTime;
    }

    public Date getGraduationTime() 
    {
        return graduationTime;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setMainDeptId(Long mainDeptId) 
    {
        this.mainDeptId = mainDeptId;
    }

    public Long getMainDeptId() 
    {
        return mainDeptId;
    }
    public void setMainDept(String mainDept) 
    {
        this.mainDept = mainDept;
    }

    public String getMainDept() 
    {
        return mainDept;
    }
    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
    }
    public void setPostName(String postName) 
    {
        this.postName = postName;
    }

    public String getPostName() 
    {
        return postName;
    }
    public void setWhetherInterview(String whetherInterview) 
    {
        this.whetherInterview = whetherInterview;
    }

    public String getWhetherInterview() 
    {
        return whetherInterview;
    }
    public void setWhetherEmploy(String whetherEmploy) 
    {
        this.whetherEmploy = whetherEmploy;
    }

    public String getWhetherEmploy() 
    {
        return whetherEmploy;
    }
    public void setWhetherCareer(String whetherCareer) 
    {
        this.whetherCareer = whetherCareer;
    }

    public String getWhetherCareer() 
    {
        return whetherCareer;
    }
    public void setSourceFor(String sourceFor) 
    {
        this.sourceFor = sourceFor;
    }

    public String getSourceFor() 
    {
        return sourceFor;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("candidateId", getCandidateId())
            .append("candiTime", getCandiTime())
            .append("position", getPosition())
            .append("name", getName())
            .append("sex", getSex())
            .append("certNo", getCertNo())
            .append("birthTime", getBirthTime())
            .append("age", getAge())
            .append("nationType", getNationType())
            .append("marriage", getMarriage())
            .append("telephone", getTelephone())
            .append("joinWorkingTime", getJoinWorkingTime())
            .append("politicalStatus", getPoliticalStatus())
            .append("highestEdu", getHighestEdu())
            .append("graduateSchool", getGraduateSchool())
            .append("graduationTime", getGraduationTime())
            .append("major", getMajor())
            .append("address", getAddress())
            .append("mainDeptId", getMainDeptId())
            .append("mainDept", getMainDept())
            .append("postId", getPostId())
            .append("postName", getPostName())
            .append("whetherInterview", getWhetherInterview())
            .append("whetherEmploy", getWhetherEmploy())
            .append("whetherCareer", getWhetherCareer())
            .append("sourceFor", getSourceFor())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
