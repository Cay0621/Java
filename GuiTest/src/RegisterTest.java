import java.awt.GridLayout;

import javax.swing.*;

public class RegisterTest extends JFrame {

	/**
	 * @param args
	 */
	JLabel sportsLabel,sexLabel;
	JCheckBox swimCheckBox,tennisCheckBox,footballCheckBox;
	JRadioButton maleRadioBtn,femaleRadioBtn;
	JButton okBtn,cancelBtn;
	JPanel jp1,jp2,jp3;
	
	public RegisterTest()
	{
		sportsLabel = new JLabel("��ϲ�����˶�");
		sexLabel = new JLabel("����Ա�");
		swimCheckBox = new JCheckBox("��Ӿ");
		tennisCheckBox = new JCheckBox("����");
		footballCheckBox = new JCheckBox("����");
		maleRadioBtn = new JRadioButton("��");
		femaleRadioBtn = new JRadioButton("Ů");
		okBtn = new JButton("ע��");
		cancelBtn = new JButton("ȡ��");
		
		jp1 = new JPanel();
		jp1.add(sportsLabel);
		jp1.add(swimCheckBox);
		jp1.add(tennisCheckBox);
		jp1.add(footballCheckBox);
		
		jp2 = new JPanel();
		ButtonGroup gp = new ButtonGroup();
		gp.add(maleRadioBtn);
		gp.add(femaleRadioBtn);
		jp2.add(sexLabel);
		jp2.add(maleRadioBtn);
		jp2.add(femaleRadioBtn);
		
		jp3 = new JPanel();
		jp3.add(okBtn);
		jp3.add(cancelBtn);
		
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("ע�ᴰ�ڲ���");
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
		RegisterTest rt = new RegisterTest();
	}

}
