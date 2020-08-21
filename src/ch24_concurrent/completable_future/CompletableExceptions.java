package ch24_concurrent.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * @author shishaolong
 * @datatime 2020/8/20 14:10
 */
public class CompletableExceptions {

    /**
     * 测试： 创建Breakable 连续调work方法
     *
     * @param id
     * @param failcount
     * @return
     */
    static CompletableFuture<Breakable> test(String id, int failcount) {
        return CompletableFuture.completedFuture(
                new Breakable(id, failcount))
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work);
    }

    public static void main(String[] args) {
        // Exceptions don`t appear
        test("A", 1);
        test("B", 2);
        test("C", 3);
        test("D", 4);
        test("E", 5);
        // ... until you try to fetch the value
        try {
            test("F", 2).get(); // or join()
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Test for exception
        System.out.println(
                test("G", 2).isCompletedExceptionally()
        );

        // Counts as "done"
        System.out.println(test("H", 2).isDone());
        // Force an exception:
        CompletableFuture<Integer> cfi = new CompletableFuture<>();
        System.out.println("done?" + cfi.isDone());
        cfi.completeExceptionally(new RuntimeException("forced"));
        try {
            cfi.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
