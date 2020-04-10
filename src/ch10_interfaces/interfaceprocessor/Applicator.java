package ch10_interfaces.interfaceprocessor;

/**
 * @author shishaolong
 * @datatime 2020/4/2 9:30
 */
public class Applicator {

    public static void apply(Processor processor, Object o) {
        System.out.println(processor.name());
        System.out.println(processor.process(o));
    }
}
