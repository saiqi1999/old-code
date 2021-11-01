package com.ruoyi.hrm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hrm.mapper.HrmEmployeeContractMapper;
import com.ruoyi.hrm.domain.HrmEmployeeContract;
import com.ruoyi.hrm.service.IHrmEmployeeContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工合同Service业务层处理
 * 
 * @author alpk
 * @date 2021-06-15
 */
@Service
public class HrmEmployeeContractServiceImpl implements IHrmEmployeeContractService 
{
    @Autowired
    private HrmEmployeeContractMapper hrmEmployeeContractMapper;

    /**
     * 查询员工合同
     * 
     * @param employeeId 员工合同ID
     * @return 员工合同
     */
    @Override
    public HrmEmployeeContract selectHrmEmployeeContractById(Long employeeId)
    {
        return hrmEmployeeContractMapper.selectHrmEmployeeContractById(employeeId);
    }

    /**
     * 查询员工合同列表
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 员工合同
     */
    @Override
    public List<HrmEmployeeContract> selectHrmEmployeeContractList(HrmEmployeeContract hrmEmployeeContract)
    {
        return hrmEmployeeContractMapper.selectHrmEmployeeContractList(hrmEmployeeContract);
    }

    /**
     * 新增员工合同
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 结果
     */
    @Override
    public int insertHrmEmployeeContract(HrmEmployeeContract hrmEmployeeContract)
    {
        hrmEmployeeContract.setCreateTime(DateUtils.getNowDate());
        return hrmEmployeeContractMapper.insertHrmEmployeeContract(hrmEmployeeContract);
    }

    /**
     * 修改员工合同
     * 
     * @param hrmEmployeeContract 员工合同
     * @return 结果
     */
    @Override
    public int updateHrmEmployeeContract(HrmEmployeeContract hrmEmployeeContract)
    {
        hrmEmployeeContract.setUpdateTime(DateUtils.getNowDate());
        return hrmEmployeeContractMapper.updateHrmEmployeeContract(hrmEmployeeContract);
    }
    @Override
	public int updateContractId(Long employeeId) {
		return hrmEmployeeContractMapper.updateContractId(employeeId);
	}
    /**
     * 删除员工合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeContractByIds(String ids)
    {
        return hrmEmployeeContractMapper.deleteHrmEmployeeContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工合同信息
     * 
     * @param employeeId 员工合同ID
     * @return 结果
     */
    @Override
    public int deleteHrmEmployeeContractById(Long employeeId)
    {
        return hrmEmployeeContractMapper.deleteHrmEmployeeContractById(employeeId);
    }

	
}
