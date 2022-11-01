package com.chenhua.modules.access.controller;



import com.chenhua.modules.access.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chenhua.utils.R;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 账户表 前端控制器
 * </p>
 *
 * @author chenhua
 * @since 2022-10-30
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{employeeId}")
    public Long getAccountByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Long accountByEmployeeId = accountService.getAccountByEmployeeId(employeeId);
        return accountByEmployeeId;
    }
}

