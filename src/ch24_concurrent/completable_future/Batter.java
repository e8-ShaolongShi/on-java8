package ch24_concurrent.completable_future;

import onjava.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * 制作蛋糕的过程
 *
 * @author shishaolong
 * @datatime 2020/8/20 13:20
 */
public class Batter {
    static class Eggs {
    }

    static class Milk {
    }

    static class Sugar {
    }

    static class Flour {
    }

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture.completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        CompletableFuture.allOf(eggs, milk, sugar, flour).join();
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Batter());
    }
}
