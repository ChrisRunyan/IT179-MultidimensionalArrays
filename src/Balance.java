/*
 * File name: Balance.java
 * 
 * Programmer: Christopher Runyan
 * ULID: caruny1
 * 
 * Date: 1/31/2016
 * 
 * Class: IT 179
 * Lecture Section: 03
 * Lecture Instructor: Cathy Holbrook
 */

package edu.ilstu;

/**
 * Creates methods to calculate changes in coin balance and holds the coin balance in a variable
 * @author Christopher Runyan
 *
 */

public class Balance{
	private int balance;
	
	public Balance(){
		balance=10;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance=balance;
	}
	
	public void addAmount(int amount){
		balance+=amount;
	}
	
	public void subtractAmount(int amount){
		balance-=amount;
	}
	
	public boolean verifyAmountToSubtract(int amount){
		boolean valid=true;
		if(amount>balance){
			valid=false;
		}
		return valid;
	}
	
	public String getAmountToBet(){
		String amountToBet=null;
		
		if(balance==1){
			amountToBet="(1)";
		}
		else if(balance<5){
			amountToBet="(1 - "+balance+")";
		}
		else{
			amountToBet="(1 - 5)";
		}
		return amountToBet;
	}
	
	public void printBalance(){
		System.out.println("\nCurrent balance: "+balance+" coins");
	}
}
