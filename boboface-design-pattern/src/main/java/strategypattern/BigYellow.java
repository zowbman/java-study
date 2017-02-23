package strategypattern;

import strategypattern.impl.FlyNoWay;
import strategypattern.impl.QuackNoWay;

/**
 * Created by zwb on 2017/2/23.
 */
public class BigYellow extends Duck {
    public BigYellow() {
        super();
        super.setFlyingStragety(new FlyNoWay());
        super.setQuackStrategy(new QuackNoWay());
    }

    @Override
    public void display() {
        System.out.println("我身体很大，全身黄黄");
    }
}
