package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmTrainingMapper;
import com.ruoyi.hrm.domain.HrmTraining;
import com.ruoyi.hrm.service.IHrmTrainingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工培训Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
@Service
public class HrmTrainingServiceImpl implements IHrmTrainingService 
{
    @Autowired
    private HrmTrainingMapper hrmTrainingMapper;

    /**
     * 查询员工培训
     * 
     * @param programId 员工培训ID
     * @return 员工培训
     */
    @Override
    public HrmTraining selectHrmTrainingById(Long programId)
    {
        return hrmTrainingMapper.selectHrmTrainingById(programId);
    }

    /**
     * 查询员工培训列表
     * 
     * @param hrmTraining 员工培训
     * @return 员工培训
     */
    @Override
    public List<HrmTraining> selectHrmTrainingList(HrmTraining hrmTraining)
    {
        return hrmTrainingMapper.selectHrmTrainingList1(hrmTraining);
    }

    /**
     * 新增员工培训
     * 
     * @param hrmTraining 员工培训
     * @return 结果
     */
    @Override
    public int insertHrmTraining(HrmTraining hrmTraining)
    {
        hrmTraining.setCreateTime(DateUtils.getNowDate());
        return hrmTrainingMapper.insertHrmTraining(hrmTraining);
    }

    /**
     * 修改员工培训
     * 
     * @param hrmTraining 员工培训
     * @return 结果
     */
    @Override
    public int updateHrmTraining(HrmTraining hrmTraining)
    {
        hrmTraining.setUpdateTime(DateUtils.getNowDate());
        return hrmTrainingMapper.updateHrmTraining(hrmTraining);
    }

    /**
     * 删除员工培训对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmTrainingByIds(String ids)
    {
        return hrmTrainingMapper.deleteHrmTrainingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工培训信息
     * 
     * @param programId 员工培训ID
     * @return 结果
     */
    @Override
    public int deleteHrmTrainingById(Long programId)
    {
        return hrmTrainingMapper.deleteHrmTrainingById(programId);
    }
}
