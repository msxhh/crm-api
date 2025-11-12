package com.crm.query;

import java.util.List;

public class ContractTrendQuery {
    private List<String> timeRange;  // 时间范围
    private String timeType;         // 时间类型：day/week/month/year
    private String groupType;        // 饼图分组类型：status/amountLevel
}
