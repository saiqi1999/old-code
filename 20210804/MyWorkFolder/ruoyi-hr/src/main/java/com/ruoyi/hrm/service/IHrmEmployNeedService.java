package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmEmployNeed;

/**
 * 招聘需求Service接口
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
public interface IHrmEmployNeedService 
{
    /**
     * 查询招聘需求
     * 
     * @param employId 招聘需求ID
     * @return 招聘需求
     */
    public HrmEmployNeed selectHrmEmployNeedById(Long employId);

    /**
     * 查询招聘需求列表
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 招聘需求集合
     */
    public List<HrmEmployNeed> selectHrmEmployNeedList(HrmEmployNeed hrmEmployNeed);

    /**
     * 新增招聘需求
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 结果
     */
    public int insertHrmEmployNeed(HrmEmployNeed hrmEmployNeed);

    /**
     * 修改招聘需求
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 结果
     */
    public int updateHrmEmployNeed(HrmEmployNeed hrmEmployNeed);

    /**
     * 批量删除招聘需求
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmEmployNeedByIds(String ids);

    /**
     * 删除招聘需求信息
     * 
     * @param employId 招聘需求ID
     * @return 结果
     */
    public int deleteHrmEmployNeedById(Long employId);
}
