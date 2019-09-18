package ch14_streams.operator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Stream;

/**
 * map 流操作map 将一个方法 应用到流元素上
 * 方法 输入流元素 输出还是流元素
 *
 * @Author 时少龙
 * @Date 2019-08-31 15:36
 * @Version 1.0
 */
public class FunctionMap {

    /**
     * 测试数据
     */
    static String[] elements = {"12", "", "23", "45"};

    /**
     * 将数组元素以流的形式返回
     *
     * @return
     */
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    /**
     * 测试： map 将方法应用到流上
     *
     * @param descr
     * @param func
     */
    static void test(String descr, Function<String, String> func) {
        System.out.println("--------(" + descr + ")--------");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // 给每个元素添加括号
        test("add brackets", s -> "[" + s + "]");
        // 将每个元素转成数字类型 并且=1
        test("Increment", s -> {
            try {
                return String.valueOf(Integer.parseInt(s) + 1);
            } catch (NumberFormatException e) {
                return s;
            }
        });
        // 将每一个元素中 字符2 换成9
        test("Replace", s -> s.replace("2", "9"));
        // 对每一个元素进行判断，将长度大于0的最后一个元素取出，不大于0的 原样返回
        test("Take last digit", s -> s.length() > 0 ? String.valueOf(s.charAt(s.length() - 1)) : s);
    }
}
