package proxypattern.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */
public class TimeHandler implements InvocationHandler {

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    private Object target;

    /**
     * 参数：
     * proxy 被代理对象
     * method 被代理对象的方法
     * args 方法参数
     * <p>
     * 返回值：
     * Object 方法访问值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        method.invoke(target);
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间：" + (endtime - starttime) + "毫秒");
        return null;
    }

}
