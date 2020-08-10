package ch24_concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * 并行流测试： 计数
 *
 * @author shishaolong
 * @datatime 2020/8/10 9:59
 */
public class Summing {

    /**
     * 测试方法
     *
     * @param id
     * @param checkValue
     * @param operation
     */
    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.println(id + ": ");
        Instant start = Instant.now();
        long result = operation.getAsLong();
        if (result == checkValue)
            System.out.println("Duration: " + Duration.between(start, Instant.now()).getNano());
        else
            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
    }

    public static final int SZ = 1_0000_0000;
    public static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("Sum Streaam", CHECK, () -> LongStream.rangeClosed(0, SZ).sum());
        timeTest("Sum Stream Parallel", CHECK, ()->LongStream.rangeClosed(0, SZ).parallel().sum());
        timeTest("Sum Iterated", CHECK, () -> LongStream.iterate(0, i-> i+1).limit(SZ+1).sum());
    }
}
