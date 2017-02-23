package proxypattern;

/**
 * Created by zwb on 2017/2/23.
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        // TODO Auto-generated method stub
        super.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间：" + (endtime - starttime) + "毫秒");
    }
}