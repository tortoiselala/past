package com.tortoise.common.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tortoielala
 */
@ToString
@Getter
public enum StatusCode implements Serializable {
    SUCCESS(0, "成功"),
    ILLEGAL_PARAMETER(-102, "无效的参数"),
    DUPLICATE_INVOKE(-108, "重复调用"),
    PARAMETER_LACK(-101, "请求参数缺失"),
    BODY_LACK(-100, "post请求消息体缺失"),
    ILLEGAL_TOKEN(-106, "非法的token"),
    NO_RELATED_DATA(-107, "无相关数据"),
    FAILED(-110, "操作失败"),
    OPERATE_UP_LIMIT(-111, "操作上限"),
    DATA_EMPTY(-302, "返回数据为空"),
    PARSE_ERROR(-306, "参数解析失败"),
    DATA_ERROR(-307, "返回数据格式错误"),
    ILLEGAL_SIGN(-701, "无效的签名"),
    OVERDUE_TIME(-702, "超时的时间戳"),
    ERROR_REQUEST(-995, "错误的请求"),
    DB_ERROR(-996, "数据库异常"),
    INNER_SERVER_ERROR(-997, "非正常的内部服务"),
    SERVERS_LINK_ERROR(-998, "服务器间通信异常"),
    DUPLICATE_PARAM(-112, "重复的参数"),
    OTHER_SERVER_ERROR(-999, "亲，服务器君又开小差了.您放心，我们的程序猿正批评教育之");


    private Integer code;
    private String desc;

    StatusCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static StatusCode of(Integer code) {
        if (code != null) {
            for (StatusCode e : values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
