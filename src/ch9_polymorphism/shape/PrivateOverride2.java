package ch9_polymorphism.shape;

/**
 * 多态 陷阱： 重写父类私有方法
 *
 * @author shishaolong
 * @datatime 2020/3/27 18:03
 */
public class PrivateOverride2 {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
//        System.out.println(po.f());  //不能覆盖
    }
}

class Derived2 extends PrivateOverride2 {
    //    @Override  报错，不能覆盖
    public void f() {
        System.out.println("public f()");
    }
}
