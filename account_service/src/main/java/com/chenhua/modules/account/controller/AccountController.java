package com.chenhua.modules.account.controller;



import com.chenhua.modules.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ApiOperation(
            value="根据员工号查询对应账户",
            notes = "员工号不能为空",
            response = Long.class
    )
    @GetMapping("/get/{employeeId}")
    public Long getAccountByEmployeeId(@PathVariable(value = "employeeId") Long employeeId){
        Long accountByEmployeeId = accountService.getAccountByEmployeeId(employeeId);
        return accountByEmployeeId;
    }
}

