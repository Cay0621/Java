import java.awt.GridLayout;

import javax.swing.*;


public class LoginTest extends JFrame {

	/**
	 * @param args
	 */
	JLabel nameLabel,pwdLabel;
	JButton okBtn,cancelBtn;
	JTextField nameField;
	JPasswordField pwdField;
	
	JPanel jp1,jp2,jp3;
	
	public LoginTest()
	{
		nameLabel = new JLabel("�û���");
		pwdLabel = new JLabel("��    ��");
		okBtn = new JButton("ȷ��");
		cancelBtn = new JButton("ȡ��");
		nameField = new JTextField(10);
		pwdField = new JPasswordField(10);
		
		jp1 = new JPanel();
		jp1.add(nameLabel);
		jp1.add(nameField);
		
		jp2 = new JPanel();
		jp2.add(pwdLabel);
		jp2.add(pwdField);
		
		jp3 = new JPanel();
		jp3.add(okBtn);
		jp3.add(cancelBtn);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setLayout(new GridLayout(3,1));
		
		this.setTitle("��¼���ڲ���");
		this.setVisible(true);
		
		//ʹ����رհ�ť���˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 150);
		
		//��ֹ�û��ı䴰�ڴ�С
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginTest login = new LoginTest();
	}

}
