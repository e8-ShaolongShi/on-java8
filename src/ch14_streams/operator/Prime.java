package ch14_streams.operator;

import java.util.stream.LongStream;

import static java.util.stream.LongStream.*;

/**
 * 操作流 filter( 判断函数 ) 方法
 *
 * @Author 时少龙
 * @Date 2019-08-31 15:01
 * @Version 1.0
 */
public class Prime {

    /**
     * 判断一个数是否为质数
     *
     * @param n
     * @return
     */
    public static Boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                // 对一个流元素做判断  判断所有的元素均不能匹配为真  全部有余数，算匹配
                // 所有的都不能被整除      所有的都不能== noneMatch   整除== i -> n%i == 0
                .noneMatch(i -> n % i == 0);
    }

    public LongStream numbers() {
        // 迭代 从2开始 步进为1 迭代生成。
        return iterate(2, i -> i + 1)
                // 过滤 留下是质数的
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(100)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }

    private static void test() {
        // 产生一个 从2 到 根号下25的序列  [包含边界25]
        rangeClosed(2, (long) Math.sqrt(25)).forEach(System.out::print);
    }

}
