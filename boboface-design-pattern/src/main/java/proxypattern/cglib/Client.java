package proxypattern.cglib;

/**
 * Created by zwb on 2017/2/23.
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }
}
