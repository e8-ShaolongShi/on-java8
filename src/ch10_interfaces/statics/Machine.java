package ch10_interfaces.statics;

class Bing implements Operations {

    @Override
    public void execute() {
        System.out.println("my is Bing!");
    }
}

class Crack implements Operations {
    @Override
    public void execute() {
        Operations.show("Crack");
    }
}

class Twist implements Operations {
    @Override
    public void execute() {
        Operations.show("Twist");
    }
}

/**
 * @author shishaolong
 * @datatime 2020/4/1 10:17
 */
public class Machine {
    public static void main(String[] args) {
        Operations.runOps(new Bing(), new Crack(), new Twist());
    }
}
