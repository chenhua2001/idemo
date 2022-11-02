package com.chenhua.modules.account.mapper;

import com.chenhua.modules.account.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账户表 Mapper 接口
 * </p>
 *
 * @author chenhua
 * @since 2022-10-30
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
