package com.ruoyi.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.hrm.domain.HrmEmployeeContract;

/**
 * 员工合同Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-17
 */
public interface HrmEmployeeContractMapper 
{
    /**
     * 查询员工合同
     * 
     * @param employeeId 员工合同ID
     * @return 员工合同
     */
    public HrmEmployeeContract selectHrmEmployeeContractById(Long employeeId);

    /**
     * 查询员工合同列表
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 员工合同集合
     */
    public List<HrmEmployeeContract> selectHrmEmployeeContractList(HrmEmployeeContract hrmEmployeeContract);

    /**
     * 新增员工合同
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 结果
     */
    public int insertHrmEmployeeContract(HrmEmployeeContract hrmEmployeeContract);

    /**
     * 修改员工合同
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 结果
     */
    public int updateHrmEmployeeContract(HrmEmployeeContract hrmEmployeeContract);
    public int updateContractId(@Param("employeeId") Long employeeId);

    /**
     * 删除员工合同
     * 
     * @param employeeId 员工合同ID
     * @return 结果
     */
    public int deleteHrmEmployeeContractById(Long employeeId);

    /**
     * 批量删除员工合同
     * 
     * @param employeeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrmEmployeeContractByIds(String[] employeeIds);
}
