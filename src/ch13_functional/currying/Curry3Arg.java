package ch13_functional.currying;

import java.util.function.Function;

/**
 * 函数柯里化：  3参数柯里化
 *
 * 可不可以理解为： 与一种特殊重载相似  一个参数的调用两个参数的函数，两个参数的函数调用三个参数的，对外只公开一个参数的那个？？？？
 *
 * 能组合出多种新式 可生成多种形式的函数
 *
 * @Author 时少龙
 * @Date 2019-08-03 18:01
 * @Version 1.0
 */
public class Curry3Arg {

    public static void main(String[] args) {

        Function<String,
                Function<String,
                        Function<String, String>>> sum = a -> b -> c -> a + b + c;  // a 和 b 是固定的，  变化的是第3个

        // 固定第一个参数 a
        Function<String, Function<String, String>> hello_ = sum.apply("hello ");
        Function<String, Function<String, String>> nh = sum.apply("你好  ");
        // 固定第二个参数 b
        Function<String, String> small_ = hello_.apply("small ");
        Function<String, String> xi = nh.apply("小");

        // 传入多个变化的参数 c
        System.out.println(small_.apply("shaolong"));
        System.out.println(xi.apply("时建军"));

    }
}
