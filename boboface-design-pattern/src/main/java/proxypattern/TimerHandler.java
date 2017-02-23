package proxypattern;

import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */
public class TimerHandler implements InvocationHandler {

    private Object target;

    public TimerHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public void invoke(Object o, Method m) {
        try {
            long starttime = System.currentTimeMillis();
            System.out.println("汽车开始行驶...");
            m.invoke(target);
            long endtime = System.currentTimeMillis();
            System.out.println("汽车结束行驶... 汽车行驶时间：" + (endtime - starttime) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}