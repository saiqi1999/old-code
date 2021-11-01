package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrCandidateInfo;

/**
 * 应聘人员信息Mapper接口
 * 
 * @author zy
 * @date 2021-03-16
 */
public interface HrCandidateInfoMapper 
{
    /**
     * 查询应聘人员信息
     * 
     * @param candidateId 应聘人员信息ID
     * @return 应聘人员信息
     */
    public HrCandidateInfo selectHrCandidateInfoById(Long candidateId);

    /**
     * 查询应聘人员信息列表
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 应聘人员信息集合
     */
    public List<HrCandidateInfo> selectHrCandidateInfoList(HrCandidateInfo hrCandidateInfo);

    /**
     * 新增应聘人员信息
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 结果
     */
    public int insertHrCandidateInfo(HrCandidateInfo hrCandidateInfo);

    /**
     * 修改应聘人员信息
     * 
     * @param hrCandidateInfo 应聘人员信息
     * @return 结果
     */
    public int updateHrCandidateInfo(HrCandidateInfo hrCandidateInfo);

    /**
     * 删除应聘人员信息
     * 
     * @param candidateId 应聘人员信息ID
     * @return 结果
     */
    public int deleteHrCandidateInfoById(Long candidateId);

    /**
     * 批量删除应聘人员信息
     * 
     * @param candidateIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrCandidateInfoByIds(String[] candidateIds);
}
