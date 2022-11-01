package com.chenhua.modules.access.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.access.domain.Employee;
import com.chenhua.modules.access.domain.info.EmployeeListInfo;
import com.chenhua.modules.access.domain.request.EmployeeAddRequest;
import com.chenhua.modules.access.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.access.domain.request.EmployeeUpdateRequest;
import com.chenhua.modules.access.mapper.EmployeeMapper;
import com.chenhua.modules.access.service.AccountClient;
import com.chenhua.modules.access.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenhua.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    AccountClient accountClient;
    @Override
    public Long addEmployee(EmployeeAddRequest employeeInfo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeInfo,employee);
        int insert = employeeMapper.insert(employee);
        //插入成功则返回员工id
        return insert>0?employee.getId():null;
    }

    @Override
    public boolean removeEmployee(Long id) {
        int i = baseMapper.deleteById(id);
        return i>0;
    }

    @Override
    public boolean updateEmployeeById(EmployeeUpdateRequest employeeInfo) {
        Employee employee = new Employee();
        //将前端传入的数据copy到Employee实体中
        BeanUtils.copyProperties(employeeInfo,employee);
        int i = employeeMapper.updateById(employee);
        return i>0;
    }

    @Override
    public Page<EmployeeListInfo> getEmployeeInfoList(EmployeeQueryRequest request, Long current, Long limit) {
        Page<EmployeeListInfo> page = new Page<>(current, limit);
        //xml实现条件查询
        employeeMapper.listEmployees(page,request);
        return page;
    }

    @Override
    public List<Long> getEmployeeAccounts(EmployeeQueryRequest request) {
        Long id = request.getId();
        Long departmentId = request.getDepartmentId();
        Integer maxAge = request.getMaxAge();
        Integer minAge = request.getMinAge();
        String name = request.getName();
        Boolean sex = request.getSex();
        QueryWrapper<Employee> wrapper=new QueryWrapper<Employee>()
                .select("id")
                .eq(ObjectUtil.isNotNull(id),"id",id)
                .eq(ObjectUtil.isNotNull(departmentId),"department_id",departmentId)
                .le(ObjectUtil.isNotNull(maxAge),"age",maxAge)
                .ge(ObjectUtil.isNotNull(minAge),"age",minAge)
                .like(StrUtil.isNotBlank(name),"name",name)
                .eq(ObjectUtil.isNotNull(sex),"sex",sex);
        List<Long> accounts = employeeMapper.selectList(wrapper).stream()
                .map(Employee::getId)
                .map(accountClient::getAccountByEmployeeId)
                .collect(Collectors.toList());
        return accounts;
    }
}
