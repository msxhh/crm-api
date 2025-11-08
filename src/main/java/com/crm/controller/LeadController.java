package com.crm.controller;

import com.crm.common.result.PageResult;
import com.crm.common.result.Result;
import com.crm.entity.FollowUp;
import com.crm.entity.Lead;
import com.crm.query.IdQuery;
import com.crm.query.LeadQuery;
import com.crm.service.LeadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
@Tag(name = "线索管理")
@RestController
@RequestMapping("lead")
@AllArgsConstructor
public class LeadController {
    private final LeadService leadService;

    @Operation(summary = "分页查询")
    @PostMapping("page")
    public Result<PageResult<Lead>> getPage(@RequestBody LeadQuery query) {
        return Result.ok(leadService.getPage(query));
    }

    @Operation(summary = "新增或修改线索")
    @PostMapping("saveOrEdit")
    public Result saveOrEdit(@RequestBody Lead lead) {
        leadService.saveOrEdit(lead);
        return Result.ok();
    }

    @Operation(summary = "转换客户")
    @PostMapping("toCustomer")
    public Result toCustomer(@RequestBody IdQuery idQuery) {
        leadService.convertToCustomer(idQuery);
        return Result.ok();
    }

    @Operation(summary = "添加跟进")
    @PostMapping("followLead")
    public Result followLead(@RequestBody FollowUp followUp) {
        leadService.followLead(followUp);
        return Result.ok();
    }
}
