package com.crm.service;

import com.crm.common.result.PageResult;
import com.crm.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.query.ContractQuery;
import com.crm.query.ContractTrendQuery;
import com.crm.vo.ContractTrendVO;
import com.crm.vo.ContractVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
public interface ContractService extends IService<Contract> {
    /**
     * 合同列表 - 分页
     * @param query
     * @return
     */
    PageResult<ContractVO> getPage(ContractQuery query);

    /**
     * 新增
     */
    void saveOrUpdate(ContractVO contractVO);


    // 合同趋势统计
    Map<String, List> getContractTrend(ContractTrendQuery query);

    // 合同状态分布
    List<ContractTrendVO> getContractStatusPie();

    // 首页数据卡片
    Map<String, Integer> getDashboardStats();
}
