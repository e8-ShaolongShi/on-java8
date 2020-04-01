package ch10_interfaces.statics;

/**
 * 接口中可以写静态方法
 * 模板方法 设计模式
 *
 * @author shishaolong
 * @datatime 2020/4/1 10:09
 */
public interface Operations {

    /**
     * 接口方法，在实现类中要实现的接口
     */
    void execute();

    /**
     * 模板方法： 此处是不变的逻辑，将所有的实现类的excute方法
     * @param ops
     */
    static void runOps(Operations ...ops){
        for (Operations op : ops) {
            // 调用实现此接口的方法
            op.execute();
        }
    }

    /**
     * 公共方法  实现类可调用
     * @param msg
     */
    static void show(String msg){
        System.out.println(msg);
    }
}
