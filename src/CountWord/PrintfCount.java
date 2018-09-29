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
		   		//�����ַ���
		   		{
		   			charNum=cWord.countChar(path);
		   			System.out.println("�ַ���Ϊ:"+charNum);
		   			break;
		   		}
	   
	   
		   		case "-w":
		   			//���㵥����
		   		{
		   			wordNum=cWord.countWord(path);
		   			System.out.println("������Ϊ:"+wordNum);
	   				break;
		   		}
	   		
		   		case "-l":
		   			//��������
		   		{
		   			enterNum=cWord.countEnter(path);
		   			System.out.println("����Ϊ:"+enterNum);
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
	   txt="�ַ��ĸ���Ϊ"+charNum+"\n���ʵĸ���Ϊ"+wordNum+"\n����Ϊ"+enterNum;
	   wdUtil.fileWrite("result.txt", txt);
	   
	}
	

}
