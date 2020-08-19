package ch24_concurrent.terminal;

import onjava.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author shishaolong
 * @datatime 2020/8/18 9:01
 */
public class QuittingTasks {
    public static final int COUNT = 159;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(1, COUNT).mapToObj(QuittableTask::new).peek(qt-> es.execute(qt)).collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}
