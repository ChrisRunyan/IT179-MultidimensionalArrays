/*
 * File name: Table.java
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

import java.util.Random;

/**
 * Holds arrays and methods that represent a table of cherries, plums, bells, and bars
 * @author Christopher Runyan
 *
 */

public class Table{
	private String[] symbols;
	private String[] wheelOne;
	private String[] wheelTwo;
	private String[] wheelThree;
	private String[][] table;
	private EvaluatePayout evalPayout;
	
	public Table(){
		symbols = new String[]{"Cherry", "Plum", "Bell", "Bar"};
		wheelOne = new String[]{symbols[0], symbols[0], symbols[0], symbols[0], symbols[1], symbols[2], symbols[3]};
		wheelTwo = new String[]{symbols[0], symbols[0], symbols[0], symbols[1], symbols[1], symbols[2], symbols[3]};
		wheelThree = new String[]{symbols[0], symbols[0], symbols[1], symbols[1], symbols[2], symbols[2], symbols[3]};
		table = new String[3][3];
		evalPayout=new EvaluatePayout(table, symbols);
	}

	public void spinTable(){
		Random ran=new Random();
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				if(col==0){
					table[row][col]=wheelOne[ran.nextInt(7)];
				}
				else if(col==1){
					table[row][col]=wheelTwo[ran.nextInt(7)];
				}
				else if(col==2){
					table[row][col]=wheelThree[ran.nextInt(7)];
				}
			}
		}
	}
	
	public void displayTable(){
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				System.out.printf("%-10s", table[row][col]);
			}
			System.out.println();
		}
	}
	
	public int evaluateOneCoin(){
		evalPayout.setTable(table);
		int payout=0;
		
		if(evalPayout.plumFirstTwoPositions(1, false, false)||evalPayout.bellFirstPosition(1, false, false)){
			payout=1;
		}
		else if(evalPayout.plumAllPositions(1, false, false)||evalPayout.bellFirstTwoPositions(1, false, false)||evalPayout.barFirstPosition(1, false, false)){
			payout=2;
		}
		else if(evalPayout.bellAllPositions(1, false, false)||evalPayout.barFirstTwoPositions(1, false, false)){
			payout=3;
		}
		else if(evalPayout.barAllPositions(1, false, false)){
			payout=5;
		}
			
		return payout;
	}
	
	public int evaluateTwoCoins(){
		evalPayout.setTable(table);
		int payout1=0;
		int payout2=0;
		
		if(evalPayout.plumFirstTwoPositions(0, false, false)||evalPayout.bellFirstPosition(0, false, false)){
			payout1=1;
		}
		else if(evalPayout.plumAllPositions(0, false, false)||evalPayout.bellFirstTwoPositions(0, false, false)||evalPayout.barFirstPosition(0, false, false)){
			payout1=2;
		}
		else if(evalPayout.bellAllPositions(0, false, false)||evalPayout.barFirstTwoPositions(0, false, false)){
			payout1=3;
		}
		else if(evalPayout.barAllPositions(0, false, false)){
			payout1=5;
		}
		payout2=evaluateOneCoin();
		
		return payout1+payout2;
	}
	
	public int evaluateThreeCoins(){
		evalPayout.setTable(table);
		int payout1=0;
		int payout2=0;
		
		payout1=evaluateTwoCoins();
		if(evalPayout.plumFirstTwoPositions(2, false, false)||evalPayout.bellFirstPosition(2, false, false)){
			payout2=1;
		}
		else if(evalPayout.plumAllPositions(2, false, false)||evalPayout.bellFirstTwoPositions(2, false, false)||evalPayout.barFirstPosition(2, false, false)){
			payout2=2;
		}
		else if(evalPayout.bellAllPositions(2, false, false)||evalPayout.barFirstTwoPositions(2, false, false)){
			payout2=3;
		}
		else if(evalPayout.barAllPositions(2, false, false)){
			payout2=5;
		}
		
		return payout1+payout2;
	}
	
	public int evaluateFourCoins(){
		evalPayout.setTable(table);
		int payout1=0;
		int payout2=0;
		
		payout1=evaluateThreeCoins();
		if(evalPayout.plumFirstTwoPositions(0, true, false)||evalPayout.bellFirstPosition(0, true, false)){
			payout2=1;
		}
		else if(evalPayout.plumAllPositions(0, true, false)||evalPayout.bellFirstTwoPositions(0, true, false)||evalPayout.barFirstPosition(0, true, false)){
			payout2=2;
		}
		else if(evalPayout.bellAllPositions(0, true, false)||evalPayout.barFirstTwoPositions(0, true, false)){
			payout2=3;
		}
		else if(evalPayout.barAllPositions(0, true, false)){
			payout2=5;
		}
		
		return payout1+payout2;
	}
	
	public int evaluateFiveCoins(){
		evalPayout.setTable(table);
		int payout1=0;
		int payout2=0;
		
		payout1=evaluateFourCoins();
		if(evalPayout.plumFirstTwoPositions(0, false, true)||evalPayout.bellFirstPosition(0, false, true)){
			payout2=1;
		}
		else if(evalPayout.plumAllPositions(0, false, true)||evalPayout.bellFirstTwoPositions(0, false, true)||evalPayout.barFirstPosition(0, false, true)){
			payout2=2;
		}
		else if(evalPayout.bellAllPositions(0, false, true)||evalPayout.barFirstTwoPositions(0, false, true)){
			payout2=3;
		}
		else if(evalPayout.barAllPositions(0, false, true)){
			payout2=5;
		}
		
		return payout1+payout2;
	}
}
