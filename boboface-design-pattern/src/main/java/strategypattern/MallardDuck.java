package strategypattern;

import strategypattern.impl.FlyWithWin;

/**
 * Created by zwb on 2017/2/23.
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        super();
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是红色的");
    }
}
