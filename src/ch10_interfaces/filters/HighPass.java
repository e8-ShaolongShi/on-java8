package ch10_interfaces.filters;

/**
 * @author shishaolong
 * @datatime 2020/4/2 9:09
 */
public class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
