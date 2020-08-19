package ch24_concurrent.completable_future;

import onjava.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * thenApplyAsync
 *
 * @author shishaolong
 * @datatime 2020/8/19 9:12
 */
public class CompletableApplyAsync {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
        System.out.println(timer.duration());
        // **** 重点，cf.join API的意思：  知道cf.完成之前组织main进程结束
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }
}
