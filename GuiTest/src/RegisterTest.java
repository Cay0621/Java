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
		sportsLabel = new JLabel("你喜欢的运动");
		sexLabel = new JLabel("你的性别");
		swimCheckBox = new JCheckBox("游泳");
		tennisCheckBox = new JCheckBox("网球");
		footballCheckBox = new JCheckBox("足球");
		maleRadioBtn = new JRadioButton("男");
		femaleRadioBtn = new JRadioButton("女");
		okBtn = new JButton("注册");
		cancelBtn = new JButton("取消");
		
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
		
		this.setTitle("注册窗口测试");
		this.setVisible(true);
		
		//使点击关闭按钮后退出窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 150);
		
		//禁止用户改变窗口大小
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterTest rt = new RegisterTest();
	}

}
