package proxypattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 获取代理类
     *
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        //设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 拦截所有目标类方法的调用
     * obj 目标类的实例
     * m 目标方法的反射对象
     * args 方法参数
     * proxy 代理类的实例
     */
    public Object intercept(Object obj, Method m, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("日志开始...");
        //代理类调用父类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("日志结束...");
        return null;
    }
}