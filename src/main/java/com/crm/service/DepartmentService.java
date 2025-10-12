package com.crm.service;

import com.crm.common.result.PageResult;
import com.crm.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.query.DepartmentQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 部门的分页列表
     * @param query
     * @return
     */
    PageResult<Department> getPage(DepartmentQuery query);

}
