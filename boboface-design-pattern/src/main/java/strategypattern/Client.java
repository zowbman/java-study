package strategypattern;

/**
 * Created by zwb on 2017/2/23.策略模式
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 策略模式的适用场景
         * 1）许多相关的类仅仅是行为差异
         * 2）运行时选取不同的算法辩题
         * 3）通过条件语句在多分支中选取一
         */
        Duck duck = null;
        //duck = new MallardDuck();
        //duck = new RedheadDuck();
        //duck = new RubberDuck();
        //duck = new BigYellow();
        duck = new SpaceDuck();
        duck.display();
        duck.quack();
        duck.fly();
    }
}
