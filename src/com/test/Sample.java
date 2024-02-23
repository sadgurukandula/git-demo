package com.test;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 5, 15, 30, 25};

        int secondLargest = findSecondLargest(numbers);

        System.out.println("Second Largest Number: " + secondLargest);
    }

    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Invalid input, array size must be at least 2");
            return Integer.MIN_VALUE; // Return the minimum integer value as an indicator of invalid input
        }

        // Convert the array to a stream, sort it in descending order, and get distinct elements
        int secondLargest = Arrays.stream(arr)
                .boxed() // Convert int to Integer for stream operations
                .distinct() // Get distinct elements
                .sorted((a, b) -> Integer.compare(b, a)) // Sort in descending order
                .skip(1) // Skip the first element (largest)
                .findFirst() // Get the first element after skipping (second largest)
                .orElse(Integer.MIN_VALUE); // If not found, return minimum integer value

        return secondLargest;
    }
}
