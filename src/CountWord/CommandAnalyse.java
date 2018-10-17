package CountWord;

import java.util.HashMap;
import java.util.Map;

public class CommandAnalyse {
	//根据传入的String，分析出命令生成再Map中
    public static Map<String, String> commands=new HashMap<String,String>();
	
	public CommandAnalyse(String args)
	{
		String[] strings=args.split(" ");
		for(int i=0;i<strings.length;i++)
		{
			switch(strings[i])
			{
			    //统计字符数
				case "-c":
				{
					if(i<strings.length)
					{
						commands.put("-c", strings[i+1]);
					}
					break;
				}
				//统计单词数
				case "-w":
				{
					if(i<strings.length)
					{
						commands.put("-w", strings[i+1]);
					}
					break;
				}
				
				//统计行数
				case"-l":
				{
					if(i<strings.length)
					{
						commands.put("-l", strings[i+1]);
					}
					break;
				}
				
				case"-o":
				{
					if(i<strings.length)
					{
						commands.put("-o", strings[i+1]);
					}
					break;
				}
				
				case"-s":
				{
					if(i<strings.length)
					{
						commands.put("-s", strings[i+1]);
					}
				}
				case"-a":
				{
					if(i<strings.length)
					{
						commands.put("-s", strings[i+1]);
					}
					break;
				}
				case"-e":
				{
					if(i<strings.length)
					{
						commands.put("-s", strings[i+1]);
					}
					break;
				}
							
			}
		}
	}
	
	
	
	

}
