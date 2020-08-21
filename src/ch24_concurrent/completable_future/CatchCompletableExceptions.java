package ch24_concurrent.completable_future;

/**
 * CompletableFuture 之异常处理
 *
 * @author shishaolong
 * @datatime 2020/8/20 14:26
 */
public class CatchCompletableExceptions {
    static void handleException(int failcount) {
        // Call the Function only if there`s an Exception, must produce same type as came in:
        CompletableExceptions.test("exceptionlly", failcount)
                .exceptionally((ex) -> { //function
                    if (ex == null)
                        System.out.println("I don`t get it yet");
                    return new Breakable(ex.getMessage(), 0);
                })
                .thenAccept(str -> System.out.println("result: " + str));
    }
}
