package com.tortoise.ac.dal.dao.account;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020-01-13
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateDo implements Serializable {

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

    /**
     * account
     */
    private static final long serialVersionUID = 1L;
}