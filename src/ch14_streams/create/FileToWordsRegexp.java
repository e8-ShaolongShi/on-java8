package ch14_streams.create;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用正则 将文本文件中的 单词提取出来转成流
 *
 * @Author 时少龙
 * @Date 2019-08-10 17:52
 * @Version 1.0
 */
public class FileToWordsRegexp {

    private String all;

    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath))
                .skip(1)  // 跳过开头的注释
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern
                .compile("[ ,.?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        FileToWordsRegexp fw = new FileToWordsRegexp(new File("src/ch14_streams/Cheese.dat").getAbsoluteFile().toString());
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::println);

        System.out.println("+++++++++++++++  打印两个  +++++++++++++++");

        fw.stream()
                .limit(2)
                .map(w -> w + ", ")
                .forEach(System.out::println);
    }
}
