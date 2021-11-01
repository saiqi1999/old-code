package com.ruoyi.hrm.mapper;

import java.util.List;
import com.ruoyi.hrm.domain.HrmEmployeeShift;

/**
 * 员工调动Mapper接口
 * 
 * @author alpk
 * @date 2021-06-16
 */
public interface HrmEmployeeShiftMapper 
{
    /**
     * 查询员工调动
     * 
     * @param employeeId 员工调动ID
     * @return 员工调动
     */
    public HrmEmployeeShift selectHrmEmployeeShiftById(Long employeeId);

    /**
     * 查询员工调动列表
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 员工调动集合
     */
    public List<HrmEmployeeShift> selectHrmEmployeeShiftList(HrmEmployeeShift hrmEmployeeShift);

    /**
     * 新增员工调动
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 结果
     */
    public int insertHrmEmployeeShift(HrmEmployeeShift hrmEmployeeShift);

    /**
     * 修改员工调动
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 结果
     */
    public int updateHrmEmployeeShift(HrmEmployeeShift hrmEmployeeShift);

    /**
     * 删除员工调动
     * 
     * @param employeeId 员工调动ID
     * @return 结果
     */
    public int deleteHrmEmployeeShiftById(Long employeeId);

    /**
     * 批量删除员工调动
     * 
     * @param employeeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmEmployeeShiftByIds(String[] employeeIds);
}
