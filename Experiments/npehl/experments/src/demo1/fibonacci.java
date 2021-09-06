package demo1;

import java.util.Scanner;

public class fibonacci
{
	public static void main(String[] args)
	{
		System.out.println("Enter how many numbers you want to see of the fibonacci sequece");
		System.out.println("NOTE: doesn't work after 47 numbers in b/c value exceeds int.MAX");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		printNumbers(num);
	}
	public static void printNumbers(int num)
	{
		int first = 0;
		int second = 1;
		int temp;
		System.out.println(first);
		System.out.println(second);
		for(int i=2; i<num; i++)
		{
			temp = first + second;
			System.out.println(temp);
			first = second;
			second = temp;
		}
	}
}
