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
	 * ����xml�ļ��������õ������������ӷ���
	 * @param input	:
	 * 
	 * ��ΪҪʹ��DOMȥ����xml�ļ�����ôһ��Ҫͨ��������ȥ��ȡxml�ļ�������
	 * �����ļ��������绹�Ǳ����ļ��������ڳ����ж���ͨ������������ʽȥ��ȡ��
	 * 
	 * @return
	 */
	public static List<DBInfo> xmlToDBInfo(InputStream input){
		/**
		 * ����ʹ��DOM��������DOM4J�ǳ����е����ڽ���xml��DOM����
		 * 
		 * �������裺
		 * 1���������ڽ���xml�ļ��Ķ�ȡ��SAXReader
		 * 2��ʹ��SAXReader��ȡָ����������������xml�ļ�
		 * 3����2���ķ�������һ��Document�������������ĵ���ͨ�����ĵ������ȡ�����Root
		 * 4���������ṹ����һ����
		 */
		
		//1��
		//dom4j����dom4j-1.6.1.jar
		SAXReader reader = new SAXReader();
		
		/**
		 * ����xml�ļ�ǰ�ȵ������з������÷���Ĭ��ֵΪfalse
		 * ����Ϊtrue�������Ǽ��xml�ĺϷ��ԣ���֤DTD(Document Type Definition)
		 */
		
		//���oracle��дuser���ԣ����setValidation(true)��ᱨ����ʾoracle��user����δ����
		//reader.setValidation(true);
		
		//2��
		Document document;//org.dom4j.Document
		try {
			document = reader.read(input);//��ȡ�������ļ�
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("���ݶ�ȡ����",e);
		}
		
		//3����ȡ�����
		Element root = document.getRootElement();//org.dom4j.Element
		/**
		 * root.getName();//��ȡ��ǰ��ǩ�����֣�����Ӧ����jdbc 
		 */
		if(!ELEMENT_JDBC.equals(root.getName())){
			throw new RuntimeException("���ݸ�ʽ���󣬸���ǩӦ��Ϊ: " + ELEMENT_JDBC);
		}
		
		//4��
		/**
		 * elements():�÷�����ȡrootԪ���µ�������Ԫ�أ��Լ��ϵ���ʽ����
		 * 	�Ա�xmlΪ���Ļ����򷵻�"mysql"��"oracle"�µ�������Ԫ�صļ���
		 * 
		 * element(String name):��ȡָ�����ֵ�Ԫ��
		 * 	����name="mysql",�򷵻�nameΪmysql������һ��Ԫ�صļ��ϣ�����Ƕ����Ҳ��������һ����
		 * 	
		 * elements(String name):��ȡָ�����ֵ�������Ԫ��
		 *	����name="mysql"���򷵻�nameΪmysql��������Ԫ�صļ���
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
		
		//��ȡ��ǩ������ֵ
		String attUser = element.attributeValue(ATTRIBUTE_USER);
		
		//��ȡ��ǰ��ǩ������
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
	 * ��ָ����һ��������xml��ʽͨ�������д��
	 * @param out
	 * @param infos
	 * @throws IOException 
	 */
	public static void writeDBInfosToXML(OutputStream out, List<DBInfo> infos) throws IOException{
		/**
		 * 1������һ���ĵ�����Document
		 * 2�����ĵ���������Ӹ����
		 * 3���������а�����������ӱ�ǣ����չ���xml����״�ṹ
		 * 4���������д�������������ṹ��ת��Ϊxml��ʽд����
		 */
		
		//1�������ĵ�����
		Document document = DocumentHelper.createDocument();
		/**
		 * 2����Ӹ����
		 * Document��addElement(String name)���������ĵ����������Ϊname�����ĸ����
		 * �÷����з���ֵ������ֵΪ��ӵĸ���Ƕ����Element 
		 */
		Element root = document.addElement(ELEMENT_JDBC);
		
		/**
		 * 3������������ӱ��
		 * 	��Ӷ���ӱ���ɸ��������ݾ���
		 */
		for (DBInfo dbInfo : infos) {
			Element ele = DBInfoToElement(dbInfo);
			root.add(ele);
		}
		
		//4
		XMLWriter writer = new XMLWriter(out);
		
		//�������д��
		writer.write(document);
		writer.flush();
		writer.close();
		System.out.println("д�����...");
	}
	
	public static Element DBInfoToElement(DBInfo info){
		/**
		 * 1������һ���յ�Element���󣬸ö������oracle����mysql
		 * 		��ǩ��û����Ԫ�غ�����
		 * 2�������Ԫ�أ���url��driver�ȱ�ǩ
		 * 3��������ԣ���user="user"
		 */
		
		//1
		Element element = DocumentHelper.createElement(info.getDbName());
		
		//2
		Element url = element.addElement(ELEMENT_URL);
		/**
		 * ��ͬ������������
		 * Element url = DocumentHelper.createElement(ELEMENT_URL);
		 * element.add(url);
		 */
		url.setText(info.getUrl());
		
		element.addElement(ELEMENT_DRIVER).setText(info.getDriver());
		
		element.addElement(ELEMENT_USERNAME).setText(info.getUsername());
		
		element.addElement(ELEMENT_PASSWORD).setText(info.getPassword());
		
		//Ϊ��ǰ����������
		element.addAttribute(ATTRIBUTE_USER, info.getAttUser());
		
		return element;
	}
}
