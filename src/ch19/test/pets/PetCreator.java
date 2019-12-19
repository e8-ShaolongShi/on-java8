package ch19.test.pets;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * 生成器，随机生成   从池子里面挑哪个  如何选取
 */
public abstract class PetCreator implements Supplier<Pet> {

    private Random rand = new Random(47);

    /**
     * 抽象方法，获取一个包含了所有宠物的集合
     * @return
     */
    public abstract List<Class<? extends Pet>> types();

    public Pet get(){
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
