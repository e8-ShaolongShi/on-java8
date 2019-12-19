package ch19.test.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供 宠物池，  生成器可以从哪些中抽选  待选择项集合
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "ch19.test.pets.Mutt",
            "ch19.test.pets.Cat",
            "ch19.test.pets.Cymric",
            "ch19.test.pets.Dog",
            "ch19.test.pets.Hamster",
            "ch19.test.pets.Manx",
            "ch19.test.pets.Mouse",
            "ch19.test.pets.Pug",
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        for (String name : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(name))  ;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
