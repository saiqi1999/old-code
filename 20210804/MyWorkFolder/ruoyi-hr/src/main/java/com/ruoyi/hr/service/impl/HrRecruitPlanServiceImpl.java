package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrRecruitPlanMapper;
import com.ruoyi.hr.domain.HrRecruitPlan;
import com.ruoyi.hr.service.IHrRecruitPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 招聘计划Service业务层处理
 * 
 * @author zy
 * @date 2019-10-30
 */
@Service
public class HrRecruitPlanServiceImpl implements IHrRecruitPlanService 
{
    @Autowired
    private HrRecruitPlanMapper hrRecruitPlanMapper;

    /**
     * 查询招聘计划
     * 
     * @param recruitPlanId 招聘计划ID
     * @return 招聘计划
     */
    @Override
    public HrRecruitPlan selectHrRecruitPlanById(Long recruitPlanId)
    {
        return hrRecruitPlanMapper.selectHrRecruitPlanById(recruitPlanId);
    }

    /**
     * 查询招聘计划列表
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 招聘计划
     */
    @Override
    public List<HrRecruitPlan> selectHrRecruitPlanList(HrRecruitPlan hrRecruitPlan)
    {
        return hrRecruitPlanMapper.selectHrRecruitPlanList(hrRecruitPlan);
    }

    /**
     * 新增招聘计划
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 结果
     */
    @Override
    public int insertHrRecruitPlan(HrRecruitPlan hrRecruitPlan)
    {
        hrRecruitPlan.setCreateTime(DateUtils.getNowDate());
        return hrRecruitPlanMapper.insertHrRecruitPlan(hrRecruitPlan);
    }

    /**
     * 修改招聘计划
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 结果
     */
    @Override
    public int updateHrRecruitPlan(HrRecruitPlan hrRecruitPlan)
    {
        hrRecruitPlan.setUpdateTime(DateUtils.getNowDate());
        return hrRecruitPlanMapper.updateHrRecruitPlan(hrRecruitPlan);
    }

    /**
     * 删除招聘计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrRecruitPlanByIds(String ids)
    {
        return hrRecruitPlanMapper.deleteHrRecruitPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招聘计划信息
     * 
     * @param recruitPlanId 招聘计划ID
     * @return 结果
     */
    @Override
    public int deleteHrRecruitPlanById(Long recruitPlanId)
    {
        return hrRecruitPlanMapper.deleteHrRecruitPlanById(recruitPlanId);
    }
}
