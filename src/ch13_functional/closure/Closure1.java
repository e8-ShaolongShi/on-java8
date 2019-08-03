package ch13_functional.closure;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 闭包演示 闭包：函数访问作用域以外的变量  在java中闭包的表现形式就是匿名内部类
 *
 * @Author 时少龙
 * @Date 2019-08-03 14:02
 * @Version 1.0
 */
public class Closure1 {

    static int i;

    /**
     * 分析：
     *     正常逻辑：
     *      IntSupplier result = Closure.produce();调用produce后，produce出栈、x消失。 x引用无使用回收
     *      调用 result.apply() 时，岂不是没有了x,i   ===》 出现了问题，  能解决此问题的语言称为  支持闭包
     * @param x
     * @return
     */
    static IntSupplier produce(int x){
        return () -> x + i++; // 闭包方法引用了两个外部变量
    }

    public static void main(String[] args) {
        IntSupplier result = produce(4);
        int asInt = result.getAsInt();// 这句执行时 ,x、i 怎么引用
        System.out.println(asInt); //4
        System.out.println(result.getAsInt()); //5
        System.out.println(result.getAsInt()); //6
    }
}
