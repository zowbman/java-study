package observerpattern.weather.push;

/**
 * Created by zwb on 2017/2/22.推模式
 */
public class Client {
    public static void main(String[] args) {
        //1、创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
        //2、创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("小明的女朋友");
        observerGirl.setRemindThing("是我们的第一次约会，地点你家");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("小明的老妈");
        observerMum.setRemindThing("逛街");

        //3、注册观察者
        weather.attach(observerGirl);
        weather.attach(observerMum);

        //4、目标发布天气
        weather.setWeatherContent("明天是一个好日子");

        //统一通知，分别处理
    }
}
