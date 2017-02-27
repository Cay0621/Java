package org.com.cay.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {

	public static void main(String[] args) {
		DOM4JTest dom4jTest = new DOM4JTest();
		dom4jTest.createXML();
	}

	public void xmlParser() {
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		File file = new File("books.xml");
		try {
			Document document = reader.read(file);
			//获取根节点
			Element rootElement = document.getRootElement();
			
			Iterator<?> it = rootElement.elementIterator();
			while(it.hasNext()){
				System.out.println("=====开始遍历=====");
				Element book = (Element) it.next();
				@SuppressWarnings("unchecked")
				List<Attribute> attrs = book.attributes();
				for (Attribute attr : attrs) {
					System.out.println("节点名:" + attr.getName() + ",节点值:" + attr.getValue());
				}
				
				Iterator<?> childs = book.elementIterator();
				while(childs.hasNext()){
					Element child = (Element) childs.next();
					System.out.println("属性名:" + child.getName() + ",属性值:" + child.getStringValue());
				}
				System.out.println("=====结束遍历=====");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createXML(){
		//创建Document对象，代表整个xml文档
		Document document = DocumentHelper.createDocument();
		//创建根节点
		Element rss = document.addElement("rss");
		//向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");
		
		//生成xml的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		//生成xml文件
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(new File("rss_dom4j.xml")), format);
			//设置是否转义，默认为true，代表转义
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
