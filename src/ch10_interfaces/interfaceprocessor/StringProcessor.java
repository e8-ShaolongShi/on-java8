package ch10_interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * @author shishaolong
 * @datatime 2020/4/2 9:33
 */
public interface StringProcessor extends Processor {
    @Override
    Object process(Object o);

    String s = "If she weighs the same as a duck, she's made of wood";

    static void main(String[] args) {
        Applicator.apply(new Upcase(), s);
        Applicator.apply(new Downcase(), s);
        Applicator.apply(new Splitter(), s);
    }
}

class Upcase implements StringProcessor {
    // 返回协变类型
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}