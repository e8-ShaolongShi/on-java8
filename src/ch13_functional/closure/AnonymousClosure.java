package ch13_functional.closure;

import java.util.function.IntSupplier;

/**
 * 匿名内部类闭包演示 闭包：函数访问作用域以外的变量  在java中闭包的表现形式就是匿名内部类
 * <p>
 * 实际上只要有内部类，就会有闭包（Java 8 只是简化了闭包操作）。
 * 在 Java 8 之前，变量 x 和 i 必须被明确声明为 final。
 * 在 Java 8 中，内部类的规则放宽，包括等同 final 效果。
 *
 * @Author 时少龙
 * @Date 2019-08-03 14:02
 * @Version 1.0
 */
public class AnonymousClosure {

    static int i;

    static IntSupplier makeFunc(int x){
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i++;  // 引用了两个外部变量
            }
        };
    }

    public static void main(String[] args) {
        IntSupplier result = makeFunc(4);
        int asInt = result.getAsInt();// 这句执行时 ,x、i 怎么引用
        System.out.println(asInt); //4
        System.out.println(result.getAsInt()); //5
        System.out.println(result.getAsInt()); //6
    }
}
