package wy.study.learing.designPatterns.template_pattern;

public class test {
    public static void main(String[] args) {
        Caffee coffee=new Caffee();
        coffee.prepareRecipe();

        System.out.println("分割线=============");


        Parent tea=new Tea();
        tea.prepareRecipe();
    }
}
