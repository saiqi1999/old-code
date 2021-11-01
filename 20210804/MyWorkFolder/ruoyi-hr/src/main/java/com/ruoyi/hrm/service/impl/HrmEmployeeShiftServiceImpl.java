package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmEmployeeShiftMapper;
import com.ruoyi.hrm.domain.HrmEmployeeShift;
import com.ruoyi.hrm.service.IHrmEmployeeShiftService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工调动Service业务层处理
 * 
 * @author alpk
 * @date 2021-06-16
 */
@Service
public class HrmEmployeeShiftServiceImpl implements IHrmEmployeeShiftService 
{
    @Autowired
    private HrmEmployeeShiftMapper hrmEmployeeShiftMapper;

    /**
     * 查询员工调动
     * 
     * @param employeeId 员工调动ID
     * @return 员工调动
     */
    @Override
    public HrmEmployeeShift selectHrmEmployeeShiftById(Long employeeId)
    {
        return hrmEmployeeShiftMapper.selectHrmEmployeeShiftById(employeeId);
    }

    /**
     * 查询员工调动列表
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 员工调动
     */
    @Override
    public List<HrmEmployeeShift> selectHrmEmployeeShiftList(HrmEmployeeShift hrmEmployeeShift)
    {
        return hrmEmployeeShiftMapper.selectHrmEmployeeShiftList(hrmEmployeeShift);
    }

    /**
     * 新增员工调动
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 结果
     */
    @Override
    public int insertHrmEmployeeShift(HrmEmployeeShift hrmEmployeeShift)
    {
        hrmEmployeeShift.setCreateTime(DateUtils.getNowDate());
        return hrmEmployeeShiftMapper.insertHrmEmployeeShift(hrmEmployeeShift);
    }

    /**
     * 修改员工调动
     * 
     * @param hrmEmployeeShift 员工调动
     * @return 结果
     */
    @Override
    public int updateHrmEmployeeShift(HrmEmployeeShift hrmEmployeeShift)
    {
        hrmEmployeeShift.setUpdateTime(DateUtils.getNowDate());
        return hrmEmployeeShiftMapper.updateHrmEmployeeShift(hrmEmployeeShift);
    }

    /**
     * 删除员工调动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeShiftByIds(String ids)
    {
        return hrmEmployeeShiftMapper.deleteHrmEmployeeShiftByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工调动信息
     * 
     * @param employeeId 员工调动ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeShiftById(Long employeeId)
    {
        return hrmEmployeeShiftMapper.deleteHrmEmployeeShiftById(employeeId);
    }
}
