package observerpattern.weather.pull;

/**
 * Created by zwb on 2017/2/22.具体观察者对象，实现更新方法，使自身的状态和目标状态保持一致
 */
public class ConcreteObserver implements Observer {

    private String observerName;//观察者的名字

    private String weatherContent;//天气内容情况,从目标获取

    private String remindThing;//提醒的内容

    @Override
    public void update(WeatherSubject subject) {
        weatherContent = ((ConcreteWeatherSubject) subject).getWeatherContent();
        System.out.println(observerName + "收到了" + weatherContent + "," + remindThing);
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}
