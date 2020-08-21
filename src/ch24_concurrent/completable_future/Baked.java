package ch24_concurrent.completable_future;

import onjava.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author shishaolong
 * @datatime 2020/8/20 13:27
 */
public class Baked {

    static class Pan {
    }

    static Pan pan(Batter b) {
        new Nap(0.1);
        return new Pan();
    }

    static Baked heat(Pan p) {
        new Nap(0.1);
        return new Baked();
    }

    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb.thenApplyAsync(Baked::pan).thenApplyAsync(Baked::heat);
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture<Batter> batte = Batter.mix();
        return Stream.of(
                bake(batte),
                bake(batte),
                bake(batte),
                bake(batte)
        );
    }
}
