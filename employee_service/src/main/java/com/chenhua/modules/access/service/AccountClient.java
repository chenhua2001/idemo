package com.chenhua.modules.access.service;


import com.chenhua.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
@Component
public interface AccountClient {
    @GetMapping("/account/{employeeId}")
    public Long getAccountByEmployeeId(@PathVariable("employeeId") Long employeeId);
}
