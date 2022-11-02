package com.chenhua.modules.employee.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.employee.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhua.modules.employee.domain.info.EmployeeListInfo;
import com.chenhua.modules.employee.domain.request.EmployeeQueryRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author chenhua
 * @since 2022-10-28
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    public IPage<EmployeeListInfo> listEmployees(Page<?> page,EmployeeQueryRequest request);

}
