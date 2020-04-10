package ch10_interfaces.adapters;

import java.util.Random;

/**
 * 产生随机数的接口  让实现此接口的类能够作用到Scanner上
 *
 * @author shishaolong
 * @datatime 2020/4/10 14:17
 */
public interface RandomDoubles {

    Random rand = new Random(47);

    default double next() {
        return rand.nextDouble();
    }

    static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles() {
        };
        for (int i = 0; i < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
