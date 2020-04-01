package ch10_interfaces.instrument;


/**
 * 乐器支持表演
 */
interface Instrument {
    // 有哪些乐器
    enum Node {
        MIDDLE_C
    }

    /**
     * 演奏
     *
     * @param n
     */
    default void play(Node n) {
        System.out.println(this + "play()," + n);
    }

    /**
     * 判断是哪个乐器
     */
    default void judge() {
        System.out.println("Adjusting " + this);
    }
}

/**
 * 乐器继承体系  乐器体系
 */
class Wind implements Instrument {
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument {
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

/**
 * 演奏乐器：乐器可扩展，  将所有乐器全部演奏一下
 * 演奏：开启 这是一个功能 所有的乐器都支持表演这种功能
 *
 * @author shishaolong
 * @datatime 2020/4/1 10:42
 */

public class Music5 {

    /**
     * 开启单个乐器
     */
    static void turn(Instrument in) {
        in.play(Instrument.Node.MIDDLE_C);
    }

    /**
     * 开启所有乐器
     */
    static void tuneAll(Instrument[] ins) {
        for (Instrument in : ins) {
            turn(in);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
