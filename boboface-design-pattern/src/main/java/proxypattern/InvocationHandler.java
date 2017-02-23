package proxypattern;

import java.lang.reflect.Method;

/**
 * Created by zwb on 2017/2/23.
 */
public interface InvocationHandler {
    public void invoke(Object o, Method m);
}
