package com.streams;

public class Account {
	
	private final String name;
	private final Long acctNumber;
	private final Type accType;
	private final Double balance;
	
	public Account(String name, Long acctNumber, Type accType, Double balance ) {
		super();
		this.name = name;
		this.acctNumber = acctNumber;
		this.accType = accType;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public Long getAcctNumber() {
		return acctNumber;
	}

	public Type getAccType() {
		return accType;
	}

	public Double getBalance() {
		return balance;
	}

	
	
	
	

}
