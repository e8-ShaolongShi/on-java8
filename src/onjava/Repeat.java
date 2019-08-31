package onjava;

import java.util.function.Consumer;

import static java.util.stream.IntStream.range;

/**
 * on java 工具类 对IntStream  range方法 增强 提供重复
 * 替代 for 循环
 *
 * @Author 时少龙
 * @Date 2019-08-10 15:04
 * @Version 1.0
 */
public class Repeat {

    /**
     * 重复执行action 方法 n次
     *
     * @param n      循环次数
     * @param action 需要执行的方法
     */
    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());
    }

    /**
     * 重复执行action 方法 n次， 并将当前循环次数以参数的形式传给action
     *
     * @param n      循环此处
     * @param action
     */
    public static void repeat(int n, Consumer<Integer> action) {
        range(0, n).forEach(i -> action.accept(i));
    }
}
