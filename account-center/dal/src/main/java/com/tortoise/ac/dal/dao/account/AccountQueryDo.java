package com.tortoise.ac.dal.dao.account;

import com.tortoise.common.base.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountQueryDo extends Page {

    /**
     * UID集合
     */
    private Set<Long> accountUidSet;

    /**
     * 账户状态
     */
    private Set<Integer> statusSet;

    /**
     * 性别集合
     */
    private Set<Integer> sexSet;

    /**
     * logo集合
     */
    private Set<String> logoSet;

    /**
     * 昵称集合
     */
    private Set<String> nickSet;
}
