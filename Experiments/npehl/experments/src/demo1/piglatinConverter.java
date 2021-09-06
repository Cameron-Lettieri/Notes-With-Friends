package demo1;

import java.util.Scanner;

public class piglatinConverter
{
	public static void main(String[] args)
	{
		System.out.println("Enter in word to convert to piglatin");
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		System.out.println(convert(word));
	}
	public static String convert(String word)
	{
		String vowels = "AEIOUaeuio";
		for(int i = 0; i<vowels.length(); i++)
		{
			if(word.charAt(0) == vowels.charAt(i))
			{
				word = word + "way";
				return word;
			}
		}
		for(int i = 0; i<vowels.length(); i++)
		{
			if(word.charAt(1) == vowels.charAt(i))
			{
				char first = word.charAt(0);
				word = word.substring(1);
				word = word + first + "ay";
				return word;
			}
		}
		String firstTwo = word.substring(0,2);
		word = word.substring(2) + firstTwo + "ay";
		return word;
		
	}
}
