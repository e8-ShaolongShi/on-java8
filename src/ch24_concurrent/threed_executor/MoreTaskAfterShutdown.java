package ch24_concurrent.threed_executor;

import ch24_concurrent.NapTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 线程池，截止提交后继续提交抛异常
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:06
 */
public class MoreTaskAfterShutdown {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new NapTask(1));
        exec.shutdown();
        try {
            exec.execute(new NapTask(99));
        } catch (RejectedExecutionException e) {
            System.out.println(e);
        }
    }
}
