package com.chenhua.modules.access.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.access.domain.Employee;
import com.chenhua.modules.access.domain.info.EmployeeListInfo;
import com.chenhua.modules.access.domain.request.EmployeeAddRequest;
import com.chenhua.modules.access.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.access.domain.request.EmployeeUpdateRequest;
import com.chenhua.modules.access.service.EmployeeService;
import com.chenhua.modules.access.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
@RestController
@RequestMapping("/access/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //添加员工
    @PostMapping
    public R addEmployee(@RequestBody @Valid EmployeeAddRequest employee){
        //插入成功，返回员工id，否则为null
        Long id = employeeService.addEmployee(employee);
        return id!=null?R.ok().message("添加员工成功").data("employeeId",id)
                :R.error().message("添加用户失败");
    }

    //删除员工（逻辑删除）
    @DeleteMapping("/{id}")
    public R deleteEmployee(@PathVariable Long id){
        boolean success = employeeService.removeEmployee(id);
        return success?R.ok().message("已经删除员工: 员工号为【"+id+"】")
                :R.error().message("删除员工失败");
    }

    //更新员工信息
    @PutMapping
    public R updateEmployee(@RequestBody @Valid EmployeeUpdateRequest request){
        boolean update = employeeService.updateEmployeeById(request);
        return update?R.ok().message("更新员工信息成功"):
                R.error().message("更新员工信息失败");
    }


    //查询员工信息（返回全面的信息）
    @GetMapping("/list/{current}/{limit}")
    public R getEmployees(@RequestBody EmployeeQueryRequest request,
                          @PathVariable Long current,
                          @PathVariable Long limit){
        Page<EmployeeListInfo> employeeInfoList = employeeService.getEmployeeInfoList(request, current, limit);
        return R.ok().message("查询员工列表成功")
                .data("items",employeeInfoList.getRecords())
                .data("total",employeeInfoList.getTotal())
                .data("pages",employeeInfoList.getPages());
    }
    //查询员工信息，只返回符合条件的员工（id)和数量
    @GetMapping("/ids")
    public R getEmployeeIds(@RequestBody EmployeeQueryRequest request){

    }




}

