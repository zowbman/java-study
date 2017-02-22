package observerpattern.common;

/**
 * Created by zwb on 2017/2/22.具体观察者对象，实现更新方法，使自身的状态和目标状态保持一致
 */
public class ConcreteObserver implements Observer {
    private String observerState;//观察者状态

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getSubjectState();
    }
}
