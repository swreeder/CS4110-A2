//		Samuel Reeder
//		CS 4110 - 1:39pm
//		Assignment #2
//		Dr. Rague
//		Due: 3/1/2018
//		Version: 1.0
//--------------------------------------------------------------------------------
//The program can recognize all words in the language defined by the following CFG.
//A CFG for alphabet {a,b} that recognizes the language consisting of all strings 
//that contain exactly one b, have 2N a's (N >= 0, N is an integer) before the b, 
//and 2N+1 a's after the b.
//---------------------------------------------------------------------------------


//--------------------------------------------------------------------------------
//The class Part A is the driver class. The mian method accepts input from the 
//command line and tests this input to see if it is a word in the language 
//described in the main header comments
//--------------------------------------------------------------------------------
// Java program to read data of various types using Scanner class.
import java.util.Scanner;
public class PartC {

	public static void main(String[] args) {
		//this string array holds the production rules that satisfy the language 
		//described in the main header.
		String[] prodRules = {"S=>b",
							  "S=>ba",
							  "S=>XbaY",
							  "X=>aa",
							  "X=>aaX",
							  "Y=>aaa",
							  "Y=>aaaY"};
		
		CFG cfg = new CFG(prodRules);
		char intNT = cfg.getStartNT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Test String");
		String test = sc.nextLine();
		String sIntNT = Character.toString(intNT);
		boolean isMember = cfg.processData(test, "XbaX");
		//boolean isMember = cfg.processData(args[0], sIntNT);
		System.out.println("  Accept String?  " + isMember);

	}
	


}//end class PartA
