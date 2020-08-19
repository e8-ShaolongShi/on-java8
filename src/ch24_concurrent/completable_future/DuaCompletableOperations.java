package ch24_concurrent.completable_future;

import java.util.concurrent.CompletableFuture;

import static ch24_concurrent.completable_future.CompletableUtilities.showr;
import static ch24_concurrent.completable_future.CompletableUtilities.voidr;

/**
 * @author shishaolong
 * @datatime 2020/8/19 10:35
 */
public class DuaCompletableOperations {

    static CompletableFuture<Workable> cfA, cfB;

    static void init() {
        cfA = Workable.make("A", 0.15);
        cfB = Workable.make("B", 0.10);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("======================");
    }

    static void join(CompletableFuture cf1, CompletableFuture cf2) {
        cf1.join();
        cf2.join();
    }

    public static void main(String[] args) {
        //**************************  run()\ accept() 是终端操作  *****************************
        init();
        voidr(cfA.runAfterEitherAsync(cfB, () -> System.out.println("runAfterEither")));
        join();

        init();
        voidr(cfA.runAfterBothAsync(cfB, () -> System.out.println("runAfterBoth")));
        join();

        init();
        voidr(cfA.acceptEitherAsync(cfB, w -> System.out.println("acceptEither: " + w)));
        join();

        init();
        voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> System.out.println("thenAcceptBoth" + w1 + ", " + w2)));
        join();

        // ************** apply()\combine() 生成新的CompletableFuture ***************
        init();
        // ******* 不懂：
        showr(cfA.applyToEitherAsync(cfB, w -> {
            System.out.println("applyToEither: " + w);
            return w;
        }));
        join();


        init();
        showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombine: " + w1 + ", " + w2);
            return w1;
        }));
        join();

        //************* any | all 批量执行控制方法 ***************
        init();
        CompletableFuture<Workable> cfC = Workable.make("C", 0.08),
                cfD = Workable.make("D", 0.09);
        CompletableFuture.anyOf(cfA, cfB, cfC, cfD).thenRunAsync(() -> System.out.println("anyOf"));
        join();
        join(cfC, cfD);

        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD).thenRunAsync(() -> System.out.println("allOf"));
        join();
        join(cfC, cfD);
    }
}
