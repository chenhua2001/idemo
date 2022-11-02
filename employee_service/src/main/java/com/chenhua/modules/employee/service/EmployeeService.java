package com.chenhua.modules.employee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.employee.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhua.modules.employee.domain.info.EmployeeAddInfo;
import com.chenhua.modules.employee.domain.info.EmployeeListInfo;
import com.chenhua.modules.employee.domain.request.EmployeeAddRequest;
import com.chenhua.modules.employee.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.employee.domain.request.EmployeeUpdateRequest;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
public interface EmployeeService extends IService<Employee> {
    public EmployeeAddInfo addEmployee(EmployeeAddRequest employee);
    public boolean removeEmployee(Long id);
    public boolean updateEmployeeById(EmployeeUpdateRequest employeeInfo);
    public Page<EmployeeListInfo> getEmployeeInfoList(EmployeeQueryRequest request, Long current, Long limit);
    public List<Long> getEmployeeAccounts(EmployeeQueryRequest request);
}
