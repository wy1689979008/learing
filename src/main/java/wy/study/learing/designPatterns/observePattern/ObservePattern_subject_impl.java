package wy.study.learing.designPatterns.observePattern;

import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class ObservePattern_subject_impl implements ObservePattern_subject {
    private Set<ObservePattern_observer> observers=new HashSet<>();

    private String msg;

    @Override
    public void registerObserve(ObservePattern_observer observePattern_observer) {
        if (StringUtils.isEmpty(observePattern_observer)){
            return;
        }
        observers.add(observePattern_observer);
    }

    @Override
    public void removeObserver(ObservePattern_observer observePattern_observer) {
        if (observers.contains(observePattern_observer)) {
            observers.remove(observePattern_observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (ObservePattern_observer observer : observers) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg){
        this.msg=msg;
        notifyObserver();
    }
}
