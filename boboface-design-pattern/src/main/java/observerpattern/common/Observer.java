package observerpattern.common;

/**
 * Created by zwb on 2017/2/22.观察者接口，定义一个更新的接口给那些在目标发生改变时候被通知的对象
 */
public interface Observer {
    /**
     * 更新的接口
     *
     * @param subject
     */
    void update(Subject subject);
}
