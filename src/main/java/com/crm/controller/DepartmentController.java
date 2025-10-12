package com.crm.controller;

import com.crm.common.result.PageResult;
import com.crm.common.result.Result;
import com.crm.entity.Department;
import com.crm.query.DepartmentQuery;
import com.crm.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
@Tag(name = "部门管理")
@RestController
@RequestMapping("department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("page")
    @Operation(summary = "部门分页列表")
    public Result<PageResult<Department>> page(@RequestBody @Validated DepartmentQuery query) {
        return Result.ok(departmentService.getPage(query));
    }

}
