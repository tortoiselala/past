package com.tortoise.ac.dal.dao.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDo {
    /**
     * UID
     */
    private Long uid;

    /**
     * 账户状态
     */
    private Integer status;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户头像
     */
    private String logo;

    /**
     * 昵称
     */
    private String nick;
}
