package com.streams;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamTest2 {
	
	public static void main(String[] args) {
		
		List<Account> listOfAccounts = Arrays.asList(
				new Account("Sriram", 9201045L, Type.NRO, 1300.00),
				new Account("Hanuman", 3201046L, Type.OTHER, 4300.00),
				new Account("Lakshman", 2201047L, Type.NRE, 61130.00),
				new Account("Seethamma", 9201048L, Type.RESIDENT, 2110.00),
				new Account("Dasarath", 8201049L, Type.RESIDENT, 81130.00),
				new Account("Bharath", 6201041L, Type.NRO, 21130.00),
				new Account("Ravan", 4201015L, Type.RESIDENT, 2130.00),
				new Account("Vaali", 3201045L, Type.RESIDENT, 1230.00),
				new Account("Raghav", 1201145L, Type.NRO, 23089.00),
				new Account("Maruthi", 5211045L, Type.NRO, 23056.00));
		
		// List of accounts group by Type of Account
		
		
		
		
		Map<Type,List<Account>> accountsGroupByType = 
				listOfAccounts.stream().collect(groupingBy(Account::getAccType));
		
		System.out.println(accountsGroupByType);
		System.out.println(accountsGroupByType.get(Type.NRO).size());
		
	}
	
	
	

}
