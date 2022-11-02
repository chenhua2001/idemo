package com.chenhua.modules.account.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountAddRequest {

    /**
     * 员工ID
     */
    @ApiModelProperty("员工ID 不能为空")
    @NotNull(message = "员工id不能为空")
    private Long employeeId;

    /**
     * 账户
     */
    @ApiModelProperty("员工账户不能为空")
    @NotNull(message = "员工账户不能为空")
    private Long account;

}
