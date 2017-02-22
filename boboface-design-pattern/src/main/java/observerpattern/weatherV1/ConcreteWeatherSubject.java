package observerpattern.weatherV1;

import java.util.Observable;

/**
 * Created by zwb on 2017/2/22.
 */
public class ConcreteWeatherSubject extends Observable {
    private String content;//天气情况的内容
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
        //天气情况有了，就要通知所有的观察者
        //注意在通知之前，在用java中的Observer模式时候，下面这句话不可少
        this.setChanged();
        //然后主动通知，这里用推的方式
        this.notifyObservers(content);
        //拉方式
        //this.notifyObservers();
    }
}
