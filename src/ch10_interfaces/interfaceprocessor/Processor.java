package ch10_interfaces.interfaceprocessor;

/**
 * 处理器接口
 *
 * @author shishaolong
 * @datatime 2020/4/2 9:23
 */
public interface Processor {

    default String name() {
        return getClass().getSimpleName();
    }

    Object process(Object o);
}
