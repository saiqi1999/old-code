package com.ruoyi.hr.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

import java.util.Date;

/**
 * 招聘申请对象 hr_recruit
 * 
 * @author zy
 * @date 2019-08-29
 */
public class HrRecruit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘申请ID */
    private Long recruitId;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private Long userId;

    /** 申请部门ID */
    @Excel(name = "申请部门ID")
    private Long deptId;
    
    /** 需求岗位 岗位ID */
    @Excel(name = "需求岗位 岗位ID")
    private Long needPost;

    /** 需求人数 */
    @Excel(name = "需求人数")
    private Integer needPeople;

    /** 岗位现有人数 */
    @Excel(name = "岗位现有人数")
    private Integer existingPeople;

    /** 岗位职责要求 */
    @Excel(name = "岗位职责要求")
    private String requirements;

    /** 期望到岗时间 */
    @Excel(name = "期望到岗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private String processInstanceId;

    /** 流程状态 0新建1处理中2已结束3暂停 */
    @Excel(name = "流程状态 0新建1处理中2已结束3暂停")
    private String status;
    
    /** 上一步任务ID */
    private Long taskId;
    
    /** 上一步审批意见 */
    private String comment;
    
    /** 部门对象 */
    @Excels({
        @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
    })
    private SysDept dept;
    
    /** 用户对象 */
    @Excels({
        @Excel(name = "用户名称", targetAttr = "userName", type = Type.EXPORT),
    })
    private SysUser user;

    public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setRecruitId(Long recruitId) 
    {
        this.recruitId = recruitId;
    }

    public Long getRecruitId() 
    {
        return recruitId;
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
    public void setNeedPost(Long needPost) 
    {
        this.needPost = needPost;
    }

    public Long getNeedPost() 
    {
        return needPost;
    }
    public void setNeedPeople(Integer needPeople) 
    {
        this.needPeople = needPeople;
    }

    public Integer getNeedPeople() 
    {
        return needPeople;
    }
    public void setExistingPeople(Integer existingPeople) 
    {
        this.existingPeople = existingPeople;
    }

    public Integer getExistingPeople() 
    {
        return existingPeople;
    }
    public void setRequirements(String requirements) 
    {
        this.requirements = requirements;
    }

    public String getRequirements() 
    {
        return requirements;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setProcessInstanceId(String processInstanceId) 
    {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceId() 
    {
        return processInstanceId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    
    

    public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recruitId", getRecruitId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("needPost", getNeedPost())
            .append("needPeople", getNeedPeople())
            .append("existingPeople", getExistingPeople())
            .append("requirements", getRequirements())
            .append("arrivalTime", getArrivalTime())
            .append("processInstanceId", getProcessInstanceId())
            .append("status", getStatus())
            .append("taskId", getTaskId())
            .append("comment", getComment())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
