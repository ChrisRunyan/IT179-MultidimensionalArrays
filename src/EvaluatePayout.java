/*
 * File name: EvaluatePayout.java
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
 * Creates methods to evaluate the payout of a slot machine based on amount of coins entered
 * @author Christopher Runyan
 *
 */

public class EvaluatePayout{
	private String[][] table;
	private String[] symbols;
	
	public EvaluatePayout(String[][] table, String[] symbols){
		this.table=table;
		this.symbols=symbols;
	}
	
	public void setTable(String[][] table){
		this.table=table;
	}
	
	public boolean plumFirstTwoPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateFirstTwoPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[0].equals(symbols[1])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean plumAllPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateAllPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[1].equals(string[2])&&string[0].equals(symbols[1])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean bellFirstPosition(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String string=evaluateFirstPosition(row, diagLUpRDown, diagRUpLDown);
		
		if(string.equals(symbols[2])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean bellFirstTwoPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateFirstTwoPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[0].equals(symbols[2])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean bellAllPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateAllPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[1].equals(string[2])&&string[0].equals(symbols[2])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean barFirstPosition(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String string=evaluateFirstPosition(row, diagLUpRDown, diagRUpLDown);
		
		if(string.equals(symbols[3])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean barFirstTwoPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateFirstTwoPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[0].equals(symbols[3])){
			yes=true;
		}
		
		return yes;
	}
	
	public boolean barAllPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		boolean yes=false;
		String[] string=evaluateAllPositions(row, diagLUpRDown, diagRUpLDown);
		
		if(string[0].equals(string[1])&&string[1].equals(string[2])&&string[0].equals(symbols[3])){
			yes=true;
		}
		
		return yes;
	}
	
	private String evaluateFirstPosition(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		String string=null;
		
		if(diagLUpRDown){
			string=table[0][0];
		}
		else if(diagRUpLDown){
			string=table[0][2];
		}
		else if(!diagLUpRDown&&!diagRUpLDown){
			string=table[row][0];
		}
		
		return string;
	}
	
	private String[] evaluateFirstTwoPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		String[] string = new String[2];
		
		if(diagLUpRDown){
			for(int i=0; i<2; i++){
				string[i]=table[i][i];
			}
		}
		else if(diagRUpLDown){
			int j=2;
			for(int i=0; i<2; i++){
				string[i]=table[i][j];
				j--;
			}
		}
		else if(!diagLUpRDown&&!diagRUpLDown){
			for(int i=0; i<2; i++){
				string[i]=table[row][i];
			}
		}
		
		return string;
	}
	
	private String[] evaluateAllPositions(int row, boolean diagLUpRDown, boolean diagRUpLDown){
		String[] string = new String[3];
		
		if(diagLUpRDown){
			for(int i=0; i<3; i++){
				string[i]=table[i][i];
			}
		}
		else if(diagRUpLDown){
			int j=2;
			for(int i=0; i<3; i++){
				string[i]=table[i][j];
				j--;
			}
		}
		else if(!diagLUpRDown&&!diagRUpLDown){
			for(int i=0; i<3; i++){
				string[i]=table[row][i];
			}
		}
		return string;
	}
}
