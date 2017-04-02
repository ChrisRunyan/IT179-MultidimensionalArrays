/*
 * File name: Driver.java
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

import java.util.Scanner;

/**
 * Main class that utilizes classes Balance, Menu, and Table
 * @author Christopher Runyan
 *
 */

public class Driver{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		Table table=new Table();
		Menu menu=new Menu();
		Balance balance=new Balance();
		int choice=0;
		
		menu.displayInstructions();
		kb.nextLine();
		while(!(choice==3)&&balance.getBalance()>0){
			menu.displayMenu();
			choice=menu.askChoice(kb);
			if(choice==1){
				int numCoins=0;
				int winnings=0;
				String amountToBet=null;
				amountToBet=balance.getAmountToBet();
				numCoins=menu.askNumCoins(kb, amountToBet);
				while(!balance.verifyAmountToSubtract(numCoins)){
					System.out.println("Not enough coins. Bet a lower amount.");
					numCoins=menu.askNumCoins(kb, amountToBet);
				}
				System.out.println();
				balance.subtractAmount(numCoins);
				table.spinTable();
				table.displayTable();
				if(numCoins==1){
					winnings=table.evaluateOneCoin();
				}
				else if(numCoins==2){
					winnings=table.evaluateTwoCoins();
				}
				else if(numCoins==3){
					winnings=table.evaluateThreeCoins();
				}
				else if(numCoins==4){
					winnings=table.evaluateFourCoins();
				}
				else if(numCoins==5){
					winnings=table.evaluateFiveCoins();
				}
				balance.addAmount(winnings);
				System.out.println();
				System.out.println("You win "+winnings+" coins.");
			}
			else if(choice==2){
				balance.printBalance();
			}
		}
		if(balance.getBalance()<=0){
			System.out.println("\nGame over, no money left to bet.");
		}
		System.out.println("\nYour final balance was "+balance.getBalance()+".\nThank you for playing!");
		
		kb.close();
	}

}
