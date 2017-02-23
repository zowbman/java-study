package strategypattern.impl;

import strategypattern.QuackStrategy;

/**
 * Created by zwb on 2017/2/23.
 */
public class QuackNoWay implements QuackStrategy {
    @Override
    public void performQuack() {
        System.out.println("我不会叫");
    }
}
