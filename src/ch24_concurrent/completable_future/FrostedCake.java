package ch24_concurrent.completable_future;

import onjava.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * 糖：面包加糖处理
 *
 * @author shishaolong
 * @datatime 2020/8/20 13:42
 */
final class Frosting {

    private Frosting() {
    }

    /**
     * 取到糖
     *
     * @return
     */
    static CompletableFuture<Frosting> make() {
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}

public class FrostedCake {
    public FrostedCake(Baked baked, Frosting frosting) {
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public static void main(String[] args) {
        Baked.batch().forEach(
                bake -> bake.thenCombineAsync(Frosting.make(),
                        (cake, frosting) -> new FrostedCake(cake, frosting))
                        .thenAcceptAsync(System.out::println)
                        .join()
        );
    }
}
