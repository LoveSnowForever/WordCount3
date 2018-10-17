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
 * ��������������ȡ���������ļ�·�������������浽·����
 */
public class PrintfCount {

	CountWord cWord=new CountWord();
	WDUtil wdUtil=new WDUtil();
	int charNum=0;//�ַ�����Ŀ
	int wordNum=0;//���ʵ�
	int enterNum=0;//����

	
	/*
	 *commands �洢�����map����
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
		  String operation=mEntry.getKey();//��ȡ��������	
		  String path=mEntry.getValue();
		  File file=new File(path);
		  switch(operation)
		   {	   		
		   		case "-c":
		   		//�����ַ���
		   		{
		   			charNum=cWord.countChar(file);
		   			System.out.println("�ַ���Ϊ:"+charNum);
		   			break;
		   		}
	   
	   
		   		case "-w":
		   			//���㵥����
		   		{
		   			wordNum=cWord.countWord(file);
		   			System.out.println("������Ϊ:"+wordNum);
	   				break;
		   		}
	   		
		   		case "-l":
		   			//��������
		   		{
		   			enterNum=cWord.countEnter(file);
		   			System.out.println("����Ϊ:"+enterNum);
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
		   			new CountFrame();//��ʾGUI����
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
	   txt="�ַ��ĸ���Ϊ"+charNum+"\n���ʵĸ���Ϊ"+wordNum+"\n����Ϊ"+enterNum;
	   wdUtil.fileWrite(new File("result.txt"), txt);
	   
	}
	

}
