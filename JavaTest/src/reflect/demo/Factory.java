package reflect.demo;

import java.io.IOException;
import java.util.Properties;
//import java.util.ResourceBundle;


//提供工厂类
public class Factory {
	static String singable_className;
	static String danceable_className;
	static String performable_className;
	
	static{
		//两种方式获得配置文件信息
		
		//读取配置文件，获得完整类名
//		singable_className = ResourceBundle.getBundle("party").getString("Singable");
//		danceable_className = ResourceBundle.getBundle("party").getString("Danceable");
//		performable_className = ResourceBundle.getBundle("party").getString("Performable");
		
		Properties props = new Properties();
		try {
			props.load(Factory.class.getClassLoader().getResourceAsStream("party.properties"));
			singable_className = props.getProperty("Singable"); 
			danceable_className = props.getProperty("Danceable"); 
			performable_className = props.getProperty("Performable"); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static Singable getSinger(){
		try {
			Class c = Class.forName(singable_className);
			Singable singer = (Singable) c.newInstance();
			return singer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("演唱者出现问题了...");
		} 
		
	}
	
	@SuppressWarnings("rawtypes")
	public static Danceable getDancer(){
		try {
			Class c = Class.forName(danceable_className);
			Danceable dancer = (Danceable) c.newInstance();
			return dancer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("跳舞者出现问题了...");
		} 
	}
	
	@SuppressWarnings("rawtypes")
	public static Performable getPerformer(){
		try {
			Class c = Class.forName(performable_className);
			Performable perfomer = (Performable) c.newInstance();
			return perfomer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("表演者问题了...");
		} 
	}
}
