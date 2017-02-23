package strategypattern;

import strategypattern.impl.FlyWithRocket;

/**
 * Created by zwb on 2017/2/22.
 */
public class SpaceDuck extends Duck {
    public SpaceDuck() {
        super();
        super.setFlyingStragety(new FlyWithRocket());
    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    public void quack() {
        System.out.println("我通过无线电与你通信");
    }
}
