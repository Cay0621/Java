package JDBC_3.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtils {
	
	private final static String ELEMENT_JDBC = "jdbc";
	private final static String ELEMENT_MYSQL = "mysql";
	private final static String ELEMENT_ORACLE = "oracle";
	private final static String ELEMENT_URL = "url";
	private final static String ELEMENT_DRIVER = "driver";
	private final static String ELEMENT_USERNAME = "username";
	private final static String ELEMENT_PASSWORD = "password";
	private final static String ATTRIBUTE_USER = "user";
	
	/***
	 * 解析xml文件，将配置的所有数据连接返回
	 * @param input	:
	 * 
	 * 因为要使用DOM去解析xml文件，那么一定要通过输入流去获取xml文件的数据
	 * 无论文件来自网络还是本地文件，我们在程序中都是通过输入流的形式去读取的
	 * 
	 * @return
	 */
	public static List<DBInfo> xmlToDBInfo(InputStream input){
		/**
		 * 我们使用DOM工具来自DOM4J非常流行的用于解析xml的DOM工具
		 * 
		 * 解析步骤：
		 * 1、创建用于解析xml文件的读取器SAXReader
		 * 2、使用SAXReader读取指定的输入流来解析xml文件
		 * 3、第2步的方法返回一个Document对象，描述整个文档，通过该文档对象获取跟标记Root
		 * 4、根据树结构，逐一解析
		 */
		
		//1、
		//dom4j包：dom4j-1.6.1.jar
		SAXReader reader = new SAXReader();
		
		/**
		 * 解析xml文件前先调用下列方法，该方法默认值为false
		 * 设置为true的作用是检查xml的合法性，验证DTD(Document Type Definition)
		 */
		
		//如果oracle不写user属性，如果setValidation(true)则会报错，提示oracle的user属性未设置
		//reader.setValidation(true);
		
		//2、
		Document document;//org.dom4j.Document
		try {
			document = reader.read(input);//读取并解析文件
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("数据读取错误！",e);
		}
		
		//3、获取根标记
		Element root = document.getRootElement();//org.dom4j.Element
		/**
		 * root.getName();//获取当前标签的名字，这里应该是jdbc 
		 */
		if(!ELEMENT_JDBC.equals(root.getName())){
			throw new RuntimeException("数据格式错误，根标签应该为: " + ELEMENT_JDBC);
		}
		
		//4、
		/**
		 * elements():该方法获取root元素下的所有子元素，以集合的形式返回
		 * 	以本xml为例的话，则返回"mysql"和"oracle"下的所有子元素的集合
		 * 
		 * element(String name):获取指定名字的元素
		 * 	假设name="mysql",则返回name为mysql的其中一个元素的集合（如果是多个，也返回其中一个）
		 * 	
		 * elements(String name):获取指定名字的所有子元素
		 *	假设name="mysql"，则返回name为mysql的所有子元素的集合
		 */
		List<DBInfo> infos = new ArrayList<DBInfo>();
		List<Element> childElements = root.elements();
		for (Element ele : childElements) {
			DBInfo info = EleToDBInfo(ele);
			infos.add(info);
		}
		return infos;
	}
	
	public static DBInfo EleToDBInfo(Element element){
		DBInfo info = new DBInfo();
		
		String url = element.elementText(ELEMENT_URL);
		String driver = element.elementText(ELEMENT_DRIVER);
		String username = element.elementText(ELEMENT_USERNAME);
		String password = element.elementText(ELEMENT_PASSWORD);
		
		//获取标签的属性值
		String attUser = element.attributeValue(ATTRIBUTE_USER);
		
		//获取当前标签的名字
		String dbName = element.getName();
		
		info.setAttUser(attUser);
		info.setDbName(dbName);
		info.setDriver(driver);
		info.setPassword(password);
		info.setUrl(url);
		info.setUsername(username);
		
		return info;
	}
	
	/**
	 * 将指定的一组数据以xml格式通过输出流写出
	 * @param out
	 * @param infos
	 * @throws IOException 
	 */
	public static void writeDBInfosToXML(OutputStream out, List<DBInfo> infos) throws IOException{
		/**
		 * 1、创建一个文档对象Document
		 * 2、向文档对象中添加根标记
		 * 3、向根标记中按照需求添加子标记，最终构成xml的树状结构
		 * 4、将根标记写出，这样整个结构就转化为xml形式写出了
		 */
		
		//1、创建文档对象
		Document document = DocumentHelper.createDocument();
		/**
		 * 2、添加根标记
		 * Document的addElement(String name)方法会向文档对象添加名为name参数的根标记
		 * 该方法有返回值，返回值为添加的根标记对象的Element 
		 */
		Element root = document.addElement(ELEMENT_JDBC);
		
		/**
		 * 3、向根标记添加子标记
		 * 	添加多个子标记由给定的数据决定
		 */
		for (DBInfo dbInfo : infos) {
			Element ele = DBInfoToElement(dbInfo);
			root.add(ele);
		}
		
		//4
		XMLWriter writer = new XMLWriter(out);
		
		//将根标记写出
		writer.write(document);
		writer.flush();
		writer.close();
		System.out.println("写出完成...");
	}
	
	public static Element DBInfoToElement(DBInfo info){
		/**
		 * 1、创建一个空的Element对象，该对象代表oracle或者mysql
		 * 		标签，没有子元素和属性
		 * 2、添加子元素，如url，driver等标签
		 * 3、添加属性，如user="user"
		 */
		
		//1
		Element element = DocumentHelper.createElement(info.getDbName());
		
		//2
		Element url = element.addElement(ELEMENT_URL);
		/**
		 * 等同于下面两步：
		 * Element url = DocumentHelper.createElement(ELEMENT_URL);
		 * element.add(url);
		 */
		url.setText(info.getUrl());
		
		element.addElement(ELEMENT_DRIVER).setText(info.getDriver());
		
		element.addElement(ELEMENT_USERNAME).setText(info.getUsername());
		
		element.addElement(ELEMENT_PASSWORD).setText(info.getPassword());
		
		//为当前标记添加属性
		element.addAttribute(ATTRIBUTE_USER, info.getAttUser());
		
		return element;
	}
}
