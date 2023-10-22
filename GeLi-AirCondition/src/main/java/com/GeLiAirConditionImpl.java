package com;

/*
 *@title GeLiAirCondition
 *@description todo 服务提供者，实现类必须要有一个无参构造器
 *@author LYH
 *@version 1.0
 *@create 2023/10/21 15:47
 */
/*
 1.实现接口
 2.在META-INF/services目录下，创建一个接口全限定名的文件，内容是接口的实现类的全限定名
 */
public class GeLiAirConditionImpl implements IAirCondition{
    public GeLiAirConditionImpl() {
    }

    public String getName() {
        return "格力空调";
    }

    public void open() {
        System.out.println("格力空调-开机处理");
    }

    public void close() {
        System.out.println("格力空调-关机处理");
    }

    public void adjustTemperature(int temp) {
        System.out.println("格力空调-温度调整为："+temp+"℃");
    }

    public void changeMode(String mode) {
        System.out.println("格力空调-模式调整为："+mode);
    }
}
