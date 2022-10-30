package com.chenhua.modules.access.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhua.modules.access.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhua.modules.access.domain.info.EmployeeListInfo;
import com.chenhua.modules.access.domain.request.EmployeeQueryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

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
