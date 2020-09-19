package wy.study.learing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.File;

@SpringBootTest
class LearingApplicationTests<StringRedisTemplate> {
   @Autowired
   private RedisTemplate redisTemplate;

   @Autowired
   private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() throws Exception{
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("application.yml");
        File file = resource.getFile();
        String[] list = file.list();
        for (String l:list){
            System.out.printf(l);
        }
        //string结构
        //redisTemplate.opsForValue().set("zhangsan","1");
        //Object zhnagsna = redisTemplate.opsForValue().get("zhnagsna");
        //System.out.println(zhnagsna);
        //hash结构
        //redisTemplate.opsForHash().put("wangy","sswy","2");
        //System.out.println(redisTemplate.opsForHash().get("wangy","sswy"));
        //list结构
        for (int i=0;i<100;i++){
            redisTemplate.opsForList().leftPush(i,i);
            System.out.println(redisTemplate.opsForList().leftPop(i));
        }
    }

}
