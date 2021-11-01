package com.ruoyi.hrm.mapper;

import java.util.List;
import com.ruoyi.hrm.domain.HrmTraining;

/**
 * 员工培训Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-21
 */
public interface HrmTrainingMapper 
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
    public List<HrmTraining> selectHrmTrainingList1(HrmTraining hrmTraining);

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
     * 删除员工培训
     * 
     * @param programId 员工培训ID
     * @return 结果
     */
    public int deleteHrmTrainingById(Long programId);

    /**
     * 批量删除员工培训
     * 
     * @param programIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmTrainingByIds(String[] programIds);
}
