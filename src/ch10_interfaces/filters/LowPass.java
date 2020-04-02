package ch10_interfaces.filters;

/**
 * @author shishaolong
 * @datatime 2020/4/2 9:08
 */
public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        // 各种处理
        return input;
    }
}
