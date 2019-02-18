package cn.ganzhiqiang.javademo.designpatterns.observer;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

public class ConcreteSubject extends Subject{

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }
}
