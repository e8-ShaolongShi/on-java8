package ch9_polymorphism.shape.stage;

/**
 * 继承 VS 组合
 * <p>
 * 状态模式的应用
 */

class Act {
    public void act() {
        System.out.println("Act");
    }
}

class HappyAct extends Act {
    @Override
    public void act() {
        System.out.println("HappyAct!");
    }
}

class SadAct extends Act {
    @Override
    public void act() {
        System.out.println("SadAct!");
    }
}

class Stage {
    private Act act = new HappyAct();

    public void change() {
        act = new SadAct();
    }

    public void performPlay() {
        act.act();
    }
}

/**
 * 客户端类，测试改变状态
 */
public class Transmogrify {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
