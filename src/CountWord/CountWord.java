package CountWord;

import Util.WDUtil;

public class CountWord {

	WDUtil util = new WDUtil();// ��д�ļ��Ĺ��߶���

	/*
	 * path �ļ���·�� �����ļ���������
	 */
	public int countChar(String path) {
		int charNum = 0;

		String words = util.fielRead(path);
		charNum = words.length();
		return charNum;
	}

	/*
	 * path �ļ���λ�� �����ļ��пո����Ŀ
	 */

	public int countWord(String path) {
		int wordNum = 0;
		String words = util.fielRead(path);
		for (int i = 0; i < words.length() - 1; i++)// ���һ����ĸ���⿼��
		{
			if (words.charAt(i) == ' ' || words.charAt(i) == ';' || words.charAt(i) == ',' || words.charAt(i) == '.')// ���ֿո񶺺ž�ŷֺŶ���һ������
			{
				wordNum++;
			}
		}
		wordNum++;// ���һ��������ʲô��ĸ��β������������1

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