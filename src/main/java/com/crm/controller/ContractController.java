package com.crm.controller;

import com.crm.common.aop.Log;
import com.crm.common.result.PageResult;
import com.crm.common.result.Result;
import com.crm.enums.BusinessType;
import com.crm.query.ContractQuery;
import com.crm.query.ContractTrendQuery;
import com.crm.service.ContractService;
import com.crm.vo.ContractTrendVO;
import com.crm.vo.ContractVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
@Tag(name = "合同管理")
@RestController
@RequestMapping("contract")
@AllArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping("page")
    @Operation(summary = "合同列表-分页")
    @Log(title = "合同列表-分页", businessType = BusinessType.SELECT)
    public Result<PageResult<ContractVO>> getPage(@RequestBody @Validated ContractQuery query) {
        return Result.ok(contractService.getPage(query));
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "保存或修改合同")
    public Result<Void> saveOrUpdate(@RequestBody @Validated ContractVO contractVO) {
        contractService.saveOrUpdate(contractVO);
        return Result.ok();
    }

    @PostMapping("trend")
    @Operation(summary = "合同数量趋势")
    public Result<Map<String, List>> getContractTrend(@RequestBody ContractTrendQuery query) {
        return Result.ok(contractService.getContractTrend(query));
    }

    @PostMapping("statusPie")
    @Operation(summary = "合同状态分布(饼图)")
    public Result<List<ContractTrendVO>> getContractStatusPie() {
        return Result.ok(contractService.getContractStatusPie());
    }

    @PostMapping("dashboard")
    @Operation(summary = "首页数据卡片")
    public Result<Map<String, Integer>> getDashboardStats() {
        return Result.ok(contractService.getDashboardStats());
    }

}
