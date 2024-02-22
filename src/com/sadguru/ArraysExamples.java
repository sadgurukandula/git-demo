package com.sadguru;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysExamples {

	public static void main(String[] args) {
		
		int[] input = {4,5,8,6,2,1,3};
		smallestMissing(input);
		
		int[] arr = {1, 2, 3, 7,3,5,5};
		
		
		
		int result =Arrays.stream(arr).reduce((a,b)->a>b?a:b).getAsInt();
		System.out.println(result);
		
        removeDuplicates(arr);
        
        commonElements(input,arr);
        commonElementsUsingStreams(input,arr);
        

	}
	
	public static void smallestMissing(int[] input) {
		int temp = 1;
		
		
		Arrays.sort(input);
		
		for(int i=0;i<input.length;i++) {
			if (input[i] == temp){
				temp++;
			}
			else {
				System.out.println(temp);
				break;
			}
		}
	}
	
	public static void removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index] = num;
            index++;
        }
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
	
	public static void commonElements(int[] input1,int[] input2) {
		
		Set<Integer> result = new HashSet<>();
		for (int i=0;i<input1.length;i++) {
			for (int j=0;j<input2.length;j++) {
				if (input1[i]==input2[j]) {
					result.add(input2[j]);
					break;
					
				}
			}
		}
		System.out.println();
		for (int num : result) {
			
            System.out.print(num + " ");
        }
		System.out.println();
	}
	
	public static void commonElementsUsingStreams(int[] input1,int[] input2) {
		
		List<Integer> commonElements = Arrays.stream(input1)
										.filter(i -> Arrays.stream(input2).anyMatch(j->i==j))
										.distinct().boxed().collect(Collectors.toList());
	
		System.out.println(commonElements);
	}

}
