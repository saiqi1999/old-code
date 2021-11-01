package com.ruoyi.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.hrm.domain.HrmDiary;
import com.ruoyi.hrm.mapper.HrmDiaryMapper;
import com.ruoyi.hrm.service.IHrmDiaryService;

@Service
public class HrmDiaryServiceImpl implements IHrmDiaryService {

	
	@Autowired
	HrmDiaryMapper hrmDiaryMapper;
	@Override
	public HrmDiary selectHrmDiaryById(Long diaryId) {
		return hrmDiaryMapper.selectHrmDiaryById(diaryId);
	}

	@Override
	public List<HrmDiary> selectHrmDiaryList(HrmDiary hrmDiary) {
		return hrmDiaryMapper.selectHrmDiaryList(hrmDiary);
	}

	@Override
	public int insertHrmDiary(HrmDiary hrmDiary) {
		return hrmDiaryMapper.insertHrmDiary(hrmDiary);
	}

	@Override
	public int updateHrmDiary(HrmDiary hrmDiary) {
		return hrmDiaryMapper.updateHrmDiary(hrmDiary);
	}

	@Override
	public int deleteHrmDiaryByIds(String ids) {
		return hrmDiaryMapper.deleteHrmDiaryByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteHrmDiaryById(Long diaryId) {
		return hrmDiaryMapper.deleteHrmDiaryById(diaryId);
	}

}
