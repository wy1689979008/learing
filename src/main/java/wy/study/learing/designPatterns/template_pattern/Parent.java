package wy.study.learing.designPatterns.template_pattern;

public abstract class Parent {
    final void prepareRecipe() {
        //模板步骤
        //1：烧开水  2：将豆子或者茶叶导入壶烧 3：将烧好的饮料导入杯子 4：往杯子中添加调料
        boilWater();
        brew();
        pourInCup();
        if (ifAddCondiments()) {
            addCondiments();
        }
    }

    //用热水泡茶叶或咖啡
    abstract void brew();

    //在饮料中加调料
    abstract void addCondiments();

    void boilWater() {
        System.out.println("烧开水");
    }

    void pourInCup() {
        System.out.println("把饮料倒进杯子");
    }

    //钩子，实现与否由调用者自己决定，默认true
    boolean ifAddCondiments() {
        return true;
    }
}
