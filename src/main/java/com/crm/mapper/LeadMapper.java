package com.crm.mapper;

import com.crm.entity.Lead;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
public interface LeadMapper extends MPJBaseMapper<Lead> {
    int countByCreateDate(@Param("date") LocalDate date);

}
