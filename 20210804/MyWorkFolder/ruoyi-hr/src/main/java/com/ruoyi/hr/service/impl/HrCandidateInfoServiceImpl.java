package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrCandidateInfoMapper;
import com.ruoyi.hr.domain.HrCandidateInfo;
import com.ruoyi.hr.service.IHrCandidateInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应聘人员信息Service业务层处理
 * 
 * @author zy
 * @date 2021-03-16
 */
@Service
public class HrCandidateInfoServiceImpl implements IHrCandidateInfoService 
{
    @Autowired
    private HrCandidateInfoMapper hrCandidateInfoMapper;

    /**
     * 查询应聘人员信息
     * 
     * @param candidateId 应聘人员信息ID
     * @return 应聘人员信息
     */
    @Override
    public HrCandidateInfo selectHrCandidateInfoById(Long candidateId)
    {
        return hrCandidateInfoMapper.selectHrCandidateInfoById(candidateId);
    }

    /**
     * 查询应聘人员信息列表
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 应聘人员信息
     */
    @Override
    public List<HrCandidateInfo> selectHrCandidateInfoList(HrCandidateInfo hrCandidateInfo)
    {
        return hrCandidateInfoMapper.selectHrCandidateInfoList(hrCandidateInfo);
    }

    /**
     * 新增应聘人员信息
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 结果
     */
    @Override
    public int insertHrCandidateInfo(HrCandidateInfo hrCandidateInfo)
    {
        hrCandidateInfo.setCreateTime(DateUtils.getNowDate());
        return hrCandidateInfoMapper.insertHrCandidateInfo(hrCandidateInfo);
    }

    /**
     * 修改应聘人员信息
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 结果
     */
    @Override
    public int updateHrCandidateInfo(HrCandidateInfo hrCandidateInfo)
    {
        hrCandidateInfo.setUpdateTime(DateUtils.getNowDate());
        return hrCandidateInfoMapper.updateHrCandidateInfo(hrCandidateInfo);
    }

    /**
     * 删除应聘人员信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateInfoByIds(String ids)
    {
        return hrCandidateInfoMapper.deleteHrCandidateInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应聘人员信息信息
     * 
     * @param candidateId 应聘人员信息ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateInfoById(Long candidateId)
    {
        return hrCandidateInfoMapper.deleteHrCandidateInfoById(candidateId);
    }
}
