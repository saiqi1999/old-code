package com.ruoyi.hrm.mapper;

import java.util.List;
import com.ruoyi.hrm.domain.HrmMessage;

/**
 * 站内信箱Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
public interface HrmMessageMapper 
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
     * 删除站内信箱
     * 
     * @param messageId 站内信箱ID
     * @return 结果
     */
    public int deleteHrmMessageById(Long messageId);

    /**
     * 批量删除站内信箱
     * 
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmMessageByIds(String[] messageIds);
    /**
     * 查询站内信箱
     * 
     * @param messageId 站内信箱ID
     * @return 站内信箱
     */
    public HrmMessage selectHrmMessageById2(Long messageId);

    /**
     * 查询站内信箱列表
     * 
     * @param hrmMessage 站内信箱
     * @return 站内信箱集合
     */
    public List<HrmMessage> selectHrmMessageList2(HrmMessage hrmMessage);

    /**
     * 新增站内信箱
     * 
     * @param hrmMessage 站内信箱
     * @return 结果
     */
    public int insertHrmMessage2(HrmMessage hrmMessage);

    /**
     * 修改站内信箱
     * 
     * @param hrmMessage 站内信箱
     * @return 结果
     */
    public int updateHrmMessage2(HrmMessage hrmMessage);

    /**
     * 删除站内信箱
     * 
     * @param messageId 站内信箱ID
     * @return 结果
     */
    public int deleteHrmMessageById2(Long messageId);

    /**
     * 批量删除站内信箱
     * 
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmMessageByIds2(String[] messageIds);
}
