package ch9_polymorphism.shape.constructors;

/**
 * 多态中构造器的执行顺序
 */

class Glyph {
    void draw() {
        System.out.println("Glyph.draw!");
    }

    public Glyph() {
        System.out.println("Before call draw()!");
        draw();  // 子类会重写此方法
        System.out.println("After call draw()!");
    }
}

class RoundGlyph extends Glyph {

    int radius = 1;

    public RoundGlyph(int radius){
        this.radius = radius;
    }

    /**
     * 重写了父类的方法
     */
    @Override
    void draw() {
        System.out.println("Glyph.draw! radius=" + this.radius);
    }
}

public class PolyConstructor {

    public static void main(String[] args) {
        /**
         * 静态成员变量、只在类加载时初始化一次
         *
         * 不存在继承解构的类 对象初始化顺序
         * 1.成员变量默认初始化：分配内存空间、对分配的内存空间做清零处理，即初始化成默认值
         * 2.对实例成员安装定义的顺序进行初始化
         * 3.调用构造函数进行初始化
         *
         * 继承解构类 对象初始化顺序  只是对象初始化部分
         * 1.给当前类成员分配内存空间 并对分配的内存空间做清零处理，初始化成默认值
         * 2.递归到继承的最顶层父类，从最顶层父类开始，根据继承解构一层一层初始化到当前类
         * 3.对当前类中的实例成员变量按定义的顺序进行初始化
         * 4.执行当前类构造中的初始化语句
         */
        new RoundGlyph(5);
    }
}
