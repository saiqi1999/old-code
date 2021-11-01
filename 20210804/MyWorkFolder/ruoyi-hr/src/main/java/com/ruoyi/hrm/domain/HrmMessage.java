package com.ruoyi.hrm.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 站内信箱对象 hrm_message
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
public class HrmMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 站内信ID */
    private Long messageId;

    /** 发出人 */
    @Excel(name = "发出人")
    private String userSend;

    /** 接收人 */
    @Excel(name = "接收人")
    private String userReceive;

    /** 信息标题 */
    @Excel(name = "信息标题")
    private String messageTitle;

    /** 信息 */
    @Excel(name = "信息")
    private String message;

    /** 已读 */
    @Excel(name = "已读")
    private String read;

    /** 是否刷新（0刷新 1不刷新） */
    @Excel(name = "是否刷新", readConverterExp = "0=刷新,1=不刷新")
    private String isRefresh;
    
    /** 信息被读取的时间*/
    @Excel(name="读取时间")
	private Date readTime;
    
    public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setUserSend(String userSend) 
    {
        this.userSend = userSend;
    }

    public String getUserSend() 
    {
        return userSend;
    }
    public void setUserReceive(String userReceive) 
    {
        this.userReceive = userReceive;
    }

    public String getUserReceive() 
    {
        return userReceive;
    }
    public void setMessageTitle(String messageTitle) 
    {
        this.messageTitle = messageTitle;
    }

    public String getMessageTitle() 
    {
        return messageTitle;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setRead(String read) 
    {
        this.read = read;
    }

    public String getRead() 
    {
        return read;
    }
    public void setIsRefresh(String isRefresh) 
    {
        this.isRefresh = isRefresh;
    }

    public String getIsRefresh() 
    {
        return isRefresh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("userSend", getUserSend())
            .append("userReceive", getUserReceive())
            .append("messageTitle", getMessageTitle())
            .append("message", getMessage())
            .append("read", getRead())
            .append("isRefresh", getIsRefresh())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("readTime", getReadTime())
            .toString();
    }
}
