package ch9_polymorphism.shape.constructors;

class Shared {
    private int ref = 0;
    private static long counter = 0;
    private final long id = counter++;

    public void add() {
        this.ref++;
    }

    public Shared() {
        System.out.println("Creating Shared:" + this);
    }

    /**
     * 释放内存空间
     */
    public void dispose() {
        if (--ref == 0) {
            System.out.println("Shared.dispose() == 0 dispose() call!");
        }
    }

    @Override
    public String toString() {
        return "Shared{" +
                "id=" + id +
                '}';
    }
}

class Compose {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Compose(Shared shared) {
        System.out.println("Creating Compose:" + this);
        this.shared = shared;
        this.shared.add();
    }

    public void dispose() {
        System.out.println("compose dispose");
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Compose{" +
                "id=" + id +
                '}';
    }
}

/**
 * 构造器: 清理-释放内存空间
 */
public class Dispose {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Compose[] composes = {
                new Compose(shared),
                new Compose(shared),
                new Compose(shared),
                new Compose(shared),
                new Compose(shared)
        };

        for (Compose compose : composes) {
            compose.dispose();
        }
    }

}
