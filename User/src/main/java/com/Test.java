package com;

import java.util.Iterator;
import java.util.ServiceLoader;

/*
 *@title test
 *@description todo 面向接口编程，不使用的实现类
 *              为某个接口寻找服务的机制，类似IOC思想，将装配的控制权交给ServiceLoader.
 *              只提供服务接口，具体服务由其他组件实现，接口和具体实现分离（类似桥接），
 *               同时能够通过系统的ServiceLoader拿到这些实现类的集合，统一处理，
 *               这样在组件化中往往会带来很多便利，SPI机制可以实现不同模块之间方便的面向接口编程，
 *               拒绝了硬编码的方式，解耦效果很好。
 *@author LYH
 *@version 1.0
 *@create 2023/10/21 15:55
 */
public class Test {
    public static void main(String[] args) {
        openAirCondition("美的空调");
    }

    public static void openAirCondition(String airConditionName) {
        IAirCondition target = null;
        // 扫描classpath下 所有 IAirCondition 接口的实现类
        //todo 事实上 load方法只是做了一些初始化的工作，并没有注册服务，所以这是一个懒加载过程（LazyIterator的命名也透露了这点）
        ServiceLoader<IAirCondition> load = ServiceLoader.load(IAirCondition.class);
        Iterator<IAirCondition> iterator = load.iterator();
        while (iterator.hasNext()) {
            IAirCondition next = iterator.next();
            System.out.println("发现服务：" + next.getName());
            if (next.getName().equals(airConditionName)) {
                target = next;
            }
        }
//        for(IAirCondition airCondition:load){
//            System.out.println("发现服务："+airCondition.getName());
//            if(airCondition.getName().equals(airConditionName)){
//                target=airCondition;
//            }
//        }
        if (target != null) {
            target.open();
        }
    }
}
