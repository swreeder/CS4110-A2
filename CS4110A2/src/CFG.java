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
		boolean result = false;
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
		for(int i = 0; i<code.length;i++)
		{
			String prodNonTerm = code[i].substring(0, 1);
			String sNonTerminal = Character.toString(nonTerminal); 
			if(prodNonTerm.equals(sNonTerminal))
			{
				String prodTransformString = code[i].substring(3);
				StringBuffer temp = new StringBuffer(wkString);
				temp.replace(nonTerminalIndex,nonTerminalIndex+1,prodTransformString);
				newWkString = new String(temp);
				result = (processData(inString,newWkString));
			}
			if(prodNonTerm.equals(sNonTerminal) == false)
				result = false;
			if(result == true)
				break;
			//result = (processData(inString,newWkString));
		}
		return result;
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