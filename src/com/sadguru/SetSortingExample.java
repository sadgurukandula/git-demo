package com.sadguru;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetSortingExample {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        
        // Using streams
        names.stream()
             .sorted()
             .forEach(System.out::println);

        // Without streams
        Set<String> sortedNames = new TreeSet<>(names);
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}

