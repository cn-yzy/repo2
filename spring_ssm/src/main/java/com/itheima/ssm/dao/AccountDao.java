package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Account;

import java.util.List;


public interface AccountDao {
    /**
     * 查询所有
     */
    List<Account> findAll();

    /**
     * 通过id查询
     */
    Account findById(Integer id);

    /**
     * 添加
     */
    void insert(Account account);

    /**
     * 更新
     */
    int update(Account account);

    /**
     * 删除
     */
    Boolean delete(Integer id);
}



