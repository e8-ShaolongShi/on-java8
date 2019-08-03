package ch13_functional.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 闭包演示 闭包：函数访问作用域以外的变量  在java中闭包的表现形式就是匿名内部类
 *
 * @Author 时少龙
 * @Date 2019-08-03 14:02
 * @Version 1.0
 */
public class Closure5 {

    /**
     * 演示 lambda表达式引用局部变量，局部变量为容器 修改容器中的值是否允许
     * @return
     */
    Supplier<List> makeFun() {
        List<Integer> list = new ArrayList<>();
//        list = new ArrayList<>(); // lambda 表达式引用时报错。
        list.add(1);
        return () -> list;
    }

    public static void main(String[] args) {
        Closure5 closure5 = new Closure5();
        List l1 = closure5.makeFun().get(),
                l2 = closure5.makeFun().get();

        System.out.println(l1);
        System.out.println(l2);

        l1.add(45);
        l2.add(96);

        System.out.println(l1);
        System.out.println(l2);
    }
}
