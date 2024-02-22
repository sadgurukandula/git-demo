package com.sadguru;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortingExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "Alice");
        map.put(1, "Bob");
        map.put(4, "Charlie");
        map.put(3, "David");
        
        // Using streams
        map.entrySet().stream()
           .sorted(Map.Entry.comparingByKey())
           .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Without streams
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

