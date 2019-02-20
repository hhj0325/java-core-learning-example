package org.javacore.javaeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by huhaojian on 2018/12/7 0007.
 */
public class Test2 {

    public static void main(String[] args) {
        List<Integer> old = Arrays.asList(23, 13, 1, 10, 20, 4, 5, 6, 7);
        System.out.println(quickSort(old));
        System.out.println(quickSort2(old));


    }

    private static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            Integer pivot = list.get(0);
            List<Integer> less = list.stream().skip(1L).filter(el -> el <= pivot).collect(Collectors.toList());
            List<Integer> greater = list.stream().skip(1L).filter(el -> el > pivot).collect(Collectors.toList());

            return Stream
                .of(quickSort(less).stream(), Stream.of(pivot), quickSort(greater).stream())
                .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }

    private static List<Integer> quickSort2(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            Integer pivot = list.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for(int i = 1 ; i < list.size(); i ++){
                if(list.get(i) <= pivot){
                    less.add(list.get(i));
                }
                else {
                    greater.add(list.get(i));
                }
            }

            List<Integer> ret = quickSort2(less);
            ret.add(pivot);
            ret.addAll(quickSort2(greater));
            return ret;
        }
    }

}
