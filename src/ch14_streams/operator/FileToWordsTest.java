package ch14_streams.operator;

/**
 * 将文件转成 单词
 *
 * @Author 时少龙
 * @Date 2019-08-31 17:06
 * @Version 1.0
 */
public class FileToWordsTest {

    public static void main(String[] args) throws Exception {
        FileToWords.stream("Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        FileToWords.stream("Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
