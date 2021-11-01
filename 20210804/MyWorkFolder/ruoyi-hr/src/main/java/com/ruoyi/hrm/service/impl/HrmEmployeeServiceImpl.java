package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmEmployeeMapper;
import com.ruoyi.hrm.domain.HrmEmployee;
import com.ruoyi.hrm.service.IHrmEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-08
 */
@Service
public class HrmEmployeeServiceImpl implements IHrmEmployeeService 
{
    @Autowired
    private HrmEmployeeMapper hrmEmployeeMapper;

    /**
     * 查询员工统计
     * 
     * @param employeeId 员工统计ID
     * @return 员工统计
     */
    @Override
    public HrmEmployee selectHrmEmployeeById(Long employeeId)
    {
        return hrmEmployeeMapper.selectHrmEmployeeById(employeeId);
    }

    /**
     * 查询员工统计列表
     * 
     * @param hrmEmployee 员工统计
     * @return 员工统计
     */
    @Override
    public List<HrmEmployee> selectHrmEmployeeList(HrmEmployee hrmEmployee)
    {
        return hrmEmployeeMapper.selectHrmEmployeeList(hrmEmployee);
    }

    /**
     * 新增员工统计
     * 
     * @param hrmEmployee 员工统计
     * @return 结果
     */
    @Override
    public int insertHrmEmployee(HrmEmployee hrmEmployee)
    {
        hrmEmployee.setCreateTime(DateUtils.getNowDate());
        return hrmEmployeeMapper.insertHrmEmployee(hrmEmployee);
    }

    /**
     * 修改员工统计
     * 
     * @param hrmEmployee 员工统计
     * @return 结果
     */
    @Override
    public int updateHrmEmployee(HrmEmployee hrmEmployee)
    {
        hrmEmployee.setUpdateTime(DateUtils.getNowDate());
        return hrmEmployeeMapper.updateHrmEmployee(hrmEmployee);
    }

    /**
     * 删除员工统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeByIds(String ids)
    {
        return hrmEmployeeMapper.deleteHrmEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工统计信息
     * 
     * @param employeeId 员工统计ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeById(Long employeeId)
    {
        return hrmEmployeeMapper.deleteHrmEmployeeById(employeeId);
    }

	@Override
	public HrmEmployee selectHrmEmployeeByUserId(String employeeId) {
		return hrmEmployeeMapper.selectHrmEmployeeByUserId(employeeId);
	}
}
