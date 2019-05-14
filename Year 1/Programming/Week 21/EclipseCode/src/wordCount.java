import java.io.*;
import java.util.*;

public class wordCount {

	public static void main(String[] args) {
		Scanner in = null;
		if(args.length != 1)
		{
			System.out.println("Specify a FileName");
			System.exit(0);
		}
		try
		{
			in = new Scanner(new File(args[0]));
		}
		catch(FileNotFoundException error)
		{
			System.out.println("Could not open file: " + args[0]);
		}
		
		if(in != null)
		{
			int wordCounter = 0;
			int totalWordLength = 0;
			float averageWordLength;
			
			while(in.hasNext())
			{
				String words = in.next();
				wordCounter++;
				totalWordLength = totalWordLength + words.length();
			}
			averageWordLength = (float)totalWordLength / (float)wordCounter;
			System.out.println("Total number of Words: " + wordCounter);
			System.out.println("Average length of Words: " + averageWordLength);
		}
	}

}
