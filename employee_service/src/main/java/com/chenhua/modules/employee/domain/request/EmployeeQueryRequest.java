package com.chenhua.modules.employee.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/*
* 查询员工条件
* */
@Data
@Accessors(chain = true)
public class EmployeeQueryRequest {

    /*
    * 员工id（精确查询）
    * */
    @ApiModelProperty("员工ID")
    private Long id;

    /**
     * 员工姓名(模糊查询）
     */
    @ApiModelProperty("员工姓名，支持模糊查询")
    private String name;

    /**
     * 部门ID（精确查询）
     */
    @ApiModelProperty("部门id")
    private Long departmentId;

    /**
     * 最小年龄（区间查询）
     */
    @ApiModelProperty("年龄 数据年龄区间[18,60]")
    private Integer minAge;
    /*
    * 最大年龄
    * */
    @ApiModelProperty("年龄 数据年龄区间[18,60]")
    private Integer maxAge;
    /**
     * 性别 1（true）男， 0（false）女（精确查询）
     */
    @ApiModelProperty("性别 1（true）男， 0（false）女")
    private Boolean sex;
}
