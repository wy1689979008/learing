package wy.study.learing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import wy.study.learing.service.RedisStudy;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RedisStudyImpl implements RedisStudy  {
    @Autowired
    private RedisTemplate redisTemplate;
    public int share = 0;
    @Autowired
    private ioz zero;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long addRedis() {
        return AtomincThread() - intThread();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int test1() {
        try {
            share = 1;
            //Thread.sleep(10000);
            jdbcTemplate.execute("INSERT into ams_staff(name) VALUES('sdddddddd')");
            test3();
            int j = 1 / 0;
            //jdbcTemplate.execute("INSERT into ams_staff(id) VALUES(1) ");
        } catch (Exception e) {
            System.out.println(share);
            jdbcTemplate.execute("INSERT into ams_staff(name) VALUES('sssssssssshhsshs')");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return share;
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NEVER)
    public int test3() {
        try {
            share = 1;
            //Thread.sleep(10000);
            jdbcTemplate.execute("INSERT into ams_staff(name) VALUES('sdddd11111')");
            //int j = 1 / 0;

            //jdbcTemplate.execute("INSERT into ams_staff(id) VALUES(1) ");
        } catch (Exception e) {
            System.out.println(share);
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return share;
    }

    @Override
    public int test2() {
        System.out.println(share);
        return share;
    }

    public void add(AtomicInteger a) {
        a.incrementAndGet();
    }

    public static int threadAdd(int a) {
        return a++;
    }

    public static AtomicInteger init = new AtomicInteger(0);

    public long AtomincThread() {
        long start = System.currentTimeMillis();
        Thread[] thread = new Thread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        add(init);
                    }
                }
            });
            thread[i].start();
        }
        for (Thread t : thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(init);
        long end = System.currentTimeMillis();
        System.out.println("安全线程处理时间====》" + (end - start));
        System.out.println("安全线程处理结果====》" + init);
        return (end - start);
    }

    public static int UnSafe = 0;

    public long intThread() {
        long start = System.currentTimeMillis();
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread[] thread = new Thread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        UnSafe = threadAdd(UnSafe);
                    }
                }
            });
            thread[i].start();
        }
        for (Thread t : thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //System.out.println(init);
        long end = System.currentTimeMillis();
        System.out.println("不安全线程处理时间====》" + (end - start));
        System.out.println("不安全线程处理结果====》" + UnSafe);
        return (end - start);
    }


}
