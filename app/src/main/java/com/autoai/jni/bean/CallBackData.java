package com.autoai.jni.bean;

/**
 * @author : YangHaoYi on  2019/4/2617:58.
 * Email  :  yang.haoyi@qq.com
 * Description :回调事件数据Bean
 * Change : YangHaoYi on  2019/4/2617:58.
 * Version : V 1.0
 */
public class CallBackData {

    //名字
    private String name;
    //ID
    private int id;
    //号码
    private int number;

    public CallBackData() {
    }

    public CallBackData(String name,int number, int id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CallBackData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", number=" + number +
                '}';
    }
}
