package ch13_functional.closure;

import java.util.function.IntSupplier;

/**
 * 闭包演示 闭包：函数访问作用域以外的变量  在java中闭包的表现形式就是匿名内部类
 *
 * @Author 时少龙
 * @Date 2019-08-03 14:02
 * @Version 1.0
 */
public class Closure2 {

    /**
     * 演示 lamda表达式引用两个局部变量。
     * @param x
     * @return
     */
    static IntSupplier produce(int x) {
        int i = 0;
        return () -> i + x;
    }

    public static void main(String[] args) {
        IntSupplier result = produce(4);
        int asInt = result.getAsInt();// 这句执行时 ,x、i 怎么引用
        System.out.println(asInt); //4
        System.out.println(result.getAsInt()); //5
        System.out.println(result.getAsInt()); //6
    }
}
