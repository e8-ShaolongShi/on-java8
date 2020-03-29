package ch6_initial.enums;

import org.junit.jupiter.api.Test;

/**
 * 枚举用法
 */
public class SimpleEnumUse {

    @Test
    public void test_basic() {
        Colors gray = Colors.GRAY;
        System.out.println(gray);
    }

    @Test
    public void test_ordinal() {
        for (Colors c : Colors.values()) {
            System.out.println(c + ",ordinal " + c.ordinal());
        }
    }

    private Colors colors = Colors.BLACK;

    @Test
    public void test_switch() {
        System.out.println("this burrito is");

        switch (colors) {
            case GRAY:
                System.out.println("棕色！");
                break;
            case RED:
                System.out.println("红色！");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLACK:
                System.out.println("白色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            default:
                System.out.println("没有了");
        }

    }
}
