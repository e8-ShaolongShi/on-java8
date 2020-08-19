package ch24_concurrent.completable_future;

import java.util.concurrent.CompletableFuture;

import static ch24_concurrent.completable_future.CompletableUtilities.showr;
import static ch24_concurrent.completable_future.CompletableUtilities.voidr;

/*
then 系列方法总结：
AcceptAsync(): 接受了一个Consumer，因此不会产生结果
thenApplyAsync(): 接受了一个Function,并产生一个结果（该结果的类型可以不同于其输入类型
thenComposeAsync()与thenApplyAsync()非常相似，唯一区别在于其Function必须产生已经包装在CompletableFuture中的结果

 */

/**
 * @author shishaolong
 * @datatime 2020/8/19 9:47
 */
public class CompletableOperations {

    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(Integer.valueOf(i));
    }

    public static void main(String[] args) {
        showr(cfi(1)); // Best test

        voidr(cfi(2).runAsync(() -> System.out.println("runAsync")));

        voidr(cfi(3).thenRunAsync(() -> System.out.println("thenRunAsync")));

        voidr(CompletableFuture.runAsync(() -> System.out.println("runAsync is static")));

        showr(CompletableFuture.supplyAsync(() -> 99));

        voidr(cfi(4).thenAcceptAsync(i -> System.out.println("thenAcceptAsync: " + i)));

        showr(cfi(5).thenApplyAsync(i -> i + 42));

        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

        CompletableFuture<Integer> c = cfi(7);
        // **** 什么意思
        c.obtrudeValue(111);
        showr(c);

        showr(cfi(8).toCompletableFuture());
        c = new CompletableFuture<>();
        c.complete(9);
        showr(c);

        c = new CompletableFuture<>();
        c.cancel(true);
        System.out.println("Cancelled:" + c.isCancelled());
        System.out.println("Completed exceptionally: " + c.isCompletedExceptionally());
        System.out.println("done: " + c.isDone());
        System.out.println(c);

        c = new CompletableFuture<>();
        System.out.println(c.getNow(777));

        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42)
                .thenApplyAsync(i -> i * 12);
        System.out.println("dependents: " + c.getNumberOfDependents());
        c.thenApplyAsync(i -> i / 2);
        System.out.println("dependents: " + c.getNumberOfDependents());
    }
}
