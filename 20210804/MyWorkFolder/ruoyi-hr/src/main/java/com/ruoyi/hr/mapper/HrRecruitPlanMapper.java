package com.ruoyi.hr.mapper;

import com.ruoyi.hr.domain.HrRecruitPlan;
import java.util.List;

/**
 * 招聘计划Mapper接口
 * 
 * @author zy
 * @date 2019-10-30
 */
public interface HrRecruitPlanMapper 
{
    /**
     * 查询招聘计划
     * 
     * @param recruitPlanId 招聘计划ID
     * @return 招聘计划
     */
    public HrRecruitPlan selectHrRecruitPlanById(Long recruitPlanId);

    /**
     * 查询招聘计划列表
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 招聘计划集合
     */
    public List<HrRecruitPlan> selectHrRecruitPlanList(HrRecruitPlan hrRecruitPlan);

    /**
     * 新增招聘计划
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 结果
     */
    public int insertHrRecruitPlan(HrRecruitPlan hrRecruitPlan);

    /**
     * 修改招聘计划
     * 
     * @param hrRecruitPlan 招聘计划
     * @return 结果
     */
    public int updateHrRecruitPlan(HrRecruitPlan hrRecruitPlan);

    /**
     * 删除招聘计划
     * 
     * @param recruitPlanId 招聘计划ID
     * @return 结果
     */
    public int deleteHrRecruitPlanById(Long recruitPlanId);

    /**
     * 批量删除招聘计划
     * 
     * @param recruitPlanIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrRecruitPlanByIds(String[] recruitPlanIds);
}
