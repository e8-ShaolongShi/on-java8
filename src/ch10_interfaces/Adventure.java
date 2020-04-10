package ch10_interfaces;

interface CanFight {
    void fight();
}

interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

class ActionCharacter {
    public void fight() {

    }
}

class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}

/**
 * @author shishaolong
 * @datatime 2020/4/10 10:45
 */
public class Adventure {

    public static void a(CanFight x) {
        x.fight();
    }

    public static void b(CanSwim x) {
        x.swim();
    }

    public static void c(CanFly x) {
        x.fly();
    }

    public static void d(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        a(hero);
        b(hero);
        c(hero);
        d(hero);
    }
}
