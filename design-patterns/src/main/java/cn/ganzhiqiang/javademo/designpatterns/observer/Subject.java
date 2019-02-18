package cn.ganzhiqiang.javademo.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqgan
 * @since 2019/1/17
 **/

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
