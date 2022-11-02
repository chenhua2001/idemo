package com.chenhua.modules.employee.domain.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeAddInfo {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 员工姓名
     */
    @ApiModelProperty("员工姓名")
    private String name;

    /**
     * 部门ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("部门号")
    private Long departmentId;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 性别 1（true）男， 0（false）女
     */
    @ApiModelProperty("性别：true：男，false：女")
    private Boolean sex;


    /**
     * 入职时间
     */
    @ApiModelProperty("入职日期")
    private LocalDate enterDateTime;

}
