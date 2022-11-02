package com.chenhua.modules.account.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenhua.modules.account.domain.Account;
import com.chenhua.modules.account.domain.request.AccountAddRequest;
import com.chenhua.modules.account.mapper.AccountMapper;
import com.chenhua.modules.account.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author chenhua
 * @since 2022-10-30
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    //根据员工id查询员工账户
    @Override
    public Long getAccountByEmployeeId(Long id) {
        QueryWrapper<Account> queryWrapper=new QueryWrapper<Account>()
                .select("account")
                .eq(ObjectUtil.isNotNull(id),"employee_id",id);
        Account account = accountMapper.selectOne(queryWrapper);
        return ObjectUtil.isNotEmpty(account)?account.getAccount():null;
    }

    //添加账户
    @Override
    public boolean addAccount(AccountAddRequest request) {
        Account account = new Account();
        BeanUtils.copyProperties(request,account);
        int insert = accountMapper.insert(account);
        return insert>0;
    }


}
