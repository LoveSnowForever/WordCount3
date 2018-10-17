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
 * @author ��buff
 *�ַ�ͳ��GUI
 */
public class CountFrame extends JFrame implements ActionListener {
	
	
	JPanel charJpanel=new JPanel();//�ַ�������
	 JPanel wordJpanel=new JPanel();//����������
	 JPanel enterJpanel=new JPanel();//��������
	 
	 JLabel charLabel=new JLabel("�ַ���");//��ǩ
	 JLabel wordLabel=new JLabel("������");
	 JLabel enterLabel=new JLabel("�� ��");
	 
	 JTextField charJText=new JTextField(10);//text
	 JTextField wordJText=new JTextField(10);
	 JTextField enterJText=new JTextField(10);
	 
	 JButton chooseFile=new JButton("ѡ���ļ�");
	
	 
	 public CountFrame()
	 {
		 charJpanel.add(charLabel);//��ӱ�ǩ
		 charJpanel.add(charJText);//���text
		 
		 wordJpanel.add(wordLabel);
		 wordJpanel.add(wordJText);
		 
		 enterJpanel.add(enterLabel);
		 enterJpanel.add(enterJText);
		 
		 //����JFrame
		 this.add(charJpanel);
		 this.add(wordJpanel);
		 this.add(enterJpanel);
		 this.add(chooseFile);
		 chooseFile.addActionListener(this);
		 this.setLayout(new GridLayout(4,1));
		 this.setTitle("�ַ�ͳ��");          
	     this.setSize(300,200);         
	     this.setLocation(400, 200);           
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���õ��رմ���ʱ����֤JVMҲ�˳� 
	     this.setVisible(true);  
	     this.setResizable(true);  

	 }
	 

	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		JFileChooser jfc=new JFileChooser();

		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

		jfc.showDialog(new JLabel(), "ѡ��");

		File file=jfc.getSelectedFile();

		if(file.isDirectory()){

			JOptionPane.showMessageDialog(null, "ѡ����ļ���Ч", "��������",JOptionPane.WARNING_MESSAGE);  
		}else if(file.isFile()){
			String path=file.getAbsolutePath();//��ȡ�ļ��ľ���·��
			File files=new File(path);
            CountWord countWord=new CountWord();
            int charCount=countWord.countChar(file);//�����ַ���
			int wordCount=countWord.countWord(file);//���㵥��
			int enterCount=countWord.countEnter(file);//��������
			
			charJText.setText(String.valueOf(charCount));//�ı�����ʾֵ
			wordJText.setText(String.valueOf(wordCount));
			enterJText.setText(String.valueOf(enterCount));

		}

		

		

	}

 

}



