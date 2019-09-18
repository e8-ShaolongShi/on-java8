package ch14_streams.create;

import static java.util.stream.IntStream.range;

/**
 * IntStream 提供range方法 产生一个数列
 * 演示： 10-20 递增相加
 *
 * @Author 时少龙
 * @Date 2019-08-10 14:58
 * @Version 1.0
 */
public class Ranges {

    public static void main(String[] args) {
        // 传统方法
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);

        // for-in 循环
        result = 0;
        for (int i : range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);

        // 使用流
        System.out.println(range(10, 20).sum());

    }
}
