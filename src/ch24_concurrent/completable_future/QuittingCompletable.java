package ch24_concurrent.completable_future;

import ch24_concurrent.terminal.QuittableTask;
import ch24_concurrent.terminal.QuittingTasks;
import onjava.Nap;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 使用CompletableFuture
 *
 * @author shishaolong
 * @datatime 2020/8/18 9:19
 */
public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> tasks = IntStream.range(1, QuittingTasks.COUNT).mapToObj(QuittableTask::new).collect(Collectors.toList());
        List<CompletableFuture<Void>> cFutures = tasks.stream().map(CompletableFuture::runAsync).collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cFutures.forEach(CompletableFuture::join);
    }
}
