package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmAttendanceMapper;
import com.ruoyi.hrm.domain.HrmAttendance;
import com.ruoyi.hrm.service.IHrmAttendanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工考勤Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Service
public class HrmAttendanceServiceImpl implements IHrmAttendanceService 
{
    @Autowired
    private HrmAttendanceMapper hrmAttendanceMapper;

    /**
     * 查询员工考勤
     * 
     * @param attendanceId 员工考勤ID
     * @return 员工考勤
     */
    @Override
    public HrmAttendance selectHrmAttendanceById(Long attendanceId)
    {
        return hrmAttendanceMapper.selectHrmAttendanceById(attendanceId);
    }

    /**
     * 查询员工考勤列表
     * 
     * @param hrmAttendance 员工考勤
     * @return 员工考勤
     */
    @Override
    public List<HrmAttendance> selectHrmAttendanceList(HrmAttendance hrmAttendance)
    {
        return hrmAttendanceMapper.selectHrmAttendanceList(hrmAttendance);
    }

    /**
     * 新增员工考勤
     * 
     * @param hrmAttendance 员工考勤
     * @return 结果
     */
    @Override
    public int insertHrmAttendance(HrmAttendance hrmAttendance)
    {
        hrmAttendance.setCreateTime(DateUtils.getNowDate());
        return hrmAttendanceMapper.insertHrmAttendance(hrmAttendance);
    }

    /**
     * 修改员工考勤
     * 
     * @param hrmAttendance 员工考勤
     * @return 结果
     */
    @Override
    public int updateHrmAttendance(HrmAttendance hrmAttendance)
    {
        hrmAttendance.setUpdateTime(DateUtils.getNowDate());
        return hrmAttendanceMapper.updateHrmAttendance(hrmAttendance);
    }

    /**
     * 删除员工考勤对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmAttendanceByIds(String ids)
    {
        return hrmAttendanceMapper.deleteHrmAttendanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工考勤信息
     * 
     * @param attendanceId 员工考勤ID
     * @return 结果
     */
    @Override
    public int deleteHrmAttendanceById(Long attendanceId)
    {
        return hrmAttendanceMapper.deleteHrmAttendanceById(attendanceId);
    }
}
