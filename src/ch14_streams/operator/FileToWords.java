package ch14_streams.operator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * flatMap 应用 文件流、正则流处理  综合应用
 * 随机取出一个文本中的单词  整体思路：读取文件，将每个单词编程流元素
 *
 * @Author 时少龙
 * @Date 2019-08-31 16:50
 * @Version 1.0
 */
public class FileToWords {
    public static Stream<String> stream(String filePath) throws Exception {
        /*
         * 思路：
         * 1.读取文件 行 -> 流元素
         * 2.操作流  行 -> 多个单词  以非单词字符串截取
         * 3.转换 单词 -> 流元素
         *
         * [单词字符 \w => 单词字符串 \w+ ]  [非单词 \W => 费单词字符串 \W+]
         * 正则：以非单词字符串截取
         * */
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
