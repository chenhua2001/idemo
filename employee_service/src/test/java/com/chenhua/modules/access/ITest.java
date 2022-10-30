package com.chenhua.modules.access;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.access.domain.Employee;
import com.chenhua.modules.access.domain.info.EmployeeListInfo;
import com.chenhua.modules.access.domain.request.EmployeeQueryRequest;
import com.chenhua.modules.access.mapper.EmployeeMapper;
import com.chenhua.modules.access.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ITest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void testGet(){
        Employee one = employeeService.getOne(null);
        System.out.println(one);
    }
    @Test
    public void testDelete(){
        boolean remove = employeeService.removeById(1585977361323524098L);
        System.out.println(remove);
        int i = employeeMapper.deleteById(1585977361323524098L);
        System.out.println(i);
    }
    @Test
    public void testList(){
        EmployeeQueryRequest employeeQueryRequest = new EmployeeQueryRequest()
                .setName("en");
        Page<EmployeeListInfo> employeeListInfoPage = new Page<>(2, 2);
        IPage<EmployeeListInfo> employeeListInfoIPage = employeeMapper.listEmployees(employeeListInfoPage, employeeQueryRequest);
        System.out.println(employeeListInfoIPage);
    }
}
