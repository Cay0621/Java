package Notepad;

import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Notepad extends JFrame {

	/**
	 * @param args
	 */
	JTextArea jta = null;
	
	//菜单
	JMenuBar jmb = null;
	JMenu jFile = null;
	JMenuItem jFileNew = null;
	JMenuItem jFileOpen = null;
	JMenuItem jFileSave = null;
	JMenuItem jFileExit = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad().Init();
	}
	
	public void Init()
	{
		jFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jFileOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfo = new JFileChooser();
				
				jfo.showOpenDialog(null);
				jfo.setVisible(true);
				
				String filePath = jfo.getSelectedFile().getAbsolutePath();
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(filePath);
					br = new BufferedReader(fr);
					
					String str = "";
					while((str = br.readLine()) != null)
					{
						jta.append(str + "\r\n");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally
				{
					try {
						fr.close();
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		jFileSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileSave = new JFileChooser();
				fileSave.showSaveDialog(null);
				fileSave.setVisible(true);
				
				//获取保存文件的全路径
				String filePath = fileSave.getSelectedFile().getAbsolutePath();
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try {
					fw = new FileWriter(filePath);
					bw = new BufferedWriter(fw);
					
					String str = jta.getText();
					bw.write(str);
					//Thread.sleep(500);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally
				{
					try {
						bw.close();
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		jFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public Notepad()
	{
		jta = new JTextArea();
		
		jmb = new JMenuBar();
		jFile = new JMenu("文件(&F)");
		jFileNew = new JMenuItem("新建");
		jFileOpen = new JMenuItem("打开");
		jFileSave = new JMenuItem("保存");
		jFileExit = new JMenuItem("退出");
		jFile.add(jFileNew);
		jFile.add(jFileOpen);
		jFile.add(jFileSave);
		jFile.addSeparator();
		jFile.add(jFileExit);
		
		jmb.add(jFile);
		this.setJMenuBar(jmb);
		
		this.add(new JScrollPane(jta));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(400, 300));
		this.setLocation(400, 300);
		this.pack();
		this.setVisible(true);
		
	}

}
