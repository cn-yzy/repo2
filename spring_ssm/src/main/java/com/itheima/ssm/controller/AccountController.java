package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Account;
import com.itheima.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Account> accountList = service.findAll();
        mv.addObject("accountList", accountList);
        for (Account account : accountList) {
            System.out.println(account);
        }
        mv.setViewName("account-list");
        return mv;
    }

    @RequestMapping("/transfer")
    public ModelAndView transfer(Integer sourceId, Integer targetId, double money) {
        ModelAndView mv = new ModelAndView();
        service.transfer(sourceId, targetId, money);
        mv.addObject("msg", "转账成功");
        mv.setViewName("success");
        return mv;
    }
}
