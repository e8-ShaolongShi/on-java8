package ch19.test.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 提供获取宠物的工具类
 */
public class Pets {

    private static final PetCreator CREATOR = new ForNameCreator();

    public static Pet get(){
        return CREATOR.get();
    }

    /**
     * 以 数组的形式返回多个
     * @param size
     * @return
     */
    public static Pet[] array(int size){
        Pet[] pets = new Pet[size];
        for (int i = 0; i<size; i++){
            pets[i] = CREATOR.get();
        }
        return pets;
    }

    public static List<Pet> list(int size){
        List<Pet> list = new ArrayList();
        Pet[] array = array(size);
        Collections.addAll(list, array); // 将数组中的所有元素全部添加到list集合中
        return list;
    }

    /**
     * 返回宠物流
     * @return
     */
    public static Stream<Pet> stream(){
        return Stream.generate(CREATOR);
    }

}
