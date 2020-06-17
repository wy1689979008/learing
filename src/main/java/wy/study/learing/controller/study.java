package wy.study.learing.controller;

import com.sun.jmx.snmp.tasks.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import wy.study.learing.bean.AutoGetField;
import wy.study.learing.bean.AutoValue;
import wy.study.learing.service.RedisStudy;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.E;


@RestController
@RequestMapping(value = "/wy")
public class study {
    @Autowired
    private RedisStudy redisStudy;
    public  String a="1";
    public  int i=0;
    @AutoGetField(description = "wy",length = 15)
    private String name;
    @AutoValue(value = "${remain.time}")
    private String valu;


    static int j=0;


    @GetMapping("/study")
    @ResponseBody
    public int test() {
        BlockingQueue<Runnable> workQueue=null;
        ExecutorService threadService=  new ThreadPoolExecutor(5,10,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        threadService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                    j++ ;
                    System.out.println(Thread.currentThread().getName()+"===>"+j);
                }
            }
        });
        threadService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                   j++ ;
                   System.out.println(Thread.currentThread().getName()+"===>"+j);
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
        redisStudy.test1();
        return a;
    }

}


