package com;

/*
 *@title IAirCondition
 *@description todo 服务调用者定义实现接口
 *@author LYH
 *@version 1.0
 *@create 2023/10/21 15:34
 */
// 空调遥控器接口
public interface IAirCondition {
    /*
    获取空调类型
     */
    String getName();
    /*
    打开空调
     */
    void open();
    /*
    调节温度
     */
    void close();
    /*
    调节温度
     */
    void adjustTemperature(int temp);
    /*
    改变模式
     */
    void changeMode(String mode);
}
