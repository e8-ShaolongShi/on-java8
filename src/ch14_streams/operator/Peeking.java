package ch14_streams.operator;

import ch14_streams.create.FileToWordsBuilder;

import java.io.File;
import java.io.IOException;

/**
 * peek(Consumer)   查看流元素
 *
 * @Author 时少龙
 * @Date 2019-08-31 10:31
 * @Version 1.0
 */
public class Peeking {
    public static void main(String[] args) throws IOException {
        /*
        * 查看，大写后查看 ，小写后查看
        * */
        new FileToWordsBuilder(new File("src/ch14_streams/create/Cheese.dat").getAbsoluteFile().toString())
                .stream()
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map( w -> w.toUpperCase() + " " )
                .peek(System.out::print)
                .map(w -> w.toLowerCase())
                .forEach(System.out::println);
    }
}
