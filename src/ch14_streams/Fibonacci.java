package ch14_streams;

import java.util.stream.Stream;

/**
 * Stream.iterate(种子，方法)： 将第一参数传给方法，方法的返回值会再次作为参数，传给函数，进行迭代
 * <p>
 * 使用Steam.iterate() ：生成斐波那契数列
 *
 * @Author 时少龙
 * @Date 2019-08-10 15:41
 * @Version 1.0
 */
public class Fibonacci {

    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = i + x;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
//                .skip(20) // 丢掉前20个
                .limit(10)  // 然后取出前10个
                .forEach(System.out::println);
    }
}
