package com.crm.query;

import com.crm.common.model.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author crm
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "管理员查询")
public class SysManagerQuery extends Query {
    @Schema(description = "账号")
    private String account;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description="部⻔id")
    private Integer checkedDepartId;
    @Schema(description="部⻔ids")
    private List<Integer> departId;

    @Schema(description = "账号类型 0-A平台 1-B平台")
    private Integer type;
}
