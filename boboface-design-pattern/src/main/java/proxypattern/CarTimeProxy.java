package proxypattern;

/**
 * Created by zwb on 2017/2/23.聚合是什么，就是一个类当中调用另外一个类的对象
 */
public class CarTimeProxy implements Moveable {

    public CarTimeProxy(Moveable m) {
        super();
        this.m = m;
    }

    private Moveable m;

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        m.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间：" + (endtime - starttime) + "毫秒");
    }
}