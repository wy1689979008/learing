package wy.study.learing.designPatterns.observe_pattern;

public class ObservePattern_test {
    public static void main(String[] args) {
        ObservePattern_subject_impl observePatternSubjectImpl=new ObservePattern_subject_impl();
        ObservePattern_observer observer1=new ObservePattern_user1(observePatternSubjectImpl);
        ObservePattern_observer observer2=new ObservePattern_user2(observePatternSubjectImpl);
        observePatternSubjectImpl.setMsg("观察者模式");
        observePatternSubjectImpl.setMsg("单例模式");
    }
}
