package wy.study.learing.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
@DependsOn(value = "wy.study.learing.bean.B")
public class A {
    private B b;
    public B getB(){
        return b;
    }
    public void  setB(B b1){
        this.b=b1;
    }
}
