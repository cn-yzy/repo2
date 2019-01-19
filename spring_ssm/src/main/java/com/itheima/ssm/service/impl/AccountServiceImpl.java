package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.AccountDao;
import com.itheima.ssm.domain.Account;
import com.itheima.ssm.exception.AccountNotFoundException;
import com.itheima.ssm.exception.MoneyException;
import com.itheima.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public Boolean delete(Integer id) {
        return accountDao.delete(id);
    }

    @Override
    public void transfer(Integer sourceId, Integer targetId, double money) {
        //查询账户
        Account sourceAccount = accountDao.findById(sourceId);
        Account targetAccount = accountDao.findById(targetId);
        //判断余额是否>转账金额
            if (sourceAccount == null){
                throw new AccountNotFoundException("转出用户不存在");
            }
            if (targetAccount == null){
            throw new AccountNotFoundException("转入用户不存在");
            }
            if (sourceAccount.getMoney() < money){
                throw new MoneyException("金额不足");
            }
            if (money < 0){
                throw new MoneyException("转行金额不能为负数");
            }
            //转出用户减钱
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            accountDao.update(sourceAccount);

            //收款方加钱
            targetAccount.setMoney(targetAccount.getMoney()+money);
            accountDao.update(targetAccount);


    }
}
