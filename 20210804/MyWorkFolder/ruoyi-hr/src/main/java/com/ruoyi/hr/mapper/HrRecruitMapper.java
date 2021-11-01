package com.ruoyi.hr.mapper;

import com.ruoyi.hr.domain.HrRecruit;
import java.util.List;

/**
 * 招聘申请Mapper接口
 * 
 * @author zy
 * @date 2019-08-29
 */
public interface HrRecruitMapper 
{
    /**
     * 查询招聘申请
     * 
     * @param recruitId 招聘申请ID
     * @return 招聘申请
     */
    public HrRecruit selectHrRecruitById(Long recruitId);

    /**
     * 查询招聘申请列表
     * 
     * @param hrRecruit 招聘申请
     * @return 招聘申请集合
     */
    public List<HrRecruit> selectHrRecruitList(HrRecruit hrRecruit);

    /**
     * 新增招聘申请
     * 
     * @param hrRecruit 招聘申请
     * @return 结果
     */
    public int insertHrRecruit(HrRecruit hrRecruit);

    /**
     * 修改招聘申请
     * 
     * @param hrRecruit 招聘申请
     * @return 结果
     */
    public int updateHrRecruit(HrRecruit hrRecruit);

    /**
     * 删除招聘申请
     * 
     * @param recruitId 招聘申请ID
     * @return 结果
     */
    public int deleteHrRecruitById(Long recruitId);

    /**
     * 批量删除招聘申请
     * 
     * @param recruitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrRecruitByIds(String[] recruitIds);
}
