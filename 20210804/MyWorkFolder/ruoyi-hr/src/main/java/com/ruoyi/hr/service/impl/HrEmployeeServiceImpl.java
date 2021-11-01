package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrEmployeeMapper;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.service.IHrEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工档案基本信息Service业务层处理
 * 
 * @author zy
 * @date 2019-10-28
 */
@Service
public class HrEmployeeServiceImpl implements IHrEmployeeService 
{
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;

    /**
     * 查询员工档案基本信息
     * 
     * @param employeeId 员工档案基本信息ID
     * @return 员工档案基本信息
     */
    @Override
    public HrEmployee selectHrEmployeeById(Long employeeId)
    {
        return hrEmployeeMapper.selectHrEmployeeById(employeeId);
    }
    
    /**
     * 查询员工档案基本信息
     * 
     * @param employeeId 钉钉花名册ID
     * @return 员工档案基本信息
     */
    @Override
    public HrEmployee selectHrEmployeeByDingId(String dingEmpId) 
    {
    	 return hrEmployeeMapper.selectHrEmployeeByDingId(dingEmpId);
    }

    /**
     * 查询员工档案基本信息列表
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 员工档案基本信息
     */
    @Override
    public List<HrEmployee> selectHrEmployeeList(HrEmployee hrEmployee)
    {
        return hrEmployeeMapper.selectHrEmployeeList(hrEmployee);
    }

    /**
     * 新增员工档案基本信息
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 结果
     */
    @Override
    public int insertHrEmployee(HrEmployee hrEmployee)
    {
        hrEmployee.setCreateTime(DateUtils.getNowDate());
        return hrEmployeeMapper.insertHrEmployee(hrEmployee);
    }

    /**
     * 修改员工档案基本信息
     * 
     * @param hrEmployee 员工档案基本信息
     * @return 结果
     */
    @Override
    public int updateHrEmployee(HrEmployee hrEmployee)
    {
        hrEmployee.setUpdateTime(DateUtils.getNowDate());
        return hrEmployeeMapper.updateHrEmployee(hrEmployee);
    }

    /**
     * 删除员工档案基本信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeByIds(String ids)
    {
        return hrEmployeeMapper.deleteHrEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工档案基本信息信息
     * 
     * @param employeeId 员工档案基本信息ID
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeById(Long employeeId)
    {
        return hrEmployeeMapper.deleteHrEmployeeById(employeeId);
    }
}
