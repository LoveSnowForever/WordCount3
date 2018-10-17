package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CountWord.CountWord;

/**
 * 
 * @author 洪buff
 *字符统计GUI
 */
public class CountFrame extends JFrame implements ActionListener {
	
	
	JPanel charJpanel=new JPanel();//字符数容器
	 JPanel wordJpanel=new JPanel();//单词数容器
	 JPanel enterJpanel=new JPanel();//行数容器
	 
	 JLabel charLabel=new JLabel("字符数");//标签
	 JLabel wordLabel=new JLabel("单词数");
	 JLabel enterLabel=new JLabel("行 数");
	 
	 JTextField charJText=new JTextField(10);//text
	 JTextField wordJText=new JTextField(10);
	 JTextField enterJText=new JTextField(10);
	 
	 JButton chooseFile=new JButton("选择文件");
	
	 
	 public CountFrame()
	 {
		 charJpanel.add(charLabel);//添加标签
		 charJpanel.add(charJText);//添加text
		 
		 wordJpanel.add(wordLabel);
		 wordJpanel.add(wordJText);
		 
		 enterJpanel.add(enterLabel);
		 enterJpanel.add(enterJText);
		 
		 //加入JFrame
		 this.add(charJpanel);
		 this.add(wordJpanel);
		 this.add(enterJpanel);
		 this.add(chooseFile);
		 chooseFile.addActionListener(this);
		 this.setLayout(new GridLayout(4,1));
		 this.setTitle("字符统计");          
	     this.setSize(300,200);         
	     this.setLocation(400, 200);           
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出 
	     this.setVisible(true);  
	     this.setResizable(true);  

	 }
	 

	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		JFileChooser jfc=new JFileChooser();

		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

		jfc.showDialog(new JLabel(), "选择");

		File file=jfc.getSelectedFile();

		if(file.isDirectory()){

			JOptionPane.showMessageDialog(null, "选择的文件无效", "操作错误",JOptionPane.WARNING_MESSAGE);  
		}else if(file.isFile()){
			String path=file.getAbsolutePath();//获取文件的绝对路径
			File files=new File(path);
            CountWord countWord=new CountWord();
            int charCount=countWord.countChar(file);//计算字符数
			int wordCount=countWord.countWord(file);//计算单词
			int enterCount=countWord.countEnter(file);//计算行数
			
			charJText.setText(String.valueOf(charCount));//文本框显示值
			wordJText.setText(String.valueOf(wordCount));
			enterJText.setText(String.valueOf(enterCount));

		}

		

		

	}

 

}



