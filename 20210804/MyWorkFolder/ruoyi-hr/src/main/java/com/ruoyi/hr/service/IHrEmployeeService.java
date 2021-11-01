package com.ruoyi.hr.service;

import com.ruoyi.hr.domain.HrEmployee;
import java.util.List;

/**
 * 员工档案基本信息Service接口
 * 
 * @author zy
 * @date 2019-10-28
 */
public interface IHrEmployeeService 
{
    /**
     * 查询员工档案基本信息
     * 
     * @param employeeId 员工档案基本信息ID
     * @return 员工档案基本信息
     */
    public HrEmployee selectHrEmployeeById(Long employeeId);
    
    /**
     * 查询员工档案基本信息
     * 
     * @param employeeId 钉钉花名册ID
     * @return 员工档案基本信息
     */
    public HrEmployee selectHrEmployeeByDingId(String dingEmpId);

    /**
     * 查询员工档案基本信息列表
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 员工档案基本信息集合
     */
    public List<HrEmployee> selectHrEmployeeList(HrEmployee hrEmployee);

    /**
     * 新增员工档案基本信息
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 结果
     */
    public int insertHrEmployee(HrEmployee hrEmployee);

    /**
     * 修改员工档案基本信息
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 结果
     */
    public int updateHrEmployee(HrEmployee hrEmployee);

    /**
     * 批量删除员工档案基本信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrEmployeeByIds(String ids);

    /**
     * 删除员工档案基本信息信息
     * 
     * @param employeeId 员工档案基本信息ID
     * @return 结果
     */
    public int deleteHrEmployeeById(Long employeeId);
}
