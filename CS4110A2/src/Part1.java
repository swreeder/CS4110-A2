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
//The class Part1 is the driver class. The main method accepts input from the 
//command line and tests this input to see if it is a word in the language 
//described in the main header comments
//--------------------------------------------------------------------------------
// Java program to read data of various types using Scanner class.
import java.util.Scanner;
public class Part1 {

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
	


}//end class Part1