package com.chenhua.modules.access.domain.info;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeListInfo {
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 部门ID
     */
    private String departmentName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1（true）男， 0（false）女
     */
    private Boolean sex;


    /**
     * 入职时间
     */
    private LocalDate enterDateTime;

    /**
     * 修改时间
     */

    private LocalDate updateDateTime;


}
