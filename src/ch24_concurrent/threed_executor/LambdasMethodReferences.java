package ch24_concurrent.threed_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NotRunnable{
    public void go(){
        System.out.println("NotRunnable");
    }
}

class NotCallable{
    public Integer get(){
        System.out.println("NotCallable");
        return 1;
    }
}

/**
 * java8方法引用与lambda和并发的结合使用
 * 使用java8 方法引用和lambda表达式 调用非Runnable和Callable接口方法
 *
 * @author shishaolong
 * @datatime 2020/8/17 16:20
 */
public class LambdasMethodReferences {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(()-> System.out.println("Lambda1"));
        exec.submit(new NotRunnable()::go);
        exec.submit(() -> {
            System.out.println("Lambda2");
            return 1;
        });
        exec.submit(new NotCallable()::get);
        exec.shutdown();
    }

}
