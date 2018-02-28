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
//The class Part A is the driver class. The mian method accepts input from the 
//command line and tests this input to see if it is a word in the language 
//described in the main header comments
//--------------------------------------------------------------------------------
// Java program to read data of various types using Scanner class.
import java.util.Scanner;
public class PartA {

	public static void main(String[] args) {
		//this string array holds the production rules that satisfy the language 
		//described in the main header.
		String[] prodRules = {"S=>ab",
							  "S=>aaSbb"};
		
		CFG cfg = new CFG(prodRules);
		char intNT = cfg.getStartNT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Test String");
		String test = sc.nextLine();
		String sIntNT = Character.toString(intNT);
		boolean isMember = cfg.processData(test, sIntNT);
		//boolean isMember = cfg.processData(args[0], sIntNT);
		System.out.println("  Accept String?  " + isMember);

	}
	


}//end class PartA

//--------------------------------------------------------------------------------
//The class CFG holds the logic needed to process a CFG. The most important method 
//is processData. This method is the engine that will test target strings to see if
//they are members of the CFG defined in the main header.
//--------------------------------------------------------------------------------
class CFG
{	
	//Instance variables
	String[] code;			//production rules as program code
	char     startNT;		//starting nonterminal
	//Constructor
		CFG(String[] c){
			code = c; 
		}

	//-------------------------------------------------------------------------------
	//The processData method accepts a target test string and then uses production 
	//rules for the above defined CFG to determine if the target string is in the 
	//language. This method is recursive.
	//-------------------------------------------------------------------------------
	public boolean processData(String inString, String wkString) {
		//holds next non Terminal
		char nonTerminal='\0';
		int nonTerminalIndex = 0;
		boolean x = false;
		//base cases
		if(inString.equals(wkString))  //is the target string the same and the work string?
			return true;
		
		if(wkString.length() > inString.length()) //is the work string larger than the target string?
			return false;
		
		boolean hasNonTermianl = true;
		for(int i=0;i<wkString.length();i++) //are there any more non terminals in the work string?
		{
			char letter = wkString.charAt(i);
			if(Character.isUpperCase(letter) == true)
			{
				nonTerminal = letter;
				nonTerminalIndex = i;
				hasNonTermianl = true;
				break;
			}
			else
			{
				hasNonTermianl = false;
			}
				
		}
		
		if(hasNonTermianl == false)
			return false;
		//if all the other tests are failed then create a new working string and make a recursive call for each production rule that matches the first non terminal in the work string.
		String newWkString="";
		for(String rule : code)
		{
			String prodNonTerm = rule.substring(0, 1);
			String sNonTerminal = Character.toString(nonTerminal); 
			if(prodNonTerm.equals(sNonTerminal))
			{
				String prodTransformString = rule.substring(3);
				StringBuffer temp = new StringBuffer(wkString);
				temp.replace(nonTerminalIndex,nonTerminalIndex+1,prodTransformString);
				newWkString = new String(temp);
			}
			if(x == true)
				break;
			x = (processData(inString,newWkString));
		}
		return x;
	}
		
	//----------------------------------------------------------------------------------
	//The getStartNT method is used in the constructor to acquire the value of the 
	//starting non terminal from the production rules array. It is assumed that the
	//first production rule in the array is also the initial production rule for the CFG
	//----------------------------------------------------------------------------------
	char getStartNT() {
		char a = code[0].substring(0, 1).charAt(0);
		return a;
	}
	//----------------------------------------------------------------------------------
	//The getStartNT method is used in the event that the program needs to set a new 
	//starting non terminal
	//----------------------------------------------------------------------------------
	void setStartNT(char stNT) {

	}
	
}//End class CFG



