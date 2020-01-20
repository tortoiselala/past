package com.tortoise.common.base;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
public class StateCode implements Serializable {
    /**
     * 状态注册
    **/
    private final static Map<Integer, StateCode> lookup = Maps.newHashMap();
    /**
     *  状态码值
     **/
    private Integer code;
    /**
     * 状态描述
     **/
    private String desc;

    public StateCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
        //重复状态码侦测
        if(code != null && lookup.put(code, this) != null) {
            throw new IllegalArgumentException(
                    String.format("duplicated code[%d]", code));
        }
    }

    public static StateCode of(Integer code, String desc){
        return new StateCode(code, desc);
    }

    /**
     * 根据状态码找到状态码类
     *
     * @param code 状态码
     * @param clazz 要获取的stateCode的归属类，命名规范为：[APPID]StateCode
     *
     * @return 状态码类实例
     */
    public static StateCode get(int code, Class<?> clazz) {
        register(clazz);
        StateCode stateCode = lookup.get(code);
        /* 无效状态码 */
        if(stateCode == null) {
            throw new IllegalArgumentException(
                    String.format("invalid code[%d]", code));
        }

        return stateCode;
    }

    /**
     * 激活状态码归集类
     *
     * @param clazz 状态码归集类
     */
    public static void register(Class<?> clazz) {
        try {
            Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 状态码判定
     *
     * @param code  状态码值
     * @param stateCode 要匹配的状态码类型
     * @return true 如果状态码成功匹配
     */
    public static boolean is(int code, StateCode stateCode) {
        if(stateCode == null) {
            throw new IllegalArgumentException("stateCode is null");
        }

        return stateCode.equals(get(code, StateCode.class));
    }

    /* 状态码 */
    public int getCode() {
        return code;
    }
    /* 状态码描述 */
    public String getDesc() {
        return desc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)  {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final StateCode other = (StateCode) obj;

        return Objects.equal(this.code, other.code);
    }

    @Override
    public int hashCode() {
        return HashCode.fromInt(code).asInt();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", this.code)
                .add("desc", this.desc)
                .toString();
    }
}
