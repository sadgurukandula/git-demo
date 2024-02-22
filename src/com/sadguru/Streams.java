package com.sadguru;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

	
	
	public static void main(String[] args) {
		
		String str = "ABcabcdefffggg";
		String str1 = "I am using java and java is a good programming language";
		int[] numArray = {1,2,5,4,3};
		int number = 5;
				
		charCount(str);
		duplicates(str);
		maxRepeated(str);
		firstReptativeAndNonRepitative(str);
		vowelsCount(str);
		wordsReversal(str1);
		secondHighestFromLast(numArray);
		multiply(numArray);
		longestString();
		nubmerStartsWith();
		highestSalary();
		printPrimeNumbers();
		isPalindrome(str);
		factorial(number);
	
	}
	
	public static void charCount(String str) {
		String[] chars = str.split("");
		
		Map<String,Long> result =
		Arrays.asList(chars).stream().map(s->s.toUpperCase())
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(result);
		
		
	}
	
	public static void duplicates(String str) {
		String[] chars = str.split("");
		
		
		List<String> result =
		Arrays.asList(chars).stream().map(s->s.toUpperCase())
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey())
			.collect(Collectors.toList());
		
		System.out.println(result);
		
		
	}
	
	public static void maxRepeated(String str) {
		String[] chars = str.split("");
		
		 Entry<String, Long> result = Arrays.asList(chars).stream().map(s->s.toUpperCase())
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		
		System.out.println(result);
		
		
	}
	
	public static void firstReptativeAndNonRepitative(String str) {
		String[] chars = str.split("");
		
		String firstRepitative =
		Arrays.asList(chars).stream().map(s->s.toUpperCase())
			.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			.entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey())
			.findFirst().get();
		
		String firstNonRepitative =
				Arrays.asList(chars).stream().map(s->s.toUpperCase())
					.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
					.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey())
					.findFirst().get();
		
		System.out.println(firstRepitative);
		System.out.println(firstNonRepitative);
		
		
	}
	
	public static void vowelsCount(String str) {
		
		long vowelsCount =	str.chars()
						.filter(x -> { return(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'||x=='A'||x=='E'||x== 'I'||x=='O'||x=='U');})
						.count();
		System.out.println("Vowels count in given string is :" + vowelsCount);
	}
	
	
	public static void wordsReversal(String inputStr) {
		
		
		String revString = Arrays.stream(inputStr.split("\s"))
							.reduce((word1,word2) -> word2 + " " + word1)
							.orElse("");
		
		long count = Arrays.stream(inputStr.split("\s")).count();
		
		List<String> uniqueWords = Arrays.stream(inputStr.split("\s"))
							.distinct()
							.collect(Collectors.toList());
		String rev = Arrays.stream(inputStr.split(""))
				.reduce((word1,word2) -> word2 + word1)
				.orElse("");
		
		System.out.println("Given String is : " + inputStr);
		System.out.println("Revers Words String is :" + revString);
		System.out.println("Number of words in the given String are :" + count);
		System.out.println("Unique words in the given String are :" + uniqueWords);
		System.out.println("Reversal of complete String is :" + rev);
	}

	
	public static void secondHighestFromLast(int[] intArray) {
		
		int result = Arrays.stream(intArray)
					.boxed()
					.sorted(Comparator.reverseOrder())
					.mapToInt(Integer::intValue)
					.skip(1)
					.findFirst()
					.getAsInt();
		
		System.out.println(result);
		
	}

	public static void multiply(int[] numArray) {
		int result	   = Arrays.stream(numArray)
					//	.boxed()
						.reduce((a,b) -> a*b)
						.getAsInt();
		
		System.out.println(result);
	}

	public static void longestString() {
		
		String[] arr = {"java","docker","spring","hibernate","microservices"};
		
		String longestStr = Arrays.stream(arr)
						.reduce((word1,word2)-> word1.length()>word2.length()?word1:word2)
						.get();
		
		System.out.println("The Longest word is :" + longestStr);
		
	}
	
public static void nubmerStartsWith() {
		
		int[] arr = {2,4,3,1,11,29};
		
		List<String> numList = Arrays.stream(arr)
						.boxed()
						.map(s -> s + "")
						.filter(s-> s.startsWith("2"))
						.collect(Collectors.toList());
		
		System.out.println(numList);
		
	}
public static void highestSalary() {
	
	Map<String,Integer> map = new HashMap<>();
	
	map.put("Reema", 1000);
	map.put("Ramesh", 1500);
	map.put("Venkatesh", 1000);
	map.put("Vikas", 2000);
	map.put("Vinith", 1200);
	map.put("Subbu", 1500);
	map.put("Chandy", 2000);
	
	int num = 2;
	
	nthHighestSalary(num,map);
	
}

public static void nthHighestSalary(int num,Map<String,Integer> map) {
	
	
	
	  Entry<Integer, List<String>> result = map.entrySet().stream()
	.collect(Collectors.groupingBy((Map.Entry::getValue),Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
	.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(num-1);
	 
	 System.out.println(result);
	
}

public static void printPrimeNumbers() {
    System.out.println("Prime numbers between 1 to 100:");
    IntStream.rangeClosed(2, 100)
            .filter(Streams::isPrime)
            .forEach(System.out::println);
}

public static boolean isPrime(int number) {
    return number > 1 && IntStream.range(2, number)
            .noneMatch(i -> number % i == 0);
}

public static boolean isPalindrome(String str) {
    // Remove all non-alphanumeric characters and convert to lowercase
    String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    
    // Compare characters from start with characters from end using streams
    return IntStream.range(0, cleanedStr.length() / 2)
                    .allMatch(i -> cleanedStr.charAt(i) == cleanedStr.charAt(cleanedStr.length() - 1 - i));
}

public static long factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }
    return IntStream.rangeClosed(1, n)
                    .reduce(1, (a, b) -> a * b);
}


}








