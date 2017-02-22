package observerpattern.weatherV2;

/**
 * Created by zwb on 2017/2/22.
 */
public class Client {
    public static void main(String[] args) {
        //区别对待观察者

        //1、创建目标
        ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();

        //2、创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("小明女朋友");
        observerGirl.setRemindThing("下雨啦，呆在家里");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("小明老妈");
        observerMum.setRemindThing("不管下雨和下雪都不出门");

        //3、注册观察者
        weatherSubject.attach(observerGirl);
        weatherSubject.attach(observerMum);

        //4、目标发布天气
        //weatherSubject.setWeatherContent("下雨");
        weatherSubject.setWeatherContent("下雪");
    }
}
