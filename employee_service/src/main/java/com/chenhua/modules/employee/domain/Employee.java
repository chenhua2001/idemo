package com.chenhua.modules.employee.domain;


import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
@Data
@TableName("t_employee")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
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

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;

    /**
     * 入职时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime enterDateTime;

    /**
     * 更改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDateTime;


}
