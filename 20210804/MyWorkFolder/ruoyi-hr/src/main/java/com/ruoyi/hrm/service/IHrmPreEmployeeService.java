package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmPreEmployee;

/**
 * 人员录用Service接口
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
public interface IHrmPreEmployeeService 
{
    /**
     * 查询人员录用
     * 
     * @param employeeId 人员录用ID
     * @return 人员录用
     */
    public HrmPreEmployee selectHrmPreEmployeeById(Long employeeId);

    /**
     * 查询人员录用列表
     * 
     * @param hrmPreEmployee 人员录用
     * @return 人员录用集合
     */
    public List<HrmPreEmployee> selectHrmPreEmployeeList(HrmPreEmployee hrmPreEmployee);

    /**
     * 新增人员录用
     * 
     * @param hrmPreEmployee 人员录用
     * @return 结果
     */
    public int insertHrmPreEmployee(HrmPreEmployee hrmPreEmployee);

    /**
     * 修改人员录用
     * 
     * @param hrmPreEmployee 人员录用
     * @return 结果
     */
    public int updateHrmPreEmployee(HrmPreEmployee hrmPreEmployee);

    /**
     * 批量删除人员录用
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmPreEmployeeByIds(String ids);

    /**
     * 删除人员录用信息
     * 
     * @param employeeId 人员录用ID
     * @return 结果
     */
    public int deleteHrmPreEmployeeById(Long employeeId);
}
