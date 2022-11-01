package com.chenhua.modules.access.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.access.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhua.modules.access.domain.info.EmployeeListInfo;
import com.chenhua.modules.access.domain.request.EmployeeAddRequest;
import com.chenhua.modules.access.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.access.domain.request.EmployeeUpdateRequest;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
public interface EmployeeService extends IService<Employee> {
    public Long addEmployee(EmployeeAddRequest employee);
    public boolean removeEmployee(Long id);
    public boolean updateEmployeeById(EmployeeUpdateRequest employeeInfo);
    public Page<EmployeeListInfo> getEmployeeInfoList(EmployeeQueryRequest request, Long current, Long limit);
    public List<Long> getEmployeeAccounts(EmployeeQueryRequest request);
}
