package com.example.myapplication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutorService {

    private static void test1() {
        //1.使用工厂类获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService pool = new ThreadPoolExecutor(1, 2,
                0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        ThreadPoolExecutor newpool = new ThreadPoolExecutor(2, 4,
                1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("创建线程:" + r.hashCode());
                //线程名称
                Thread th = new Thread(r, "threadPool-" + r.hashCode());
                return th;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());
        newpool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("业务流程");
                throw new NullPointerException();
            }
        });
//        newpool.submit()
//        pool.shutdown();

    }

}
