package observerpattern.weatherV2;

/**
 * Created by zwb on 2017/2/22.定义一个更新的接口方法给那些在目标发生改变的时候被通知的观察者对象调用
 */
public interface Observer {
    /**
     * 更新的接口
     *
     * @param subject
     */
    void update(WeatherSubject subject);

    /**
     * 设置观察者名称
     *
     * @param observerName
     */
    void setObserverName(String observerName);

    /**
     * 取得观察者名称
     *
     * @return
     */
    String getObserverName();
}
