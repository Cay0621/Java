import java.awt.BorderLayout;

import javax.swing.*;

public class ChatTest extends JFrame {

	/**
	 * @param args
	 */
	JTextArea jMessageArea;
	JTextField jInputArea;
	JButton sendBtn;
	JPanel jp1;
	
	public ChatTest()
	{
		jMessageArea = new JTextArea();
		
		jInputArea = new JTextField(10);
		sendBtn = new JButton("����");
		
		jp1 = new JPanel();
		jp1.add(jInputArea);
		jp1.add(sendBtn);
		
		this.add(jMessageArea);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setIconImage(new ImageIcon("images/logo1.png").getImage());
		
		this.setTitle("ע�ᴰ�ڲ���");
		this.setVisible(true);
		
		//ʹ����رհ�ť���˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		//��ֹ�û��ı䴰�ڴ�С
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatTest ct = new ChatTest();
	}

}
