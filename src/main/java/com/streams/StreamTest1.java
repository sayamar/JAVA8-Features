package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {

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

		// With out streams - Please get the list of accounts
		// 1) with balance is less than 3000
		// 2) Sort by account holder name

		List<Account> listOfAccountsLessThan3k = new ArrayList<>();
		
		for (Account account : listOfAccounts) {
			if (account.getBalance() <= 3000.00) {
				listOfAccountsLessThan3k.add(account); // Filter the elements using the Accumulator
			}
		}
		
		Collections.sort(listOfAccountsLessThan3k, new Comparator<Account>() {
			public int compare(Account a1, Account a2) {
				return a1.getName().compareTo(a2.getName()); // Sort the accounts with name
			}
		});
		
		List<String> listOfNmaesWhosehavingBalanceLessThan3k = new ArrayList<>();
		for ( Account acc : listOfAccountsLessThan3k) {
			listOfNmaesWhosehavingBalanceLessThan3k.add(acc.getName()); // Process the sorted list with name of the account
		}
		
		// After JAVA8 with Streams
		Comparator<Account> comparing = (a1,a2) -> a1.getName().compareTo(a2.getName());
		
		List<String> listOfNmaesWhosehavingBalanceLessThan3k1 =
				listOfAccounts.stream()
				.filter(a -> a.getBalance() <=3000.00)
				.sorted(comparing)
				.map(Account::getName).
				collect(Collectors.toList());
				
		// Check the output
		listOfNmaesWhosehavingBalanceLessThan3k.forEach(n -> System.out.println(n));
		listOfNmaesWhosehavingBalanceLessThan3k1.forEach(n -> System.out.println(n));
		
	}
	
	

}
