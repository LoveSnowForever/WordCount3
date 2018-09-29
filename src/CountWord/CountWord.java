package CountWord;

import Util.WDUtil;

public class CountWord {

	WDUtil util = new WDUtil();// 读写文件的工具对象

	/*
	 * path 文件的路径 返回文件的总字数
	 */
	public int countChar(String path) {
		int charNum = 0;

		String words = util.fielRead(path);
		charNum = words.length();
		return charNum;
	}

	/*
	 * path 文件的位置 返回文件中空格的数目
	 */

	public int countWord(String path) {
		int wordNum = 0;
		String words = util.fielRead(path);
		for (int i = 0; i < words.length() - 1; i++)// 最后一个字母特殊考虑
		{
			if (words.charAt(i) == ' ' || words.charAt(i) == ';' || words.charAt(i) == ',' || words.charAt(i) == '.')// 出现空格逗号句号分号都算一个单词
			{
				wordNum++;
			}
		}
		wordNum++;// 最后一个不管是什么字母结尾，单词数都加1

		return wordNum;
	}

	public int countEnter(String path) {
		int wordNum = 0;
		String words = util.fielRead(path);
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) == '\n') {
				wordNum++;
			}
		}
		return wordNum + 1;
	}
}