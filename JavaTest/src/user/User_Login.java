package user;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class User_Login extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel name_label,password_label;
	private JTextField name_text,password_text;
	private JButton login,cancel,register;
	private String Name=null,Password=null;
	public User_Login()
	{
		super("小型超市管理系统");
		this.setSize(430,520);
		this.setLocation(500,300);
		//this.setResizable(false);

		this.setBackground(Color.gray);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBak(); // 调用背景方法
		JPanel jp = new JPanel(); // 创建个JPanel
		//jp.setSize(430,520);
		jp.setLayout(new GridLayout(4,1));
		//jp.setBounds(500, 300, 430, 520);
		jp.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了

		
		
		name_label=new JLabel("用户名");
		password_label=new JLabel("密码");
		name_text=new JTextField("Bob",10);
		password_text=new JPasswordField("",10);
		login=new JButton("登陆");
		cancel=new JButton("取消");
		register=new JButton("注册");
		login.addActionListener(this);
		cancel.addActionListener(this);
		register.addActionListener(this);
		
		JPanel jp1=new JPanel();
		//jp1.setBounds(500, 300,430,120);
		jp1.setLayout(new FlowLayout());
		jp1.add(name_label);
		jp1.add(name_text);
		JPanel jp11=new JPanel();
		//jp11.setSize(420,100);
		jp11.setLayout(new FlowLayout());
		jp11.add(password_label);
		jp11.add(password_text);
		JPanel jp2=new JPanel();
		//jp2.setSize(420,100);
		jp2.setLayout(new FlowLayout());
		jp2.add(login);
		jp2.add(cancel);
		jp2.add(register);
		
		JPanel jpp=new JPanel();
		jpp.setLocation(420, 350);
		jpp.setOpaque(false);
		
		jp.add(jpp);
        jp.add(jp1);
        jp.add(jp11);
        jp.add(jp2);
        this.add(jp);
        
		this.setVisible(true);
	}
	public static void main(String[] args){
		new User_Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			System.out.println("登陆成功");
		}
		if(e.getSource()==cancel){
			System.out.println("取消登陆");
		}
		if(e.getSource()==register){
			System.out.println("准备注册");
			Register();
		}
	}

	public void Register(){
		
		JPanel jpanel1=new JPanel();
		jpanel1.setLayout(new GridLayout(4,1));
		jpanel1.add(new JLabel("用户名"));
		JTextField register_username=new JTextField("Howard");
		jpanel1.add(register_username);
		jpanel1.add(new JLabel("密码"));
		JTextField register_password=new JPasswordField();
		jpanel1.add(register_password);
		
		String but[] = { "确定", "取消" };
		int go = JOptionPane.showOptionDialog(null, jpanel1, "填写注册信息", JOptionPane.YES_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, but, but[0]);

		while(go==0){
			String name=register_username.getText();
			String password=register_password.getText();
			if(name.length()<1||password.length()<1){
				JOptionPane.showMessageDialog(null,"用户名或密码不能为空,请重新输入");
				go = JOptionPane.showOptionDialog(null, jpanel1, "填写注册信息", JOptionPane.YES_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, but, but[0]);
			}
			else {
				Name=name;
				Password=password;
				System.out.println(Name+" "+Password);
				JOptionPane.showMessageDialog(null,"注册数据成功");
				break;
			}
		}

	}
	
	public void setBak() {
		((JPanel) this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("Images\\mmm.jpg");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
}