package com.practice.hashmapproblems;
import java.util.*;
/**Problem statement:
 * Create a map of Integers and recursively sum up all of its elements

 This is a problem I created for myself, in order to be able to a depth-first search on a map
 **/
public class SumAllElementsInAMap {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 3);
        map.put(3, 6);
        map.put(6, 5);
        map.put(5, 2);

        System.out.println("result: "+ sumMap(map,1,set));
    }

    public static int sumMap(Map<Integer, Integer> map, int number,  Set<Integer> set ){

        if(set.contains(number)){
            return 0;
        }
        if(!map.containsKey(number)){
            set.add(number);
            return number;
        }
        set.add(number);
        return number +sumMap(map, map.get(number), set);

    }

}
