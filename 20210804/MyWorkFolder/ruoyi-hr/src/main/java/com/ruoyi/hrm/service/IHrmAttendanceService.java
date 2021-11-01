package com.ruoyi.hrm.service;

import java.util.List;
import com.ruoyi.hrm.domain.HrmAttendance;

/**
 * 员工考勤Service接口
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public interface IHrmAttendanceService 
{
    /**
     * 查询员工考勤
     * 
     * @param attendanceId 员工考勤ID
     * @return 员工考勤
     */
    public HrmAttendance selectHrmAttendanceById(Long attendanceId);

    /**
     * 查询员工考勤列表
     * 
     * @param hrmAttendance 员工考勤
     * @return 员工考勤集合
     */
    public List<HrmAttendance> selectHrmAttendanceList(HrmAttendance hrmAttendance);

    /**
     * 新增员工考勤
     * 
     * @param hrmAttendance 员工考勤
     * @return 结果
     */
    public int insertHrmAttendance(HrmAttendance hrmAttendance);

    /**
     * 修改员工考勤
     * 
     * @param hrmAttendance 员工考勤
     * @return 结果
     */
    public int updateHrmAttendance(HrmAttendance hrmAttendance);

    /**
     * 批量删除员工考勤
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmAttendanceByIds(String ids);

    /**
     * 删除员工考勤信息
     * 
     * @param attendanceId 员工考勤ID
     * @return 结果
     */
    public int deleteHrmAttendanceById(Long attendanceId);
}
