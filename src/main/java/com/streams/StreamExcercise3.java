package com.streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class StreamExcercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
			    new Transaction(brian, 2011, 300),
			    new Transaction(raoul, 2012, 1000),
			    new Transaction(raoul, 2011, 400),
			    new Transaction(mario, 2012, 710),
			    new Transaction(mario, 2012, 700),
			    new Transaction(alan, 2012, 950)
			);
		
		//Practice Test 1 Find all transactions in the year 2011 and sort them by value (small to high).
		
		List<Transaction> tnxOf2011 = transactions.stream()
				.filter(y -> y.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());
		
		for ( Transaction tnx : tnxOf2011) {
			System.out.println(tnx.getYear()+" "+tnx.getValue());
		}
		System.out.println("-----------------");
		
		// Practice Test 2 What are all the unique cities where the traders work?
		
		 Set<String> uniqueCities = transactions.stream()
				 				.map(transaction -> transaction.getTrader().getCity())
				 				.collect(toSet());
			//	
		 uniqueCities.forEach(c -> System.out.println(c));
		 System.out.println("-----------------");
						
		// Practice Test 3 Find all traders from Cambridge and sort them by name.
		
		List<Trader> traderNamesFromCambridge = transactions.stream()
								.map(Transaction::getTrader)
								.filter(tr -> tr.getCity().equals("Cambridge"))
								.distinct()
								.sorted(comparing(Trader::getName))
								.collect(toList());
		System.out.println(traderNamesFromCambridge.size());
		System.out.println("-----------------");
		// Practice Test 4  Return a string of all traders’ names sorted alphabetically.
		
		Set<String> allTraderNamesSorting = transactions.stream()
									.map(tnx -> tnx.getTrader().getName())
									.sorted().collect(toSet());
		
		allTraderNamesSorting.forEach(n -> System.out.println(n));
		
		// Practice Test 5   Are any traders based in Milan?
		
		boolean anyTraderBasedFromMilan = transactions.stream()
				.anyMatch(tnx -> tnx.getTrader().getCity().equals("Milan"));
									
		// Practice Test 6 Print all transactions’ values from the traders living in Cambridge.
		
		List<Integer> tnxValuesFromCambridge = transactions.stream()
									.filter(tnx -> tnx.getTrader().getCity().equals("Cambridge"))
									.map(Transaction::getValue)
									.collect(toList());
		
		transactions.stream().
						filter(tnx -> tnx.getTrader().getCity().equals("Cambridge"))
						.forEach(System.out::println);
		
		// Practice Test 7 What’s the highest value of all the transactions?
		
		Optional<Integer> hightestValue = transactions.stream()
									.map(Transaction::getValue)
									.reduce(Integer::max);
		
		System.out.println(hightestValue.get());
		
		// Practice Test 8 Find the transaction with the smallest value
		
		Optional<Integer> smalllestValue = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::min);
		
		System.out.println(smalllestValue.get());
		
		// One more Idea
		Optional<Transaction> smallValue =  transactions.stream().min(comparing(Transaction::getValue));
		
		System.out.println(smallValue.get().getValue());
		
		// Practice Test 9 - Sum of all tnx values
		int sumOfAllTnxValues = transactions.stream()
								.mapToInt(Transaction::getValue)
								.sum();
		System.out.println(sumOfAllTnxValues);
	}

}
