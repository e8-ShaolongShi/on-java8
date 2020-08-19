package onjava;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author shishaolong
 * @datatime 2020/8/19 9:04
 */
public class Timer {
    private long start = System.nanoTime();

    public long duration() {
        return NANOSECONDS.toMicros(System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }
}
