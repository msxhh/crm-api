package com.crm.mapper;

import com.crm.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crm.query.ContractTrendQuery;
import com.crm.vo.ContractTrendVO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
public interface ContractMapper extends MPJBaseMapper<Contract> {
    // 合同数量趋势
    List<ContractTrendVO> getContractTrend(@Param("query") ContractTrendQuery query);

    // 合同状态分布(饼图)
    List<ContractTrendVO> getContractStatusPie();

    // 今日新增合同统计
    Integer getTodayNewCount();
}
