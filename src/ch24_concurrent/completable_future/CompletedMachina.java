package ch24_concurrent.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author shishaolong
 * @datatime 2020/8/19 8:40
 */
public class CompletedMachina {

    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        try {
            Machina m = cf.get();
        } catch (InterruptedException |ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
