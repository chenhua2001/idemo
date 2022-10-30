package com.chenhua.modules.access.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountAddRequest {

    /**
     * 员工ID
     */
    @NotNull(message = "员工id不能为空")
    private Long employeeId;

    /**
     * 账户
     */
    @NotNull(message = "员工账户不能为空")
    private Long account;

}
