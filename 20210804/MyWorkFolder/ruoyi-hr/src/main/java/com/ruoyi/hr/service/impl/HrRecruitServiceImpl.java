package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrRecruitMapper;
import com.ruoyi.hr.domain.HrRecruit;
import com.ruoyi.hr.service.IHrRecruitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 招聘申请Service业务层处理
 * 
 * @author zy
 * @date 2019-08-29
 */
@Service
public class HrRecruitServiceImpl implements IHrRecruitService 
{
    @Autowired
    private HrRecruitMapper hrRecruitMapper;

    /**
     * 查询招聘申请
     * 
     * @param recruitId 招聘申请ID
     * @return 招聘申请
     */
    @Override
    public HrRecruit selectHrRecruitById(Long recruitId)
    {
        return hrRecruitMapper.selectHrRecruitById(recruitId);
    }

    /**
     * 查询招聘申请列表
     * 
     * @param hrRecruit 招聘申请
     * @return 招聘申请
     */
    @Override
    public List<HrRecruit> selectHrRecruitList(HrRecruit hrRecruit)
    {
        return hrRecruitMapper.selectHrRecruitList(hrRecruit);
    }

    /**
     * 新增招聘申请
     * 
     * @param hrRecruit 招聘申请
     * @return 结果
     */
    @Override
    public int insertHrRecruit(HrRecruit hrRecruit)
    {
        hrRecruit.setCreateTime(DateUtils.getNowDate());
        return hrRecruitMapper.insertHrRecruit(hrRecruit);
    }

    /**
     * 修改招聘申请
     * 
     * @param hrRecruit 招聘申请
     * @return 结果
     */
    @Override
    public int updateHrRecruit(HrRecruit hrRecruit)
    {
        hrRecruit.setUpdateTime(DateUtils.getNowDate());
        return hrRecruitMapper.updateHrRecruit(hrRecruit);
    }

    /**
     * 删除招聘申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrRecruitByIds(String ids)
    {
        return hrRecruitMapper.deleteHrRecruitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招聘申请信息
     * 
     * @param recruitId 招聘申请ID
     * @return 结果
     */
    public int deleteHrRecruitById(Long recruitId)
    {
        return hrRecruitMapper.deleteHrRecruitById(recruitId);
    }
}
