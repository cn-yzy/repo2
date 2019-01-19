package com.ithema.ssm.test;

import com.itheima.ssm.controller.AccountController;
import com.itheima.ssm.dao.AccountDao;
import com.itheima.ssm.domain.Account;
import com.itheima.ssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SsmTest {
    @Test
    public void testDao(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        AccountDao accoutDao = (AccountDao) ac.getBean("accountDao");
        Account byId = accoutDao.findById(1);
        System.out.println(byId);
    }

    //测试service
    @Test
    public void testService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        AccountService service = (AccountService) ac.getBean("accountServiceImpl");
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println("service方法执行了" + account);
        }
        Account byId = service.findById(1);
        System.out.println(byId);

        Account account = new Account();
        account.setName("6666");
        account.setMoney(10000d);
        service.insert(account);
    }
    //测试controller
    @Test
    public void testController(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml","springmvc/springmvc.xml");
        AccountController accoutDao = (AccountController) ac.getBean("accountController");
        accoutDao.findAll();
    }
}
