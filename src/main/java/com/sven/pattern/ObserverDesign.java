package com.sven.pattern;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sven.zhang
 * @since 2017-09-18
 * @note 观察者设计模式
 * @note 一对多关系，当一对象状态改变，其他依赖对象收到通知，改变状态
 */
public class ObserverDesign {

    class Subject {

        private Set<Observer> observerSet = new HashSet<>();

        public void registerObserver(Observer observer) {
            observerSet.add(observer);
            System.out.println("add a Observer");
        }

        public void removeObserver(Observer observer) {
            observerSet.remove(observer);
            System.out.println("delete a Observer");
        }

        public void notice() {
            for (Observer observer : observerSet) {
                observer.update();
            }
        }
    }

    interface Observer {

        void update();
    }

    class FirstObserver implements Observer {

        @Override
        public void update() {
            System.out.println("i want fly");
        }
    }

    public static void main(String[] args) {
        ObserverDesign observerDesign = new ObserverDesign();
        Subject subject = observerDesign.new Subject();
        Observer observer = observerDesign.new FirstObserver();
        subject.registerObserver(observer);
        subject.notice();
        subject.removeObserver(observer);
    }
}
