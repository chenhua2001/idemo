package com.chenhua.modules.employee.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/*
* 添加员工请求体
* */
@Data
public class EmployeeAddRequest {

    /**
     * 员工姓名
     */
    @ApiModelProperty("员工姓名，支持模糊查询，姓名不能为空")
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 部门ID
     */
    @ApiModelProperty("部门id 不能为空")
    @NotNull(message = "部门id不能为空")
    private Long departmentId;

    /**
     * 年龄
     */
    @Min(18)
    @Max(60)
    @ApiModelProperty("年龄 range[18,60]")
    private Integer age;

    /**
     * 性别 1（true）男， 0（false）女
     */
    @ApiModelProperty("性别 1（true）男， 0（false）女")
    private Boolean sex;

}
