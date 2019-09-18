package ch14_streams.create;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 流的构造器模式
 *
 * @Author 时少龙
 * @Date 2019-08-10 17:02
 * @Version 1.0
 */
public class FileToWordsBuilder {

    // 底层调用的StringJoiner
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1) // 跳过开头注释行
                .forEach(line -> {
                    for (String word: line.split("[ ,?.]+")) {// 取出一行中每个自单词
                        builder.add(word);
                    }
                });
    }

    public Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        new FileToWordsBuilder(new File("src/ch14_streams/create/Cheese.dat").getAbsoluteFile().toString())
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::println);
    }

}
