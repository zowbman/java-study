package observerpattern.weather.pull;

/**
 * Created by zwb on 2017/2/22.这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param subject
     */
    void update(WeatherSubject subject);
}
