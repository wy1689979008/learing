package wy.study.learing.designPatterns.observe_pattern;

/**
 * 使用者1
 */
public class ObservePattern_user1 implements ObservePattern_observer {

    ObservePattern_subject subject;

    public ObservePattern_user1 (ObservePattern_subject subject) {
        this.subject=subject;
        subject.registerObserve(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("hello 我是No.1"+"==>"+msg);
    }
}
