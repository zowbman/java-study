package observerpattern.weatherV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 2017/2/22.
 */
public abstract class WeatherSubject {
    public List<Observer> observers = new ArrayList<>();//保存注册的观察者

    /**
     * 添加观察者
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected abstract void notifyObservers();
}
