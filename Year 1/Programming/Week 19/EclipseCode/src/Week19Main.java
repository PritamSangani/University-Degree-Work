public class Week19Main
{
    static void TestReverse( String input, String expected )
    {
        String result = MyStringUtils.Reverse(input);
        boolean test = result.equals(expected);
        if ( !test )
            System.out.println("TestReverse failed: expected \""+expected+"\" got \""+result+"\"");
        else
            System.out.println("TestReverse passed!");
    }

    static void TestAlphaOnly( String input, String  expected )
    {
        String result = MyStringUtils.AlphabeticalOnly(input);
        boolean test = result.equals(expected);
        if ( !test )
            System.out.println("TestAlphaOnly failed: expected \""+expected+"\" got \""+result+"\"");
        else
            System.out.println("TestAlphaOnly passed!");
    }

    static void TestPalindrome( String input, boolean expected )
    {
        boolean result = MyStringUtils.IsPalindrome( input );
        boolean test = result == expected;
        if ( !test )
            System.out.println("TestPalindrome failed: expected "+expected+" got "+result);
        else
            System.out.println("TestPalindrome passed!");

    }

    public static void main( String args[] )
    {
        TestReverse( "abdef", "fedba");
        TestReverse( "", "" );
        TestReverse("x", "x");
        TestReverse("#~'~","~'~#");

        TestAlphaOnly("!£$$%$","");
        TestAlphaOnly("","");
        TestAlphaOnly("qwerty","qwerty");
		TestAlphaOnly("AZaz@[`{","AZaz");

        TestPalindrome("Madam, I'm Adam", true);
        TestPalindrome("addbda", false );
        TestPalindrome("", false);
        TestPalindrome("Dammit, I'm mad", true);
    }
}
