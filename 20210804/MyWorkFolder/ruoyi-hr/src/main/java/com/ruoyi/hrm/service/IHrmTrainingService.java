package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmTraining;

/**
 * 员工培训Service接口
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public interface IHrmTrainingService 
{
    /**
     * 查询员工培训
     * 
     * @param programId 员工培训ID
     * @return 员工培训
     */
    public HrmTraining selectHrmTrainingById(Long programId);

    /**
     * 查询员工培训列表
     * 
     * @param hrmTraining 员工培训
     * @return 员工培训集合
     */
    public List<HrmTraining> selectHrmTrainingList(HrmTraining hrmTraining);

    /**
     * 新增员工培训
     * 
     * @param hrmTraining 员工培训
     * @return 结果
     */
    public int insertHrmTraining(HrmTraining hrmTraining);

    /**
     * 修改员工培训
     * 
     * @param hrmTraining 员工培训
     * @return 结果
     */
    public int updateHrmTraining(HrmTraining hrmTraining);

    /**
     * 批量删除员工培训
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmTrainingByIds(String ids);

    /**
     * 删除员工培训信息
     * 
     * @param programId 员工培训ID
     * @return 结果
     */
    public int deleteHrmTrainingById(Long programId);
}
