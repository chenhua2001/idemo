package com.chenhua.modules;

import com.chenhua.modules.account.domain.request.AccountAddRequest;
import com.chenhua.modules.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ITest {
    @Autowired
    AccountService accountService;
    @Test
    public void testAdd(){
        AccountAddRequest accountAddRequest = new AccountAddRequest();
        accountAddRequest.setAccount(19719587105710L);
        accountAddRequest.setEmployeeId(1585926102394638337L);
        boolean b = accountService.addAccount(accountAddRequest);
        System.out.println(b);
    }
    @Test
    public void testGetAccount(){
        Long account = accountService.getAccountByEmployeeId(1585926102394638337L);
        System.out.println(account);
    }

}
