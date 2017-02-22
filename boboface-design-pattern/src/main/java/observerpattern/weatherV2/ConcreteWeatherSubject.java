package observerpattern.weatherV2;

/**
 * Created by zwb on 2017/2/22.
 */
public class ConcreteWeatherSubject extends WeatherSubject {
    private String weatherContent;//目标对象的状态("晴天""下雨""下雪")

    @Override
    protected void notifyObservers() {
        //循环所有注册的观察者
        for (Observer observer : observers) {
            //规则是：
            //小明女朋友：下雨通知
            //小明老妈：下雨、下雪通知
            if ("下雨".equals(this.getWeatherContent())) {
                if ("小明女朋友".equals(observer.getObserverName())) {
                    observer.update(this);
                }
                if ("小明老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }
            if ("下雪".equals(this.getWeatherContent())) {
                if ("小明老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }
        }
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}
