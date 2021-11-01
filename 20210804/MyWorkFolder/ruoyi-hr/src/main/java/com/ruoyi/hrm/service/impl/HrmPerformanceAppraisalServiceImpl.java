package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmPerformanceAppraisalMapper;
import com.ruoyi.hrm.domain.HrmPerformanceAppraisal;
import com.ruoyi.hrm.service.IHrmPerformanceAppraisalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工考核Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Service
public class HrmPerformanceAppraisalServiceImpl implements IHrmPerformanceAppraisalService 
{
    @Autowired
    private HrmPerformanceAppraisalMapper hrmPerformanceAppraisalMapper;

    /**
     * 查询员工考核
     * 
     * @param appraisalId 员工考核ID
     * @return 员工考核
     */
    @Override
    public HrmPerformanceAppraisal selectHrmPerformanceAppraisalById(Long appraisalId)
    {
        return hrmPerformanceAppraisalMapper.selectHrmPerformanceAppraisalById(appraisalId);
    }

    /**
     * 查询员工考核列表
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 员工考核
     */
    @Override
    public List<HrmPerformanceAppraisal> selectHrmPerformanceAppraisalList(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        return hrmPerformanceAppraisalMapper.selectHrmPerformanceAppraisalList(hrmPerformanceAppraisal);
    }

    /**
     * 新增员工考核
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 结果
     */
    @Override
    public int insertHrmPerformanceAppraisal(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        hrmPerformanceAppraisal.setCreateTime(DateUtils.getNowDate());
        return hrmPerformanceAppraisalMapper.insertHrmPerformanceAppraisal(hrmPerformanceAppraisal);
    }

    /**
     * 修改员工考核
     * 
     * @param hrmPerformanceAppraisal 员工考核
     * @return 结果
     */
    @Override
    public int updateHrmPerformanceAppraisal(HrmPerformanceAppraisal hrmPerformanceAppraisal)
    {
        hrmPerformanceAppraisal.setUpdateTime(DateUtils.getNowDate());
        return hrmPerformanceAppraisalMapper.updateHrmPerformanceAppraisal(hrmPerformanceAppraisal);
    }

    /**
     * 删除员工考核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmPerformanceAppraisalByIds(String ids)
    {
        return hrmPerformanceAppraisalMapper.deleteHrmPerformanceAppraisalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工考核信息
     * 
     * @param appraisalId 员工考核ID
     * @return 结果
     */
    @Override
    public int deleteHrmPerformanceAppraisalById(Long appraisalId)
    {
        return hrmPerformanceAppraisalMapper.deleteHrmPerformanceAppraisalById(appraisalId);
    }
}
