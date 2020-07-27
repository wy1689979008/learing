package wy.study.learing.designPatterns.observePattern;

/**
 * 观察者模式，定义三个接口，注册，移除，通知
 */
public interface ObservePattern_subject {
    /**
     * 注册
     */
    void registerObserve(ObservePattern_observer observePattern_observer);

    /**
     * 移除
     */
    void removeObserver(ObservePattern_observer observePattern_observer);

    /**
     * 通知
     */
    void notifyObserver();
}
