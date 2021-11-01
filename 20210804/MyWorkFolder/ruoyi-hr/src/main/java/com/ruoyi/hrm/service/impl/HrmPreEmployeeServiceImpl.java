package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmPreEmployeeMapper;
import com.ruoyi.hrm.domain.HrmPreEmployee;
import com.ruoyi.hrm.service.IHrmPreEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人员录用Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
@Service
public class HrmPreEmployeeServiceImpl implements IHrmPreEmployeeService 
{
    @Autowired
    private HrmPreEmployeeMapper hrmPreEmployeeMapper;

    /**
     * 查询人员录用
     * 
     * @param employeeId 人员录用ID
     * @return 人员录用
     */
    @Override
    public HrmPreEmployee selectHrmPreEmployeeById(Long employeeId)
    {
        return hrmPreEmployeeMapper.selectHrmPreEmployeeById(employeeId);
    }

    /**
     * 查询人员录用列表
     * 
     * @param hrmPreEmployee 人员录用
     * @return 人员录用
     */
    @Override
    public List<HrmPreEmployee> selectHrmPreEmployeeList(HrmPreEmployee hrmPreEmployee)
    {
        return hrmPreEmployeeMapper.selectHrmPreEmployeeList(hrmPreEmployee);
    }

    /**
     * 新增人员录用
     * 
     * @param hrmPreEmployee 人员录用
     * @return 结果
     */
    @Override
    public int insertHrmPreEmployee(HrmPreEmployee hrmPreEmployee)
    {
        hrmPreEmployee.setCreateTime(DateUtils.getNowDate());
        return hrmPreEmployeeMapper.insertHrmPreEmployee(hrmPreEmployee);
    }

    /**
     * 修改人员录用
     * 
     * @param hrmPreEmployee 人员录用
     * @return 结果
     */
    @Override
    public int updateHrmPreEmployee(HrmPreEmployee hrmPreEmployee)
    {
        hrmPreEmployee.setUpdateTime(DateUtils.getNowDate());
        return hrmPreEmployeeMapper.updateHrmPreEmployee(hrmPreEmployee);
    }

    /**
     * 删除人员录用对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmPreEmployeeByIds(String ids)
    {
        return hrmPreEmployeeMapper.deleteHrmPreEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员录用信息
     * 
     * @param employeeId 人员录用ID
     * @return 结果
     */
    @Override
    public int deleteHrmPreEmployeeById(Long employeeId)
    {
        return hrmPreEmployeeMapper.deleteHrmPreEmployeeById(employeeId);
    }
}
