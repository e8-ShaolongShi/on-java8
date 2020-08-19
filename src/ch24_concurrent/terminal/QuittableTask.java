package ch24_concurrent.terminal;

import onjava.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * quit 测试
 *
 * @author shishaolong
 * @datatime 2020/8/18 8:57
 */
public class QuittableTask implements Runnable {

    final int id;
    public QuittableTask(int id){
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    public void quit(){
        running.set(false);
    }


    @Override
    public void run() {
        while (running.get()){
            new Nap(0.1);
        }
        System.out.println(id+ " ");
    }
}
