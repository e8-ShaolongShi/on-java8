package ch14_streams;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 演示Arrays.stream(数组)
 *
 * @Author 时少龙
 * @Date 2019-08-10 17:19
 * @Version 1.0
 */
public class Machine2 {

    public static void main(String[] args) {
        Arrays.stream(new Consumer[]{
                i -> System.out.println(i),
                i -> System.out.println(i),
                i -> System.out.println(i),
                i -> System.out.println(i)
        }).forEach(action -> action.accept(5));
    }
}
