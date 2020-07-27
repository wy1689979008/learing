package wy.study.learing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wy.study.learing.abstract_test.Sun;
import wy.study.learing.bean.A;
import wy.study.learing.bean.AutoGetField;
import wy.study.learing.bean.AutoValue;
import wy.study.learing.service.AService;
import wy.study.learing.service.RedisStudy;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.concurrent.*;


@RestController
@RequestMapping(value = "/wy")
public class study {
    @Autowired
    private RedisStudy redisStudy;
    public String a = "1";
    public int i = 0;
    @AutoGetField(description = "wy", length = 15)
    private String name;
    @AutoValue(value = "${remain.time}")
    private String valu;

    @Autowired
    private Sun sun;

    @Autowired
    @Qualifier("aservice")
    private AService aService;

    @Resource(name = "bservice")
    private AService bb;
    static int j = 0;


    @GetMapping("/study")
    @ResponseBody
    public int test(String userName) {

        try {
            A a = A.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BlockingQueue<Runnable> workQueue = null;
        ExecutorService threadService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        threadService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    j++;
                    System.out.println(Thread.currentThread().getName() + "===>" + j);
                }
            }
        });
        threadService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    j++;
                    System.out.println(Thread.currentThread().getName() + "===>" + j);
                }
            }
        });
        //释放资源
        threadService.shutdown();
        return j;

    }

    @GetMapping("/study1")
    @ResponseBody
    public String test1() {
        String test = sun.test();
        return test;
    }

}


