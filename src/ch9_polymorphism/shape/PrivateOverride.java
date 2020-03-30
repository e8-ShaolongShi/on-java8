package ch9_polymorphism.shape;

/**
 * 多态 陷阱： 重写父类私有方法
 * @author shishaolong
 * @datatime 2020/3/27 18:03
 */
public class PrivateOverride {

    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
//        System.out.println(po.f());  //不能覆盖
    }
}

class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public f()");
    }
}
