package com.sadguru;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringCases {

	String str = "I am using java and java is a good programming language";
	
	public static void main(String[] args) {
		
		StringCases sample = new StringCases();
		
		wordReversal(sample.str);
		
		stringJoin();
		
	}
	
	public static void wordReversal(String str) {
		
		String[] words = str.split(" ");
		String rev = "";
		String[] uniqueWords = new String[words.length];
		int count = 0;
		
		for(int i = words.length - 1; i>=0;i--) {
			
			rev = rev + words[i] + ' ';
			count = count + 1;
			
			for (int j = 0;j<words.length;j++) {
				
				if (uniqueWords[j] == null){
					uniqueWords[j] = words[i];
					break;
				}
				else if (uniqueWords[j].equals(words[i])) {
					break;
				}
				
			}
			
		}
		
		System.out.println("The string in reverse order is :" + rev);
		System.out.println("Total number of words in given String are :" + count);
		System.out.println("Unique words in given string are :");
		
		for(String str1 : uniqueWords) {
			if (str1 != null)
			System.out.println(str1);
		}
		
	}
	
	public static void stringJoin() {
		String input ="Hello how are you";
		String[] inputArray = input.split(" ");
		StringJoiner joiner = new StringJoiner("-","[","]");
		
		for(String str : inputArray) {
			joiner.add(str);
		}
	
		System.out.println(joiner.toString());
		
		List<String> inputList = Arrays.asList(inputArray);
		String output = inputList.stream().collect(Collectors.joining("-","[", "]"));
		
		System.out.println(output);
		
		
		
	}
	
}
