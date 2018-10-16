import java.util.Scanner;

import CountWord.*;
import Util.*;

public class Client {
	
	public static void main(String[] args)
	{
		PrintfCount printfCount=new PrintfCount();
		//printfCount.Print(args);exe程序调用此方法
		
		Scanner scanner=new Scanner(System.in);
		String commands=scanner.nextLine();
		String[]command =commands.split(" ");
		printfCount.Print(command);
		
		
	}

}
