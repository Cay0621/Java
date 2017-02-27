import javax.swing.*;

public class JSplitPaneTest extends JFrame {

	/**
	 * @param args
	 */
	JSplitPane jsp;
	JLabel imgLabel;
	JList jlist;
	
	public JSplitPaneTest()
	{
		String words[] = {"hello","world","cay","amy"};
		imgLabel = new JLabel(new ImageIcon("images/bkimage.jpg"));
		
		jlist = new JList(words);
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist, imgLabel);
		jsp.setOneTouchExpandable(true);
		
		this.add(jsp);
		
		this.setTitle("拆分窗口测试");
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
		JSplitPaneTest jspt = new JSplitPaneTest();
	}

}
