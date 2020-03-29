package ch8_reuse;

/**
 * 测试继承初始化顺序，先初始化父类，最后再初始化子类
 */
class Art{
    Art(){
        System.out.println("this is Art");
    }
}

class Drawing extends Art{
    Drawing(){
        System.out.println("this is Drawing!");
    }
}

public class Cartoon extends Drawing{
//    Cartoon(){
//        System.out.println("this is Cartoon");
//    }

    public static void main(String[] args) {
        new Cartoon();
    }
}

/*
// 输出结果： 从顶级父类开始一层一层往下初始化
this is Art
this is Drawing!
this is Cartoon
 */
