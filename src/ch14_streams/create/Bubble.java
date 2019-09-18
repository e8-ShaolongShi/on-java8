package ch14_streams.create;

/**
 * 假定为一种数据结构
 *
 * @Author 时少龙
 * @Date 2019-08-10 11:07
 * @Version 1.0
 */
public class Bubble {
    public int i;

    public Bubble(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")";
    }

    private static int count = 0;

    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}
