package com.chenhua.modules.employee.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @ApiModelProperty("员工ID 不能为空")
    private Long id;

    /**
     * 员工姓名
     */
    @ApiModelProperty("员工姓名")
    private String name;

    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private Long departmentId;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄 数据年龄区间[18,60")
    @Min(18)
    @Max(60)
    private Integer age;

    /**
     * 性别 1（true）男， 0（false）女
     */
    @ApiModelProperty("性别 1（true）男， 0（false）女")
    private Boolean sex;
}
