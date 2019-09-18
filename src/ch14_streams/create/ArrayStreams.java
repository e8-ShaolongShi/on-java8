package ch14_streams.create;

import java.util.Arrays;

/**
 * 演示： 数组工具类产生各种基本类型数组的流
 *
 * @Author 时少龙
 * @Date 2019-08-10 17:31
 * @Version 1.0
 */
public class ArrayStreams {

    public static void main(String[] args) {
        // 产生double类型数组流
        Arrays.stream(new double[]{3.1415926, 2.718, 1.618})
                .forEach(n -> System.out.format("%f ", n));
        System.out.println();

        // 产生int 类型数组流
        Arrays.stream(new int[]{1, 5, 6, 9, 4})
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // 产生 long类型数组流
        Arrays.stream(new long[]{11, 22, 44, 66})
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // 选择数组的一个子域  这个限制是根据 角标
        Arrays.stream(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 3, 6)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
    }
}
