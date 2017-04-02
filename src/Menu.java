/*
 * File name: Menu.java
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
 * Creates methods for a menu for a slot machine
 * @author Christopher Runyan
 *
 */

public class Menu {
	private int choice;
	private int numCoins;
	
	public void displayInstructions(){
		System.out.print("Thank you for playing the Redbird Slot Machines.\n\n"
				+ "Game instructions:\nYou will begin with 10 coins.\nYou can bet 1-5 coins.\n"
				+ "Rows evaluated for determining winnings are different based on the number of coins bet.\n"
				+ "1 coin - second row\n2 coins - first and second rows\n3 coins - first, second, and third rows\n"
				+ "4 coins - first, second, third rows, and diagonal top left to bottom right\n"
				+ "5 coins - all rows and both diagonals\nYou cannot have a negative balance.\nPress enter to continue.");
	}
	
	public void displayMenu(){
		System.out.print("\nSlot Machine Menu\n1. Play a game\n2. Check Balance\n3. Quit\n\n");
	}
	
	public int askChoice(Scanner kb){
		System.out.print("Please enter your choice: ");
		choice=kb.nextInt();
		while(!verifyChoice()){
			System.out.print("Invalid choice selection. Please enter your choice: ");
			choice=kb.nextInt();
		}
		return choice;
	}
	
	public int askNumCoins(Scanner kb, String amountToBet){
		System.out.print("Please enter the number of coins to bet "+amountToBet+": ");
		numCoins=kb.nextInt();
		while(!verifyNumCoins()){
			System.out.print("Invalid number of coins. Please enter the number of coins to bet "+amountToBet+": ");
			numCoins=kb.nextInt();
		}
		return numCoins;
	}
	
	private boolean verifyChoice(){
		boolean valid=false;
		switch(choice){
			case 1: 
			case 2:
			case 3:
				valid=true;
		}
		return valid;
	}
	
	private boolean verifyNumCoins(){
		boolean valid=false;
		switch(numCoins){
			case 1: 
			case 2:
			case 3:
			case 4:
			case 5:
				valid=true;
		}
		return valid;
	}
}
