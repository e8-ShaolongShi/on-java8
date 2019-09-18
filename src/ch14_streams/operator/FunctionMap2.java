package ch14_streams.operator;
// streams/FunctionMap2.java
// Different input and output types （不同的输入输出类型

import java.util.stream.Stream;

class Numbered {
    final int n;

    Numbered(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numbered(" + n + ")";
    }
}

/**
 * map 演示2 ： map 应用的方法  输入类型和输出类型不一致
 *
 * @Author 时少龙
 * @Date 2019-08-31 15:54
 * @Version 1.0
 */
public class FunctionMap2 {

    public static void main(String[] args) {
        Stream.of(1, 5, 7, 9, 11, 13)
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}
