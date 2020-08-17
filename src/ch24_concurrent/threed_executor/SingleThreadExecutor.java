package ch24_concurrent.threed_executor;

import ch24_concurrent.NapTask;
import onjava.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 线程池：创建单例
 *
 * @author shishaolong
 * @datatime 2020/8/17 14:48
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        // create Thread pool
        ExecutorService exec = Executors.newSingleThreadExecutor();
        // 创建10 运行任务，添加到线程池中
        IntStream.range(0, 10).mapToObj(NapTask::new).forEach(exec::execute);
        System.out.println("All task submitted");
        // 提交所有的线程任务并执行
        exec.shutdown();
        // 当任务结束后，打印
        while (!exec.isTerminated()){
            System.out.println(Thread.currentThread().getName()+ " awaiting termination");
            new Nap(0.1);
        }
    }
}
