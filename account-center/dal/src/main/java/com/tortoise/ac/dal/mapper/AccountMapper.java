package com.tortoise.ac.dal.mapper;


import com.tortoise.ac.dal.dao.account.*;

import java.util.List;

/**
 * @author wuyangmin
 */
public interface AccountMapper {
    /**
     * 插入新数据
     * @param record record
     * @return result
     */
    int insert(AccountCreateDo record);

    /**
     * 更新数据
     * @param record record
     * @return result
     */
    int update(AccountUpdateDo record);

    /**
     * 删除数据
     * @param record record
     * @return result
     */
    int delete (AccountDeleteDo record);

    /**
     * 查询
     * @param queryDo 查询条件
     * @return result
     */
    List<AccountDo> query (AccountQueryDo queryDo);
}