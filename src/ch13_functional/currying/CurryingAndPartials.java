package ch13_functional.currying;

import java.util.function.Function;

/**
 * 函数柯里化 ： 将一个多参数的函数转化成一系列单参数函数
 * <p>
 * 作用： 比如一个函数有三个参数，其中两个基本固定不变，可以使用柯里化，将这两个参数固定了，只传变的参数。
 *
 * @Author 时少龙
 * @Date 2019-08-03 17:48
 * @Version 1.0
 */
public class CurryingAndPartials {


    // 未柯里化的函数
    static String unCuryies(String s1, String s2) {
        return s1 + s2;
    }

    public static void main(String[] args) {
        // 柯里化 第一个为参数  第二个为函数
        Function<String, Function<String, String>> sum = a -> b -> a + b;

        System.out.println(unCuryies("hi  ", "long"));
        Function<String, String> hi = sum.apply("hi   ");  // 这次才拿到 b > a + b  此时a其实已存在了
//        System.out.println(hi);
        System.out.println(hi.apply("long"));

        Function<String, String> hello__ = sum.apply("hello  ");
        System.out.println(hello__.apply("小霞"));
        System.out.println(hello__.apply("建军"));
    }

}
