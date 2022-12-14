package com.chenhua.modules.account.service;

import com.chenhua.modules.account.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhua.modules.account.domain.request.AccountAddRequest;

/**
 * <p>
 * 账户表 服务类
 * </p>
 *
 * @author chenhua
 * @since 2022-10-30
 */
public interface AccountService extends IService<Account> {
    public Long getAccountByEmployeeId(Long id);
    public boolean addAccount(AccountAddRequest request);
}
