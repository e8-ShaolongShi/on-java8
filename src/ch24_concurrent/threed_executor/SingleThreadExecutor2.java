package ch24_concurrent.threed_executor;

import ch24_concurrent.NapTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 创建单例线程池，例子2
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:03
 */
public class SingleThreadExecutor2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).mapToObj(NapTask::new).forEach(exec::execute);
        exec.shutdown();
    }
}
