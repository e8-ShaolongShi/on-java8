package ch24_concurrent.threed_executor;

/**
 * @author shishaolong
 * @datatime 2020/8/17 15:13
 */
public class InterferingTask implements Runnable {

    final int id;
    private static Integer val = 0;
    public InterferingTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id+ " " + Thread.currentThread().getName() + " " + val);
    }
}
