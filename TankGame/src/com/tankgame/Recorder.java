/*
 * 设置数据记录
 */
package com.tankgame;
import java.io.*;
import java.util.*;

public class Recorder {
	private static int enNum = Constant.ENEMYPERCOUNT;
	private static int life = Constant.HEROLIFE;
	private static int allDeadEnemy = 0;
	
	private static FileWriter fw = null;
	private static BufferedWriter bw = null;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	
	private static Vector<EnemyTank> ets = new Vector<EnemyTank>();
	private static Vector<TankNode> tankNodes = new Vector<TankNode>();
	
	public static Vector<EnemyTank> getEts() {
		return ets;
	}
	public static void setEts(Vector<EnemyTank> ets) {
		Recorder.ets = ets;
	}
	public static int getAllDeadEnemy() {
		return allDeadEnemy;
	}
	public static void setAllDeadEnemy(int allDeadEnemy) {
		Recorder.allDeadEnemy = allDeadEnemy;
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getLife() {
		return life;
	}
	public static void setLife(int life) {
		Recorder.life = life;
	}
	public static void reduceEnemyCount()
	{
		allDeadEnemy++;
		enNum--;
	}
	public static void reduceLift()
	{
		life--;
	}
	
	//保存击毁敌人的总数和敌人的坦克的坐标和方向
	public static void keepRecorder()
	{
		try {
			fw = new FileWriter("KeepRecorder.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(allDeadEnemy + "\r\n");
			
			//保存当前活着的坦克的坐标和方向
			for(int i = 0;i < ets.size();++i)
			{
				//取出一个坦克
				EnemyTank et = ets.get(i);
				if(et.isAlive)
				{
					String record = et.getX() + " " + et.getY() + " " + et.getDirect();
					//写入文件中
					bw.write(record + "\r\n");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//游戏开始时读取记录
	public static void readRecorder()
	{
		try {
			fr = new FileReader("SaveRecorder.txt");
			br = new BufferedReader(fr);
			String n = br.readLine();
			allDeadEnemy = Integer.parseInt(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//单单只是保存击毁敌人坦克的总数
	public static void saveRecorder()
	{
		try {
			fw = new FileWriter("SaveRecorder.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(allDeadEnemy + "\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//完成读取Nodes
	public static Vector<TankNode> getRecorder()
	{
		try {
			fr = new FileReader("KeepRecorder.txt");
			br = new BufferedReader(fr);
			allDeadEnemy = Integer.parseInt(br.readLine());
			String n = "";
			while((n = br.readLine()) != null)
			{
				String[] s = n.split(" ");
				TankNode node = new TankNode(
						Integer.parseInt(s[0]),
						Integer.parseInt(s[1]),
						Integer.parseInt(s[2]));
				tankNodes.add(node);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return tankNodes;
	}
}
