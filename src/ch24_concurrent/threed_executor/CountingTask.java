package ch24_concurrent.threed_executor;

import java.util.concurrent.Callable;

/**
 * Callable 接口类似于Runnable接口，只是Callable有返回值，而Runnable接口没有返回值
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:29
 */
public class CountingTask implements Callable<Integer> {

    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
        return val;
    }

}
