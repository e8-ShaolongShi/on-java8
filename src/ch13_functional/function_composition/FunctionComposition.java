package ch13_functional.function_composition;

import java.util.function.Function;

/**
 * 函数组合例子：将一个多个函数组合成一个新函数
 * <p>
 * 内容：对一个由大写字母组成的字符串 先截取其中一部分，再将所有的"A"字母替换成"_" ，最后再转换成小写字母。
 *
 * 应用：能制作流水线  pipline （eg：初步猜测有gradle的task执行任务有能关联起来，还有可能与jenkins 有联系）
 *
 * @Author 时少龙
 * @Date 2019-08-03 16:10
 * @Version 1.0
 */
public class FunctionComposition {

    static Function<String, String>
            f1 = s -> s.replace("A", "_"),  // 替换
            f2 = s -> s.substring(4),  // 截取子串
            f3 = s -> s.toLowerCase(), // 转化成小写
            f4 = f1.compose(f2).andThen(f3);   // 组合函数，它内部不需要写语句的   只起组装作用，不写函数内容
    public static void main(String[] args) {
        String result = f4.apply("GO AFTER ALL AMBULANCES");
        System.out.println(result);
    }
}
