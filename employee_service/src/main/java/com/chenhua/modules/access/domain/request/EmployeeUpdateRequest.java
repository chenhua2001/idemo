package com.chenhua.modules.access.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/*
* 更新员工请求体
* */
@Data
public class EmployeeUpdateRequest {

    /*
    * 员工id
    * */
    @NotNull(message = "员工号不能为空")
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1（true）男， 0（false）女
     */
    private Boolean sex;
}
