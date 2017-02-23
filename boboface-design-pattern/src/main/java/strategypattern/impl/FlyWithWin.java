package strategypattern.impl;

import strategypattern.FlyingStrategy;

/**
 * Created by zwb on 2017/2/23.
 */
public class FlyWithWin implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("展翅高飞");
    }
}
