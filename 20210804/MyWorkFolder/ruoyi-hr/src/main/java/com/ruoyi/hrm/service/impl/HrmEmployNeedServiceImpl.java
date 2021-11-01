package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmEmployNeedMapper;
import com.ruoyi.hrm.domain.HrmEmployNeed;
import com.ruoyi.hrm.service.IHrmEmployNeedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 招聘需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
@Service
public class HrmEmployNeedServiceImpl implements IHrmEmployNeedService 
{
    @Autowired
    private HrmEmployNeedMapper hrmEmployNeedMapper;

    /**
     * 查询招聘需求
     * 
     * @param employId 招聘需求ID
     * @return 招聘需求
     */
    @Override
    public HrmEmployNeed selectHrmEmployNeedById(Long employId)
    {
        return hrmEmployNeedMapper.selectHrmEmployNeedById(employId);
    }

    /**
     * 查询招聘需求列表
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 招聘需求
     */
    @Override
    public List<HrmEmployNeed> selectHrmEmployNeedList(HrmEmployNeed hrmEmployNeed)
    {
        return hrmEmployNeedMapper.selectHrmEmployNeedList(hrmEmployNeed);
    }

    /**
     * 新增招聘需求
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 结果
     */
    @Override
    public int insertHrmEmployNeed(HrmEmployNeed hrmEmployNeed)
    {
        hrmEmployNeed.setCreateTime(DateUtils.getNowDate());
        return hrmEmployNeedMapper.insertHrmEmployNeed(hrmEmployNeed);
    }

    /**
     * 修改招聘需求
     * 
     * @param hrmEmployNeed 招聘需求
     * @return 结果
     */
    @Override
    public int updateHrmEmployNeed(HrmEmployNeed hrmEmployNeed)
    {
        hrmEmployNeed.setUpdateTime(DateUtils.getNowDate());
        return hrmEmployNeedMapper.updateHrmEmployNeed(hrmEmployNeed);
    }

    /**
     * 删除招聘需求对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployNeedByIds(String ids)
    {
        return hrmEmployNeedMapper.deleteHrmEmployNeedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招聘需求信息
     * 
     * @param employId 招聘需求ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployNeedById(Long employId)
    {
        return hrmEmployNeedMapper.deleteHrmEmployNeedById(employId);
    }
}
