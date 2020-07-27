package wy.study.learing.abstract_test;

import org.springframework.stereotype.Component;

@Component
public class Sun extends Parent {
    public String test(){
        String testa = bImpl.testa();
        return testa;
    }
}
