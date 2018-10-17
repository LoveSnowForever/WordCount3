package CountWord;

import java.io.File;

import Util.WDUtil;

public class CountWord {

	WDUtil util = new WDUtil();// 读写文件的工具对象

	/*
	 * path 文件的路径 返回文件的总字数
	 */
	public int countChar(File file) {
		int charNum = 0;
      
		String words = util.fielRead(file);
		charNum = words.length();
		return charNum;
	}

	/*
	 * path 文件的位置 返回文件中空格的数目
	 */

	public int countWord(File file) {
		
		int wordNum = 0;
		String words = util.fielRead(file);
		for (int i = 0; i < words.length() - 1; i++)// 最后一个字母特殊考虑
		{
			if (words.charAt(i) == ' ' ||  words.charAt(i) == ',' )// 出现空格逗号都算一个单词
			{
				wordNum++;
			}
		}
		wordNum++;// 最后一个不管是什么字母结尾，单词数都加1

		return wordNum;
	}

	public int countEnter(File file) {
		int wordNum = 0;
		String words = util.fielRead(file);
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) == '\n') {
				wordNum++;
			}
		}
		return wordNum + 1;
	}
	
	public int countCommentLine(File file)
	{
		int commentNum=0;
		return commentNum;
		
	}
	
	public int stopWord(File file1,File file2)
	{
		
		String[] words1=util.fielRead(file1).split(",");
		String[] words2=util.fielRead(file2).split(",");
		int wordCount=words2.length;
		for(String word1:words1)
		{
			for(String word2:words2)
			{
				if(word2.equals(word1))
				{
					wordCount--;
				}
			}
		}
		return wordCount;
	}
}