package ch24_concurrent.threed_executor;

import ch24_concurrent.NapTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 缓存线程池
 * @author shishaolong
 * @datatime 2020/8/17 15:10
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        // 1.创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 2.给线程池中添加任务
        IntStream.range(0, 10).mapToObj(NapTask::new).forEach(exec::execute);
        // 3.提交所有的线程任务
        exec.shutdown();
    }
}
