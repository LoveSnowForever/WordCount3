package CountWord;

import java.util.Scanner;

import Util.WDUtil;

public class PrintfCount {

	CountWord cWord=new CountWord();
	WDUtil wdUtil=new WDUtil();
	int charNum=0;
	int wordNum=0;
	int enterNum=0;

	
	
	public void Print(String[] args)
	{
	   String txt=null;
	   String path=args[args.length-1];
	   for(int i=0;i<args.length;i++)
	   {
		   String operation=args[i];
		   switch(operation)
		   {
		   		case "-c":
		   		//计算字符数
		   		{
		   			charNum=cWord.countChar(path);
		   			System.out.println("字符数为:"+charNum);
		   			break;
		   		}
	   
	   
		   		case "-w":
		   			//计算单词数
		   		{
		   			wordNum=cWord.countWord(path);
		   			System.out.println("单词数为:"+wordNum);
	   				break;
		   		}
	   		
		   		case "-l":
		   			//计算行数
		   		{
		   			enterNum=cWord.countEnter(path);
		   			System.out.println("行数为:"+enterNum);
		   			break;
		   		}
	   		
		   		case "-o":
		   		{
		   			String result=wdUtil.fielRead("result.txt");
		   			wdUtil.fileWrite(args[i+1],result);
		   			break;
		   		}
	   			
	   		}
	   		
	   }
	   txt="字符的个数为"+charNum+"\n单词的个数为"+wordNum+"\n行数为"+enterNum;
	   wdUtil.fileWrite("result.txt", txt);
	   
	}
	

}
