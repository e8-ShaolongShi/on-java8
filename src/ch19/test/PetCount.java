package ch19.test;

import ch19.test.pets.*;

import java.util.HashMap;

public class PetCount {

    static class Counter extends HashMap<String, Integer>{
        public void count(String type){
            Integer get = get(type);
            if (get == null){
                put(type, 1);
            }else {
                put(type, get + 1);
            }
        }
    }

    public static void countPets(PetCreator creator){
        Counter counter = new Counter();

        for (Pet pet : Pets.array(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");

            if(pet instanceof Pet)
                counter.count("pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof  Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug)
                counter.count("Pug");
            if (pet instanceof  Cat)
                counter.count("Cat");
            if (pet instanceof EgytianMau)
                counter.count("EgytianMau");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof Cymric)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");


        }

        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
