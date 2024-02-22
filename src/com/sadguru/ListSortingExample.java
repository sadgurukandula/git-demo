package com.sadguru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(7);
        numbers.add(1);
       
        
        // Using streams
     
        		 numbers
        		.stream()
        		.sorted()
        		.forEach(System.out::println);

        // Without streams
       // Collections.sort(numbers);
        numbers.sort(Comparator.naturalOrder());
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
