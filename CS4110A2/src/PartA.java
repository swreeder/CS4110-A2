//		Samuel Reeder
//		CS 4110 - 1:39pm
//		Assignment #2
//		Dr. Rague
//		Due: 3/1/2018
//		Version: 1.0
//--------------------------------------------------------------------------------
//The program can recognize all words in the language defined by the following CFG.
//A CFG for alphabet {a,b} that recognizes the language consisting of all 
//strings that start with an odd number of a's followed by the same number of b's.
//---------------------------------------------------------------------------------


//--------------------------------------------------------------------------------
//The main method accepts input from the command line and tests this input to see
//if it is a word in the language described in the main header comments
//--------------------------------------------------------------------------------
public class PartA {

	public static void main(String[] args) {

	}
	
//-------------------------------------------------------------------------------
//The processData method accepts a target test string and then uses production 
//rules for the above defined CFG to determine if the target string is in the 
//language.
//-------------------------------------------------------------------------------
	private boolean processData(String inString, String wkString) {

		return true;
	}
	
//----------------------------------------------------------------------------------
//The getStartNT method is used in the constructor to acquire the value of the 
//starting non terminal from the production rules array. It is assumed that the
//first production rule in the array is also the initial production rule for the CFG
//----------------------------------------------------------------------------------
	char getStartNT() {
		char a = 'a';
		return a;
	}
//----------------------------------------------------------------------------------
//The getStartNT method is used in the event that the program needs to set a new 
//starting non terminal
//----------------------------------------------------------------------------------
	void setStartNT(char stNT) {

	}

}

