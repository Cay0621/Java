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
		sendBtn = new JButton("发送");
		
		jp1 = new JPanel();
		jp1.add(jInputArea);
		jp1.add(sendBtn);
		
		this.add(jMessageArea);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setIconImage(new ImageIcon("images/logo1.png").getImage());
		
		this.setTitle("注册窗口测试");
		this.setVisible(true);
		
		//使点击关闭按钮后退出窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		//禁止用户改变窗口大小
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatTest ct = new ChatTest();
	}

}
