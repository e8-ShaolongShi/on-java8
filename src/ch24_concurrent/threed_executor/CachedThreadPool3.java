package ch24_concurrent.threed_executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CachedThreadPool3
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:42
 */
public class CachedThreadPool3 {

    /**
     * 从一个future中取值
     *
     * @param f
     * @return
     */
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<CountingTask> tasks = IntStream.range(0, 10).mapToObj(CountingTask::new).collect(Collectors.toList());
        // *** 重点： Callable的调用  future是Java5中引入的机制，允许你提交任务而无需等待它完成。
        List<Future<Integer>> futures = exec.invokeAll(tasks);
        Integer sum = futures.stream().map(CachedThreadPool3::extractResult).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }

}
