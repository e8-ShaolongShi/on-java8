package ch10_interfaces;

import java.util.Arrays;

/**
 * 处理器类：策略接口 封装的是变得部分
 */
class Processor {
    public String name() {
        return "this is:" + getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}

/**
 * 具体的策略。变的部分 封装到不同的类中
 */
class UpperProcessor extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowerProcessor extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class SplitProcessor extends Processor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

/**
 * 策略设计模式：应用器
 *
 * @author shishaolong
 * @datatime 2020/4/2 8:45
 */
public class Applicator {

    /**
     * 应用   框架部分。不变的怎么处理   算法：写的是不变的部分
     *
     * @param processor
     * @param str
     */
    public static void apply(Processor processor, String str) {
        System.out.println(processor.name());
        System.out.println(processor.process(str));
    }

    public static void main(String[] args) {
        String str = "Shishaolong is testing";
        apply(new UpperProcessor(), str);
        apply(new LowerProcessor(), str);
        apply(new LowerProcessor(), str);
    }
}
