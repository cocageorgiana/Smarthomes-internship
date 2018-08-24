package com.example.smarthomes.streampythonservice.stream;

import com.example.smarthomes.streampythonservice.functional.FunctionalInterfaceTraining;
import com.example.smarthomes.streampythonservice.reader.FileProcessor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StreamTraining {

    private FileProcessor fileProcessor = new FileProcessor();

    private void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }

    public List<Integer> generateList() {
        int n = new Random().nextInt(50) + 1;
        List<Integer> list = Stream.iterate(0, i->i+n).limit(10).collect(Collectors.toList());
        return list;
    }

    public void removeEvenNumbers() throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        List<Integer> resultList = myList.stream().filter(it -> it%2!=0).collect(Collectors.toList());
        printList(resultList);
    }

    public void removeOddNumbers() throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        List<Integer> resultList = myList.stream().filter(it -> it%2==0).collect(Collectors.toList());
        printList(resultList);
    }

    public void findMax() throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        Integer maxNumber = myList.stream().mapToInt(it -> it).max().orElseThrow(NoSuchElementException::new);
        System.out.println("The maximum number is: " +  maxNumber);
    }

    public void findElement(Integer elementToSearch) throws IOException {
        List<Integer> myList = generateList();
        Integer x = myList.stream().filter(elementToSearch::equals).findAny().orElse(null);
        if(x == null) {
            System.out.println(elementToSearch + " was not found");
        }
        else {
            System.out.println(elementToSearch + " was found");
        }
    }

    public void sortList() {
        List<Integer> myList = generateList();
        List<Integer> resultList = myList.stream().sorted().collect(Collectors.toList());
        System.out.println(resultList);
    }

    public void findNumbersLessThan(Integer numberToCompare) throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        System.out.println(myList);
        FunctionalInterfaceTraining.eval(myList, it->false);
        FunctionalInterfaceTraining.eval(myList, it->it<numberToCompare);
    }

    public void findSum() throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        Integer sum = myList.stream().mapToInt(it -> it).reduce(0, (a,b) -> a+b);
        System.out.println("The sum is: " + sum);
    }

    public void findSumFunctional() throws IOException {
        List<Integer> myList = fileProcessor.readFromFile();
        FunctionalInterfaceTraining sum = (list) -> list.stream().mapToInt(it -> it).reduce(0 ,(a,b) -> a + b);
        int actualSum = sum.findSumFunctional(myList);
        System.out.println("The functional sum is " + actualSum);
    }

    public void convertToMap() throws IOException {
        List<Integer> fileList = fileProcessor.readFromFile();
        Map<Integer, Integer> resultMap = fileList.stream().collect(Collectors.toMap(Integer::new, Function.identity()));

        resultMap.forEach((key, value)-> System.out.println("Key: " + key + " " + "Value: " + value));
    }

    public void findProduct() throws IOException {
        List<Integer> fileList = fileProcessor.readFromFile();
        Map<Integer, Integer> resultMap = fileList.stream().collect(Collectors.toMap(Integer::new, Function.identity()));
        BinaryOperator<Integer> binaryOperator = (it1, it2) -> it1*it2;
        FunctionalInterfaceTraining.binaryOperator(resultMap, binaryOperator);
    }

    public void printNumbersWithLastDigit(Integer lastDigit) throws IOException {
        List<Integer> fileList = fileProcessor.readFromFile();
        Function<Integer, Boolean> myFunction = it -> it%10==lastDigit;
        FunctionalInterfaceTraining.printElementWithLastDigit(fileList, myFunction);
    }

    public void countElements() throws IOException {
        List<Integer> fileList = fileProcessor.readFromFile();
        long count = fileList.stream().mapToInt(it -> it).count();
        System.out.println("The number of elements in the file is: " + count);
    }
}
