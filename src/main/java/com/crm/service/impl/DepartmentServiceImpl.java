package com.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crm.common.result.PageResult;
import com.crm.entity.Department;
import com.crm.mapper.DepartmentMapper;
import com.crm.query.DepartmentQuery;
import com.crm.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author common
 * @since 2025-10-12
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public PageResult<Department> getPage(DepartmentQuery query) {
        // 1、构造条件查询 wrapper
        LambdaQueryWrapper<Department> wrapper = new LambdaQueryWrapper<>();
        if (query.getName() != null && query.getName().isEmpty()) {
            wrapper.like(Department::getName, query.getName());
        }

        List<Department> departments = baseMapper.selectList(wrapper);
        if (departments.isEmpty()) {
            return new PageResult<>(Collections.emptyList(), 0);
        }

        // 2、找到最小的层级
        Integer miniLevel = departments.stream().map(Department::getLevel).min(Integer::compareTo).orElse(0);
        // 3、筛选出顶级的部门数据
        List<Department> topDepartment = departments.stream().filter(department -> department.getLevel().equals(miniLevel)).toList();

        // 4、顶级部门分页
        int total = topDepartment.size();
        int formIndex = (query.getPage() - 1) * query.getLimit();
        int toIndex = Math.min(formIndex + query.getLimit(), total);

        if (formIndex >= total) {
            return new PageResult<>(Collections.emptyList(), total);
        }

        // 5、顶级分页数据处理
        List<Department> result = topDepartment.subList(formIndex, toIndex);

        // 6、构建父子级关系数据
        result.forEach(item-> getChildList(item, departments));

        return new PageResult<>(result, total);
    }

    private Department getChildList(Department department, List<Department> list) {
        list.forEach(item -> {
            if (item.getParentId().equals(department.getId())) {
                department.getChildren().add(getChildList(item, list));
            }
        });
        return department;
    }
}

