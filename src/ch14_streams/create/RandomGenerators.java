package ch14_streams.create;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 演示： 使用流产生随机数
 *
 * @Author 时少龙
 * @Date 2019-08-10 13:23
 * @Version 1.0
 */
public class RandomGenerators {

    public static <T> void show(Stream<T> stream){
        // 显示 流中的前四个元素，并将这四个元素打印出来
        stream
                .limit(6)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        System.out.println("--------- 1.使用默认，加限制 -----------");
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());
        System.out.println("--------- 2.限制流大小 (限制数量)-----------");
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());
        System.out.println("--------- 3.限制上下界 -----------");
        show(rand.ints(10,20).boxed());
        show(rand.longs(50,100).boxed());
        show(rand.doubles(20,30).boxed());
        System.out.println("--------- 4.限制上下界 和数量 -----------");
        show(rand.ints(4,3,9).boxed());
        // 5个 范围在 12-25
        show(rand.longs(4,12,25).boxed());
        show(rand.doubles(4,11.5,12.2).boxed());
    }
}
