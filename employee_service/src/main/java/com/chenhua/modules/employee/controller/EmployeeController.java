package com.chenhua.modules.employee.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.employee.domain.info.EmployeeAddInfo;
import com.chenhua.modules.employee.domain.info.EmployeeListInfo;
import com.chenhua.modules.employee.domain.request.EmployeeAddRequest;
import com.chenhua.modules.employee.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.employee.domain.request.EmployeeUpdateRequest;
import com.chenhua.modules.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
@RestController
@RequestMapping("/employee")
@Api(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //添加员工
    @PostMapping("/add")
    @ApiOperation(
            value="添加员工信息",
            notes="姓名不为空，部门不为空，年龄应该在18-60",
            response = EmployeeAddInfo.class
    )
    public ResponseEntity<EmployeeAddInfo> addEmployee(@RequestBody @Valid EmployeeAddRequest employee){
        //插入成功，返回员工信息，否则为null
        EmployeeAddInfo employeeAddInfo = employeeService.addEmployee(employee);
        return employeeAddInfo!=null?ResponseEntity.status(HttpStatus.CREATED).body(employeeAddInfo)
                :ResponseEntity.badRequest().build();
    }

    //删除员工（逻辑删除）
    @ApiOperation(
            value="删除员工",
            response = String.class
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@ApiParam(value = "待删除员工的id") @PathVariable Long id){
        boolean success = employeeService.removeEmployee(id);
        return success?ResponseEntity.ok().body("删除员工成功")
                :ResponseEntity.badRequest().body("删除员工失败");
    }

    //更新员工信息
    @ApiOperation(
            value="更新员工信息",
            notes = "员工号不能为空",
            response = String.class
    )
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid EmployeeUpdateRequest request){
        boolean update = employeeService.updateEmployeeById(request);
        return update?ResponseEntity.ok().body("更新成功"):
                ResponseEntity.badRequest().body("更新失败");
    }

    //查询员工信息（返回全面的信息）
    @ApiOperation(
            value="分页查询员工信息列表",
            response = EmployeeListInfo.class
    )
    @PostMapping("/list/{current}/{limit}")
    public ResponseEntity<Page<EmployeeListInfo>> getEmployees(@RequestBody EmployeeQueryRequest request,
                          @ApiParam(value = "当前页面号",required = true) @PathVariable Long current,
                          @ApiParam(value = "每页显示数量",required = true) @PathVariable Long limit){
        Page<EmployeeListInfo> employeeInfoList = employeeService.getEmployeeInfoList(request, current, limit);
        return ResponseEntity.ok(employeeInfoList);
    }

    //查询员工信息，只返回符合条件的员工的账号
    @ApiOperation(
            value="查询符合条件的员工的账号",
            response = List.class
    )
    @PostMapping("/accounts/get")
    public ResponseEntity<List<Long>> getEmployeeIds(@RequestBody EmployeeQueryRequest request){
        List<Long> employeeAccounts = employeeService.getEmployeeAccounts(request);
        return ResponseEntity.ok(employeeAccounts);
    }




}

