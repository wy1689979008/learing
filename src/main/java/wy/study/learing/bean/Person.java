package wy.study.learing.bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String sex;
    private Integer age;
    public Person(String name){
        this.name=name;
    }
}
