package ch24_concurrent.threed_executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService支持Callable接口的API是：1.invokeAll， submit, invokeAny
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:55
 */
public class Futures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec.submit(new CountingTask(99));
        // *** 当程序在尚未完成的future上调用get()时，调用会阻塞（等待）知道结果可用。
        System.out.println(f.get());
        exec.shutdown();
    }

}
