import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;


public class SearchTest extends JFrame {

	/**
	 * @param args
	 */
	JPanel jp1,jp2;
	JLabel countryLabel,visitLabel;
	JComboBox countryComboBox;
	JList jlist;
	JScrollPane jsp;
	
	public SearchTest()
	{
		countryLabel = new JLabel("籍贯");
		visitLabel = new JLabel("喜欢的旅游点");
		
		String country[] = {"上海","北京","深圳"};
		countryComboBox = new JComboBox(country);
		
		String visit[] = {"九寨沟","峨眉山","故宫","长城","天安门"};
		jlist = new JList(visit);
		jlist.setVisibleRowCount(2);
		
		//将列表加入滚动列表框
		jsp = new JScrollPane(jlist);
		
		this.setLayout(new GridLayout(2,1));
		jp1 = new JPanel();
		jp1.add(countryLabel);
		jp1.add(countryComboBox);
		
		jp2 = new JPanel();
		jp2.add(visitLabel);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		
		
		this.setTitle("调查窗口测试");
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
		SearchTest st = new SearchTest();
	}

}
