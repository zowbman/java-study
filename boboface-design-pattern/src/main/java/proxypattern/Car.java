package proxypattern;

import java.util.Random;

/**
 * Created by zwb on 2017/2/23.
 */
public class Car implements Moveable {

    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

