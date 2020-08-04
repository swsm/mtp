package com.swsm;

/**
 * @author swsm
 * @date 2020/8/3
 */
public enum TypeEmums {
    
    START(0, "开始"),
    BEGIN(1, "又开始"),
    END(2, "结束"),
    ERROR(99, "错误");
    
    private int code;
    private String name;
    
    TypeEmums(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public String getName(int code) {
        for (TypeEmums c : TypeEmums.values()) {
            if (c.code == code) {
                return c.name;
            }
        }
        return TypeEmums.ERROR.name;
    }
    
    
}
