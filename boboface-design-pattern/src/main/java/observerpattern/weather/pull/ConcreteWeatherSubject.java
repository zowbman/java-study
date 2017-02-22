package observerpattern.weather.pull;

/**
 * Created by zwb on 2017/2/22.
 */
public class ConcreteWeatherSubject extends WeatherSubject {
    private String weatherContent;//获取天气内容信息

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers(weatherContent);//内容有了，说明天气更新了，通知所有的订阅的人
    }
}
