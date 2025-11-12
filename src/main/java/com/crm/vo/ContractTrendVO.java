package com.crm.vo;

import lombok.Data;

@Data
public class ContractTrendVO {
    private String time;       // 时间维度
    private Integer count;     // 数量
    private String name;       // 饼图分类名称
}
