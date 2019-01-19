package com.itheima.ssm.service;

import com.itheima.ssm.domain.Account;
import java.util.List;
public interface AccountService {
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

    /**
     * 转账
     *
     */
    void transfer(Integer sourceId,Integer targetId, double money);
}
