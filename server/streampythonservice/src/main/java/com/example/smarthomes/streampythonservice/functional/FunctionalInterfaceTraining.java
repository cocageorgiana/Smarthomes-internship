package com.example.smarthomes.streampythonservice.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
public interface FunctionalInterfaceTraining {
//refactor
    static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer it : list) {
            if(predicate.test(it)) {
                System.out.println(it + " ");
            }
        }
    }

    Integer findSumFunctional(List<Integer> list);

    static void binaryOperator(Map<Integer, Integer> integerMap, BinaryOperator<Integer> binaryOperator) {
        List<Integer> resultList = new ArrayList<>();
        integerMap.forEach((it1,it2)->resultList.add(binaryOperator.apply(it1,it2)));
        resultList.forEach(System.out::println);
    }

    //refactor
    static void printElementWithLastDigit(List<Integer> integerList, Function<Integer, Boolean> someFunction) {
        List<Integer> resultList = new ArrayList<>();
        for(Integer it : integerList) {
            if(someFunction.apply(it)) {
                resultList.add(it);
            }
        }
        resultList.forEach(System.out::println);
    }
}
