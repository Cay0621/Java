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
		countryLabel = new JLabel("����");
		visitLabel = new JLabel("ϲ�������ε�");
		
		String country[] = {"�Ϻ�","����","����"};
		countryComboBox = new JComboBox(country);
		
		String visit[] = {"��կ��","��üɽ","�ʹ�","����","�찲��"};
		jlist = new JList(visit);
		jlist.setVisibleRowCount(2);
		
		//���б��������б��
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
		
		
		this.setTitle("���鴰�ڲ���");
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
		SearchTest st = new SearchTest();
	}

}
