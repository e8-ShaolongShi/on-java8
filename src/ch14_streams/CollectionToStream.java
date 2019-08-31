package ch14_streams;

import java.util.*;

/**
 * 演示 容器转换成流
 *
 * @Author 时少龙
 * @Date 2019-08-10 11:05
 * @Version 1.0
 */
public class CollectionToStream {
    public static void main(String[] args) {
        // list 转成流  将List中的每个Bubble对象中的i 相加
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(bubbles.stream()
                .mapToInt(b -> b.i).sum());
        List<Bubble> bubbles1 = Arrays.asList(new Bubble(4), new Bubble(5), new Bubble(6));
        System.out.println(bubbles1.stream()
                .mapToInt(b -> b.i)
                .sum());

        // set -> 流
        HashSet<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + " ")
                .forEach(System.out::println);

        // map -> 流  对map进行遍历 打印所有的key value
        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ":"  + e.getValue())
                .forEach(System.out::println);
    }
}
