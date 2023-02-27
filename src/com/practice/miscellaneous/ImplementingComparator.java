package com.practice.miscellaneous;
import java.util.*;

/**
* Create a list of Pets and sort them by name. Then, sort them by age.
**/

public class ImplementingComparator {
    public static void main(String[] args) {
        List<Pet> list = new ArrayList<>();

        list.add(new Pet("Fido", 10));
        list.add(new Pet("Arla", 3));
        list.add(new Pet("Jaye",12));

        Collections.sort(list, (Pet a,Pet b)->{
            return a.name.compareTo(b.name);
        });

        Collections.sort(list, (Pet a, Pet b)->{
            return a.age-b.age;
        });

        for(Pet p: list){
            System.out.println(p.name + " - " + p.age);
        }
    }
}
class Pet {
    String name;
    int age;

    Pet(String name, int age) {
        this.age = age;
        this.name = name;
    }
}


