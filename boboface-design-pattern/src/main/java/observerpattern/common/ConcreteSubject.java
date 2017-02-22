package observerpattern.common;

/**
 * Created by zwb on 2017/2/22.具体的目标对象，负责把有关状态存入到相应的观察者对象中
 */
public class ConcreteSubject extends Subject {
    private String subjectState;//目标对象状态

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }
}
