package spring;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflect {
    @Test
    public void testReflect() throws Exception {
        Service service=new Service();
        Class<? extends Service> aClass = service.getClass();
        Field declaredField = aClass.getDeclaredField("aaa");
        declaredField.setAccessible(true);
        Reflect reflect=new Reflect();
        declaredField.set(service,reflect);
        //Arrays.asList(service.getReflect());
    }
}
