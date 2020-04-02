package ch10_interfaces.filters;

/**
 * 波处理器 方法签名。固定接口。 不同的处理方法使用继承来扩展
 *
 * @author shishaolong
 * @datatime 2020/4/2 9:07
 */
public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
