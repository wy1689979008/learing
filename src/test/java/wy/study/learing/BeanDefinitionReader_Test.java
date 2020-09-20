package wy.study.learing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanDefinitionReader_Test {
    @Test
    public void PropertityBeanDefinitionReader_test(){
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition();
        BeanDefinitionRegistry beanDefinitionRegistry=new SimpleBeanDefinitionRegistry();
        AbstractBeanDefinitionReader reader=new PropertiesBeanDefinitionReader(beanDefinitionRegistry);
        reader.loadBeanDefinitions("application.properties");
        String[] beanDefinitionNames = beanDefinitionRegistry.getBeanDefinitionNames();
        beanDefinitionRegistry.registerBeanDefinition("wy.study.learing.bean.Person",beanDefinition);
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        //beanDefinition.
        for (String s:beanDefinitionNames){
            System.out.println(s);
        }
    }
}
