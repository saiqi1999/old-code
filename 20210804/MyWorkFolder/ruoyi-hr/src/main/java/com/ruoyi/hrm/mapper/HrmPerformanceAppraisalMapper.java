package com.ruoyi.hrm.mapper;

import java.util.List;
import com.ruoyi.hrm.domain.HrmPerformanceAppraisal;

/**
 * 员工考核Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public interface HrmPerformanceAppraisalMapper 
{
    /**
     * 查询员工考核
     * 
     * @param appraisalId 员工考核ID
     * @return 员工考核
     */
    public HrmPerformanceAppraisal selectHrmPerformanceAppraisalById(Long appraisalId);

    /**
     * 查询员工考核列表
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 员工考核集合
     */
    public List<HrmPerformanceAppraisal> selectHrmPerformanceAppraisalList(HrmPerformanceAppraisal hrmPerformanceAppraisal);

    /**
     * 新增员工考核
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 结果
     */
    public int insertHrmPerformanceAppraisal(HrmPerformanceAppraisal hrmPerformanceAppraisal);

    /**
     * 修改员工考核
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 结果
     */
    public int updateHrmPerformanceAppraisal(HrmPerformanceAppraisal hrmPerformanceAppraisal);

    /**
     * 删除员工考核
     * 
     * @param appraisalId 员工考核ID
     * @return 结果
     */
    public int deleteHrmPerformanceAppraisalById(Long appraisalId);

    /**
     * 批量删除员工考核
     * 
     * @param appraisalIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmPerformanceAppraisalByIds(String[] appraisalIds);
}
