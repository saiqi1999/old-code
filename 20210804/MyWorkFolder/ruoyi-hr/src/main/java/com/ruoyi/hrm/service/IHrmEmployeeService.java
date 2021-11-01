package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmEmployee;

/**
 * 员工统计Service接口
 * 
 * @author ruoyi
 * @date 2021-06-08
 */
public interface IHrmEmployeeService 
{
    /**
     * 查询员工统计
     * 
     * @param employeeId 员工统计ID
     * @return 员工统计
     */
    public HrmEmployee selectHrmEmployeeById(Long employeeId);
    
    /**
     * 查询员工统计-钉钉
     * 
     * @param employeeId 员工钉钉ID
     * @return 员工统计
     */
    public HrmEmployee selectHrmEmployeeByUserId(String employeeId);

    /**
     * 查询员工统计列表
     * 
     * @param hrmEmployee 员工统计
     * @return 员工统计集合
     */
    public List<HrmEmployee> selectHrmEmployeeList(HrmEmployee hrmEmployee);

    /**
     * 新增员工统计
     * 
     * @param hrmEmployee 员工统计
     * @return 结果
     */
    public int insertHrmEmployee(HrmEmployee hrmEmployee);

    /**
     * 修改员工统计
     * 
     * @param hrmEmployee 员工统计
     * @return 结果
     */
    public int updateHrmEmployee(HrmEmployee hrmEmployee);

    /**
     * 批量删除员工统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmEmployeeByIds(String ids);

    /**
     * 删除员工统计信息
     * 
     * @param employeeId 员工统计ID
     * @return 结果
     */
    public int deleteHrmEmployeeById(Long employeeId);
}
