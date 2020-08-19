package ch24_concurrent.completable_future;

import onjava.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author shishaolong
 * @datatime 2020/8/19 10:29
 */
public class Workable {
    String id;
    final double duration;

    private Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    public static Workable work(Workable tt) {
        new Nap(tt.duration);
        tt.id = tt.id + "w";
        System.out.println(tt);
        return tt;
    }

    /**
     * 将当前类创建为CompletableFuture
     *
     * @param id
     * @param duration
     * @return
     */
    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration)).thenApplyAsync(Workable::work);
    }
}
