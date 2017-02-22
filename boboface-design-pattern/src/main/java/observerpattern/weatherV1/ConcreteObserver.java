package observerpattern.weatherV1;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by zwb on 2017/2/22.具体的观察者对象
 */
public class ConcreteObserver implements Observer {

    private String observerName;//观察者名称

    @Override
    public void update(Observable o, Object arg) {
        //推模式
        System.out.println(observerName + "收到消息，目标推送过来的是" + arg);
        //拉模式
        System.out.println(observerName + "收到消息，主动到目标对象中拉，拉的内容是" + ((ConcreteWeatherSubject) o).getContent());
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }
}
