package ch24_concurrent.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Completable 工具
 *
 * @author shishaolong
 * @datatime 2020/8/19 9:40
 */
public class CompletableUtilities {

    // Get and show value stored in a CF
    public static void showr(CompletableFuture<?> c) {
        try {
            System.out.println(c.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    // For CF operations that have no value
    public static void voidr(CompletableFuture<Void> c) {
        try {
            c.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
