package com.ruoyi.hrm.mapper;

import java.util.List;
import com.ruoyi.hrm.domain.HrmDiary;

/**
 * 每周日程Mapper接口
 * 
 * @author 羊驼
 * @date 2021-06-03
 */
public interface HrmDiaryMapper 
{
    /**
     * 查询每周日程
     * 
     * @param diaryId 每周日程ID
     * @return 每周日程
     */
    public HrmDiary selectHrmDiaryById(Long diaryId);

    /**
     * 查询每周日程列表
     * 
     * @param hrmDiary 每周日程
     * @return 每周日程集合
     */
    public List<HrmDiary> selectHrmDiaryList(HrmDiary hrmDiary);

    /**
     * 新增每周日程
     * 
     * @param hrmDiary 每周日程
     * @return 结果
     */
    public int insertHrmDiary(HrmDiary hrmDiary);

    /**
     * 修改每周日程
     * 
     * @param hrmDiary 每周日程
     * @return 结果
     */
    public int updateHrmDiary(HrmDiary hrmDiary);

    /**
     * 删除每周日程
     * 
     * @param diaryId 每周日程ID
     * @return 结果
     */
    public int deleteHrmDiaryById(Long diaryId);

    /**
     * 批量删除每周日程
     * 
     * @param diaryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmDiaryByIds(String[] diaryIds);
}
