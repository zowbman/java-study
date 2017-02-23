package strategypattern;

/**
 * Created by zwb on 2017/2/23.超类，所有的鸭子都要继承此类
 * 抽象了鸭子的行为：显示和鸭叫
 */
public abstract class Duck {
    private FlyingStrategy flyingStragety;

    private QuackStrategy quackStrategy;

    public void setFlyingStragety(FlyingStrategy flyingStragety) {
        this.flyingStragety = flyingStragety;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }

    /**
     * 鸭子发出叫声
     * 通用行为，由超类实现
     * 使用策略模式，
     */
    public void quack() {
        //System.out.println("嘎嘎嘎");
        quackStrategy.performQuack();
    }

    /**
     * 显示鸭子的外观
     * 鸭子的外观各不相同，声明为abstract，由子类实现
     */
    public abstract void display();

    public void fly() {
        flyingStragety.performFly();
    }
}
