package observerpattern.weather.push;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 2017/2/22.
 */
public class WeatherSubject {
    private List<Observer> observers = new ArrayList<>();//用来保存注册的观察者对象

    /**
     * 把订阅天气的人添加到订阅天气的人
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除集合中的指定订阅天气的人
     *
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有已经订阅天气的人
     */
    protected void notifyObservers(String content) {
        for (Observer observer : observers) {
            observer.update(content);
        }
    }
}
