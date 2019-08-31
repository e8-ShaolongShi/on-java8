package ch14_streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream.Generator   Consumer实现类的生成器
 *
 * @Author 时少龙
 * @Date 2019-08-10 15:28
 * @Version 1.0
 */
public class Generator implements Supplier<String> {

    private Random rand = new Random(47);
    private char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return letters[rand.nextInt(letters.length)] + "";
    }

    public static void main(String[] args) {
        // 返回随机生成的字符前30个组成一个单词
        String word = Stream.generate(new Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);

        // 返回包含相同对象的流。
        Stream.generate(() -> "时少龙")
                .limit(3)
                .forEach(System.out::println);
    }
}
