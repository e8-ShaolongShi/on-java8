package ch14_streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 演示： 使用 Random 为 任意对象集合创建Supplier
 * <p>
 * 目标： 读出文件中所有的单词，随机返回
 *
 * @Author 时少龙
 * @Date 2019-08-10 14:19
 * @Version 1.0
 */
public class RandomWords implements Supplier<String> {

    /**
     * 存放所有的单词
     */
    private List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 跳过第一行
        final String split = "[ .?,]+";
        // 遍历获取每一行中的每一个单词，添加到list中
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split(split)) {
                words.add(word);
            }
        }
    }

    @Override
    public String get() {
        // 随机返回一个
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                Stream.generate(
                        new RandomWords(
                                new File("src/ch14_streams/Cheese.dat").getAbsoluteFile().toString()))
                        .limit(10)
                        .collect(Collectors.joining(" "))
        );
    }
}
