package strategypattern;

import strategypattern.impl.FlyWithWin;

/**
 * Created by zwb on 2017/2/22.
 */
public class RedheadDuck extends Duck {
    public RedheadDuck() {
        super();
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }
}
