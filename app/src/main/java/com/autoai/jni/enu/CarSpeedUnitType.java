package com.autoai.jni.enu;

/**
 * @author : YangHaoYi on  2019/5/1411:26.
 * Email  :  yang.haoyi@qq.com
 * Description :车速单位类型
 * Change : YangHaoYi on  2019/5/1411:26.
 * Version : V 1.0
 */
public enum  CarSpeedUnitType {

    ERROR(-1,"出错"),
    MM(0,"毫米"),
    CM(1,"厘米"),
    METRE(2,"米"),
    KILOMETRE(3,"千米");

    private int code;
    private String unit;

    CarSpeedUnitType(int code, String unit) {
        this.code = code;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public static CarSpeedUnitType get(int code){
        CarSpeedUnitType[] values = CarSpeedUnitType.values();
        for (int i = 0; i != values.length; i++) {
            if (values[i].code == code) {
                return values[i];
            }
        }
        return ERROR;
    }
}
