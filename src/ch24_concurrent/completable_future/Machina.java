package ch24_concurrent.completable_future;

import onjava.Nap;

/**
 * 机器
 *
 * @author shishaolong
 * @datatime 2020/8/18 9:49
 */
public class Machina {

    // 定义一个计步器 每调用一次step 向前推进一个步骤
    public enum State {
        START, ONE, TWO, THREE, END;

        State step() {
            if (equals(END))
                return END;
            return values()[ordinal() + 1];
        }
    }

    // 定义枚举实例
    private State state = State.START;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    /**
     * 定义工作方法，如果工作流程没有进行到最后一步， 向前推进一步
     *
     * @param m
     * @return
     */
    public static Machina work(Machina m) {
        if (!State.END.equals(m.state)) {
            new Nap(0.1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machina" + id + ": " + (state.equals(State.END) ? "complete" : state);
    }
}
