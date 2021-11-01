package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmMessage;

/**
 * 站内信箱Service接口
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
public interface IHrmMessageService 
{
    /**
     * 查询站内信箱
     * 
     * @param messageId 站内信箱ID
     * @return 站内信箱
     */
    public HrmMessage selectHrmMessageById(Long messageId);

    /**
     * 查询站内信箱列表
     * 
     * @param hrmMessage 站内信箱
     * @return 站内信箱集合
     */
    public List<HrmMessage> selectHrmMessageList(HrmMessage hrmMessage);

    /**
     * 新增站内信箱
     * 
     * @param hrmMessage 站内信箱
     * @return 结果
     */
    public int insertHrmMessage(HrmMessage hrmMessage);

    /**
     * 修改站内信箱
     * 
     * @param hrmMessage 站内信箱
     * @return 结果
     */
    public int updateHrmMessage(HrmMessage hrmMessage);

    /**
     * 批量删除站内信箱
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmMessageByIds(String ids);

    /**
     * 删除站内信箱信息
     * 
     * @param messageId 站内信箱ID
     * @return 结果
     */
    public int deleteHrmMessageById(Long messageId);
    
    //第二组

	HrmMessage selectHrmMessageById2(Long messageId);

	/**
	 * 查询站内信箱列表
	 * 
	 * @param hrmMessage 站内信箱
	 * @return 站内信箱
	 */
	List<HrmMessage> selectHrmMessageList2(HrmMessage hrmMessage);

	/**
	 * 新增站内信箱
	 * 
	 * @param hrmMessage 站内信箱
	 * @return 结果
	 */
	int insertHrmMessage2(HrmMessage hrmMessage);

	/**
	 * 修改站内信箱
	 * 
	 * @param hrmMessage 站内信箱
	 * @return 结果
	 */
	int updateHrmMessage2(HrmMessage hrmMessage);

	/**
	 * 删除站内信箱对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	int deleteHrmMessageByIds2(String ids);

	/**
	 * 删除站内信箱信息
	 * 
	 * @param messageId 站内信箱ID
	 * @return 结果
	 */
	int deleteHrmMessageById2(Long messageId);
}
