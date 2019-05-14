//
// week 20 lab - simple string utility class
//
public class MyStringUtils
{
    public static String Reverse( String inputString )
    {
    	StringBuffer reverseString = new StringBuffer(inputString);
    	int length = inputString.length();
    	for(int i = 0; i < length; i++)
    	{
    		int iReverse = length - 1 - i;
    		reverseString.setCharAt(i, inputString.charAt(iReverse));
    	}
        // returns the reverse of a string.
        return new String(reverseString);
    }

    public static String AlphabeticalOnly( String inputString )
    {
    	String returnString = new String();
    	int length = inputString.length();
    	for(int i = 0; i < length; i++)
    	{
    		char c = inputString.charAt(i);
    		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			{
				returnString = returnString + c;
			}
    	}
        // return a string with all non-alphabetical characters removed.
        return returnString;
    }

    public static boolean IsPalindrome( String inputString )
    {
        // a palindrome is a non-empty string that reads the same forwards and
        // backwards, ignoring case and non-alphabetical characters. It must
		// contain at least one alphabetical character.
		return false;
    }
}

