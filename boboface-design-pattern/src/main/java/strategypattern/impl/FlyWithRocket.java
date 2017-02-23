package strategypattern.impl;

import strategypattern.FlyingStrategy;

/**
 * Created by zwb on 2017/2/23.
 */
public class FlyWithRocket implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("用火箭在太空遨游");
    }
}
