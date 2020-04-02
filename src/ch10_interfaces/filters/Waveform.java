package ch10_interfaces.filters;

/**
 * 需要处理的对象
 *
 * @author shishaolong
 * @datatime 2020/4/2 9:05
 */
public class Waveform {
    private static Long counter; // 会默认初始化成 0
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
