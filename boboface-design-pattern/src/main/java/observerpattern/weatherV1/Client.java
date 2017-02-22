package observerpattern.weatherV1;

/**
 * Created by zwb on 2017/2/22.测试类
 */
public class Client {
    public static void main(String[] args) {
        //创建天气作为一个目标
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
        //创建小明的女朋友
        ConcreteObserver gril = new ConcreteObserver();
        gril.setObserverName("小明女朋友");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("小明老妈");

        //注册观察者
        subject.addObserver(gril);
        subject.addObserver(mum);

        //目标更新天气情况
        subject.setContent("天气晴天~");
    }
}
