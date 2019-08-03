package ch13_functional.function_composition;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 函数组合示例
 * <p>
 * 内容;定义多个判断条件， 将各个条件进行组合，以此作为筛选标准，对多个字符串进行筛选，最后打印筛选结果
 *
 * @Author 时少龙
 * @Date 2019-08-03 17:08
 * @Version 1.0
 */
public class PredicateComposition {

    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);  // 对多个条件进行组合   组合成一个新函数。   // 不包含"bar" 且长度小于5 或 包含foo

    public static void main(String[] args) {
        String[] ss = {"bar", "foobar", "foobaz", "fongopuckey"};
        Stream.of(ss)
                .filter(p4)
                .forEach(System.out::println);
    }
}
