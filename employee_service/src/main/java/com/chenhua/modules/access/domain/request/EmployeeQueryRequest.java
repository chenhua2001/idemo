package com.chenhua.modules.access.domain.request;

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
    private Long id;
    /**
     * 员工姓名(模糊查询）
     */
    private String name;

    /**
     * 部门ID（精确查询）
     */
    private Long departmentId;

    /**
     * 最小年龄（区间查询）
     */
    private Integer minAge;
    /*
    * 最大年龄
    * */
    private Integer maxAge;
    /**
     * 性别 1（true）男， 0（false）女（精确查询）
     */
    private Boolean sex;
}
