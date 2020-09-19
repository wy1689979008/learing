package wy.study.learing.designPatterns.template_pattern;


public class Tea extends Parent {
    @Override
    void brew() {
        System.out.println("用热水泡茶");
    }

    @Override
    void addCondiments() {
        System.out.println("把茶调料加入杯子");
    }


}

