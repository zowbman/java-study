package proxypattern.jdk;

import proxypattern.Car;
import proxypattern.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zwb on 2017/2/23.JDK动态代理测试类
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h =new TimeHandler(car);
        Class<?> cls = car.getClass();

        /**
         * loader 类加载器
         * interfaces 实现接口
         * h InvocationHandler
         *
         * 动态代理实现思路
         * 实现功能：通过Proxy的newProxyInstance返回代理对象
         * 1、声明源码（动态产生代理）
         * 2、编译源码（JDK Compiler API），产生新的类（代理类）
         * 3、将这个类load到内存中，产生一个新的对象（代理对象）
         * 4、return代理对象
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        InvocationHandler h1 =new LogHandler(m);

        m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h1);
        m.move();
    }
}
