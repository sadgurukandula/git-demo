package com.sadguru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ComparatorExample {

	public static void main(String[] args) {
		
		int num = 2;
		
		List<Employee> empList = new ArrayList<>();
		createEmployeeList(empList);
		maxAndMinSalary(empList);
		maxAndMinSalaryByDept(empList);
		nthmaxAndMinSalary(empList,num);
		nthmaxAndMinSalaryByDept(empList,num);
		
		
		System.out.println("Employee list before sorting :");
		empList.forEach(emp -> System.out.println("Name : " + emp.getName() + "  City :" + emp.getCity()));
		
		empList.sort(Comparator.comparing(Employee::getName));
		
		System.out.println("Employee list after sorting :");
		empList.forEach(emp -> System.out.println("Name : " + emp.getName() + "  City :" + emp.getCity()));
		
		empList.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getCity));
		
		System.out.println("Employee list after group sorting :");
		empList.forEach(emp -> System.out.println("Name : " + emp.getName() + "  City :" + emp.getCity()));
	}

	public static void createEmployeeList(List<Employee> empList) {

		empList.add(new Employee(1,"Ram","Hyderabad","HR",2000.00));
		empList.add(new Employee(2,"karthik","Delhi","FINANCE",2000.00));
		empList.add(new Employee(3,"Suresh","Pune","HR",1000.00));
		empList.add(new Employee(4,"Mahesh","Bangalore","ADMIN",25000.00));
		empList.add(new Employee(5,"Kavitha","Bangalore","FINANCE",18000.00));
		empList.add(new Employee(6,"Mohan","Hyderabad","ADMIN",18000.00));	
		empList.add(new Employee(7,"Sunita","Hyderabad","HR",2000.00));
		empList.add(new Employee(8,"Anitha","Delhi","FINANCE",2000.00));
		empList.add(new Employee(9,"Puppy","Pune","HR",1000.00));
		empList.add(new Employee(10,"Aruna","Bangalore","ADMIN",25000.00));
		empList.add(new Employee(11,"Sudhir","Bangalore","FINANCE",18000.00));
		empList.add(new Employee(12,"Nani","Hyderabad","ADMIN",18000.00));	
		empList.add(new Employee(13,"Hanuman","Hyderabad","HR",2000.00));
		empList.add(new Employee(14,"siva","Delhi","FINANCE",2000.00));
		empList.add(new Employee(15,"Brahma","Pune","HR",1000.00));
		empList.add(new Employee(16,"Amma","Bangalore","ADMIN",25000.00));
		empList.add(new Employee(17,"Devi","Bangalore","FINANCE",18000.00));
		empList.add(new Employee(18,"Bavani","Hyderabad","ADMIN",18000.00));	
		
	}
	
	public static void maxAndMinSalary(List<Employee> empList) {
		
			Optional<Employee> maxSalaryEmployee = empList.stream()
													.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
			
			Optional<Employee> minSalaryEmployee = empList.stream()
					.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
			
			System.out.println(maxSalaryEmployee.get());
			System.out.println(minSalaryEmployee.get());
		
	}
	public static void maxAndMinSalaryByDept(List<Employee> empList) {
		
		Map<String, Optional<Employee>> maxSalaryByDept = empList.stream()
												    	.collect(Collectors.groupingBy(Employee::getDept,
														    	Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		Map<String, Optional<Employee>> minSalaryByDept = empList.stream()
		    	.collect(Collectors.groupingBy(Employee::getDept,
				    	Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Employee::getSalary)))));
		
//      -----Second Approach----
		
//		Map<String, Optional<Employee>> result1 = empList.stream()
//	    	.collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
//		
//		Map<String, Optional<Employee>> result2 = empList.stream()
//		    	.collect(Collectors.groupingBy(Employee::getDept,Collectors.minBy(Comparator.comparing(Employee::getSalary))));
			    	
		
		System.out.println(maxSalaryByDept);
	//	System.out.println(result1);
		System.out.println(minSalaryByDept);
	//	System.out.println(result2);
		
		
	}
	
	public static void nthmaxAndMinSalary(List<Employee> empList, int num) {
		
		Entry<Double, List<String>> nthMaxSalaryFromLast = empList.stream()
		.collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getName, Collectors.toList())))
		.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(num-1);
		
		Entry<Double, List<String>> nthMaxSalaryFromFirst = empList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).get(num-1);
		
		
		System.out.println(nthMaxSalaryFromLast);
		System.out.println(nthMaxSalaryFromFirst);
	}
	
public static void nthmaxAndMinSalaryByDept(List<Employee> empList, int num) {
		
		empList.stream()
		.collect(Collectors.groupingBy(Employee::getDept)).entrySet().stream()
		.forEach(s->{Entry<Double, List<String>> nthMaxSalaryFromLast =s.getValue().stream()
											.collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getName, Collectors.toList())))
											.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(num-1);
				System.out.println("The nth highest salary from Last for the dept  " + s.getKey() +" is :" + nthMaxSalaryFromLast );
			});
		
		empList.stream()
		.collect(Collectors.groupingBy(Employee::getDept)).entrySet().stream()
		.forEach(s->{Entry<Double, List<String>> nthMaxSalaryFromFirst = s.getValue().stream()
											.collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getName, Collectors.toList())))
											.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).get(num-1);
				System.out.println("The nth highest salary from First for the dept  " + s.getKey() +" is :" + nthMaxSalaryFromFirst );
			});
		
		
	}
	
}
