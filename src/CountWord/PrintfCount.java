package CountWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import java.util.Scanner;
import java.util.Set;

import GUI.CountFrame;
import Util.WDUtil;

/*
 * 根据输入的命令获取操作，和文件路径最后计算结果保存到路径中
 */
public class PrintfCount {

	CountWord cWord=new CountWord();
	WDUtil wdUtil=new WDUtil();
	int charNum=0;//字符的数目
	int wordNum=0;//单词的
	int enterNum=0;//行数

	
	/*
	 *commands 存储命令的map集合
	 */
	public void Print(Map<String, String>commands)
	{
	   String txt=null;	   	 
	   List<File>fileList=new ArrayList<File>();
	   Set<Map.Entry<String,String>> set=commands.entrySet();
	   Iterator<Map.Entry<String, String>>iterator=set.iterator();
	   while(iterator.hasNext())
	   {
		  Map.Entry<String, String>mEntry=iterator.next();
		  String operation=mEntry.getKey();//获取操作命令	
		  String path=mEntry.getValue();
		  File file=new File(path);
		  switch(operation)
		   {	   		
		   		case "-c":
		   		//计算字符数
		   		{
		   			charNum=cWord.countChar(file);
		   			System.out.println("字符数为:"+charNum);
		   			break;
		   		}
	   
	   
		   		case "-w":
		   			//计算单词数
		   		{
		   			wordNum=cWord.countWord(file);
		   			System.out.println("单词数为:"+wordNum);
	   				break;
		   		}
	   		
		   		case "-l":
		   			//计算行数
		   		{
		   			enterNum=cWord.countEnter(file);
		   			System.out.println("行数为:"+enterNum);
		   			break;
		   		}
	   		
		   		case "-o":
		   		{
		   			File resultFile=new File("result.txt");
		   			String result=wdUtil.fielRead(resultFile);
		   			wdUtil.fileWrite(file,result);
		   			break;
		   		}
		   		
		   		case"-x":
		   		{
		   			new CountFrame();//显示GUI界面
		   			break;
		   		}
		   		case "-s":
		   		{
		   			fileList=wdUtil.getAllFile(fileList, file);
		   			for(File file2:fileList)
		   			{
		   				charNum+=cWord.countChar(file2);
		   				wordNum+=cWord.countWord(file2);
		   				enterNum+=cWord.countEnter(file2);
		   				
		   			}
		   			System.out.println(charNum+" ,"+wordNum+" ,"+enterNum+" ,"+fileList.size());
		   			break;
		   		}
		   		case "-e":
		   		{
		   			File file2=new File(commands.get("-e"));
		   			wordNum=cWord.stopWord(file, file2);
		   			break;
		   		}
		   		 
		   		
		   		
	   			
	   		}
	   		
	   }
	   txt="字符的个数为"+charNum+"\n单词的个数为"+wordNum+"\n行数为"+enterNum;
	   wdUtil.fileWrite(new File("result.txt"), txt);
	   
	}
	

}
