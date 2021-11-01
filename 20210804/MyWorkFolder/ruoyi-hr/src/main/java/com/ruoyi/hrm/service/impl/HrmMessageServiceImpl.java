package com.ruoyi.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hrm.domain.HrmMessage;
import com.ruoyi.hrm.mapper.HrmMessageMapper;
import com.ruoyi.hrm.service.IHrmMessageService;

@Service
public class HrmMessageServiceImpl implements IHrmMessageService {

	@Autowired
	HrmMessageMapper hrmMessageMapper;
	
	@Override
	public HrmMessage selectHrmMessageById(Long messageId) {
		return hrmMessageMapper.selectHrmMessageById(messageId);
	}

	@Override
	public List<HrmMessage> selectHrmMessageList(HrmMessage hrmMessage) {
		return hrmMessageMapper.selectHrmMessageList(hrmMessage);
	}

	@Override
	public int insertHrmMessage(HrmMessage hrmMessage) {
		hrmMessage.setCreateTime(DateUtils.getNowDate());
		return hrmMessageMapper.insertHrmMessage(hrmMessage);
	}

	@Override
	public int updateHrmMessage(HrmMessage hrmMessage) {
		return hrmMessageMapper.updateHrmMessage(hrmMessage);
	}

	@Override
	public int deleteHrmMessageByIds(String ids) {
		return hrmMessageMapper.deleteHrmMessageByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteHrmMessageById(Long messageId) {
		return hrmMessageMapper.deleteHrmMessageById(messageId);
	}

	@Override
	public HrmMessage selectHrmMessageById2(Long messageId) {
		return hrmMessageMapper.selectHrmMessageById2(messageId);
	}

	@Override
	public List<HrmMessage> selectHrmMessageList2(HrmMessage hrmMessage) {
		return hrmMessageMapper.selectHrmMessageList2(hrmMessage);
	}

	@Override
	public int insertHrmMessage2(HrmMessage hrmMessage) {
		hrmMessage.setCreateTime(DateUtils.getNowDate());
		return hrmMessageMapper.insertHrmMessage2(hrmMessage);
	}

	@Override
	public int updateHrmMessage2(HrmMessage hrmMessage) {
		return hrmMessageMapper.updateHrmMessage2(hrmMessage);
	}

	@Override
	public int deleteHrmMessageByIds2(String ids) {
		return hrmMessageMapper.deleteHrmMessageByIds2(Convert.toStrArray(ids));
	}

	@Override
	public int deleteHrmMessageById2(Long messageId) {
		return hrmMessageMapper.deleteHrmMessageById2(messageId);
	}

}
