import java.util.Scanner;

import CountWord.*;
import Util.*;

public class Client {
	
	public static void main(String[] args)
	{
		PrintfCount printfCount=new PrintfCount();
		//printfCount.Print(args);exe������ô˷���
		
		Scanner scanner=new Scanner(System.in);
		String commands=scanner.nextLine();
		CommandAnalyse commandAnalyse=new CommandAnalyse(commands);
		
		printfCount.Print(commandAnalyse.commands);
		
		
	}

}
