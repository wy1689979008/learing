package wy.study.learing.reflect;

import org.springframework.web.bind.annotation.RestController;
import wy.study.learing.controller.study;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;

public class Reflect_test1 {
    public static void main(String[] args) throws ClassNotFoundException {

//        Field[] declaredFields = study.class.getDeclaredFields();
//        for (Field f:declaredFields){
//            System.out.println(f);
//        }
//        System.out.println("===>方法：");
//        Method[] methods = study.class.getMethods();
//        for (Method m:methods){
//            System.out.println(m);
//        }


        Class<?> aClass =
                Class.forName("wy.study.learing.controller.study");
        Annotation[] declaredAnnotations =
                aClass.getDeclaredAnnotations();

        for (Annotation a:declaredAnnotations){
            System.out.println(a);
        }


    }
}
