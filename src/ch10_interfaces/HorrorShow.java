package ch10_interfaces;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

/**
 * 实现了继承接口： 需要实现两个方法
 */
class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

/**
 * @author shishaolong
 * @datatime 2020/4/10 10:58
 */
public class HorrorShow {
    static void a(Monster b) {
        b.menace();
    }

    static void b(DangerousMonster b) {
        b.destroy();
        b.menace();
    }

    static void c(Vampire b) {
        b.drinkBlood();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        a(barney);
        b(barney);
        Vampire vampire = new VeryBadVampire();
        a(vampire);
        b(vampire);
        c(vampire);
    }
}
