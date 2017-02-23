package proxypattern.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */
public class LogHandler implements InvocationHandler {

    public LogHandler(Object target) {
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
        System.out.println("日志开始...");
        method.invoke(target);
        System.out.println("日志结束...");
        return null;
    }

}
