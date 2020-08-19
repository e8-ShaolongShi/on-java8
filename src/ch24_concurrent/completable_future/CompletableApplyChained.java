package ch24_concurrent.completable_future;

import onjava.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * thenApply
 *
 * @author shishaolong
 * @datatime 2020/8/19 8:53
 */
public class CompletableApplyChained {

    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer.duration());
    }
}
