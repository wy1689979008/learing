package wy.study.learing.designPatterns.template_pattern;

public class Caffee extends Parent {
    @Override
    void brew() {
        System.out.println("用热水泡咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("把咖啡调料加入杯子");
    }

    @Override
    boolean ifAddCondiments() {
        return false;
    }
}
