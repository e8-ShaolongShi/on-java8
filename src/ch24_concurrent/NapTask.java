package ch24_concurrent;

import onjava.Nap;

/**
 * @author shishaolong
 * @datatime 2020/8/17 14:53
 */
public class NapTask implements Runnable {

    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask[" + id + "]";
    }
}
