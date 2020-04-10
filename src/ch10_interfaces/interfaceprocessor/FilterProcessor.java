package ch10_interfaces.interfaceprocessor;

import ch10_interfaces.filters.*;

class FilterAdapter implements Processor {
    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object o) {
        return filter.process((Waveform) o);
    }
}

/**
 * @author shishaolong
 * @datatime 2020/4/10 10:18
 */
public class FilterProcessor {

    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), waveform);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), waveform);
        Applicator.apply(new FilterAdapter(new BandPass(3.0, 4.0)), waveform);
    }
}
