package org.com.cay.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.com.cay.entity.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDOMTest jdomTest = new JDOMTest();
		jdomTest.createXML();
	}

	public void xmlParser() {
		List<Book> books = new ArrayList<Book>();
		//创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			InputStream in = new FileInputStream("books.xml");
			//通过SAXBuilder的build方法，将输入流加载到SAXBuilder对象中
			Document document = saxBuilder.build(in);
			
			//获取xml文件的根节点
			Element rootElement = document.getRootElement();
			//获取根节点下的所有子节点
			List<Element> bookList = rootElement.getChildren();
			
			//遍历
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("开始解析第" + (bookList.indexOf(book) + 1) + "本书");
				
				List<Attribute> attrs = book.getAttributes();
				
				//知道属性名，可以直接使用如下代码
				//book.getAttributeValue("id");
				
				for (Attribute attr : attrs) {
					//获取属性名
					String attrName = attr.getName();
					//获取属性值
					String attrValue = attr.getValue();
					System.out.println("属性名:" + attrName + ",属性值:" + attrValue);
					
					if(attrName.equals("id")){
						bookEntity.setId(Integer.parseInt(attrValue));
					}
				}
				
				//开始解析该节点的子节点
				List<Element> bookChild = book.getChildren();
				for (Element child : bookChild) {
					System.out.println("节点名:" + child.getName() + ",节点值:" + child.getValue());
					
					if(child.getName().equals("name")){
						bookEntity.setName(child.getValue());
					}else if(child.getName().equals("author")){
						bookEntity.setName(child.getValue());
					}else if(child.getName().equals("price")){
						bookEntity.setPrice(Double.parseDouble(child.getValue()));
					}
				}
				books.add(bookEntity);
				bookEntity = null;
				
				System.out.println("结束解析第" + (bookList.indexOf(book) + 1) + "本书");
			}
			//book的个数
			System.out.println(books.size());
			for (Book book : books) {
				System.out.println(book);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createXML(){
		//生成根节点
		Element rss = new Element("rss");
		//为节点添加属性
		rss.setAttribute("version", "2.0");
		
		Element channel = new Element("channel");
		rss.addContent(channel);
		
		Element title = new Element("title");
		title.setText("国内新闻");
		channel.addContent(title);
		
//		Element context = new Element("context");
//		CDATA val = new CDATA("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");
//		context.addContent(val);
		
		//生成一个Document对象
		Document document = new Document(rss);
		
		
		Format format = Format.getCompactFormat();
		format.setEncoding("UTF-8");
		format.setIndent("");
		//创建XMLOutputter输出对象
		XMLOutputter outputer = new XMLOutputter(format);
		
		try {
			outputer.output(document, new FileOutputStream(new File("rss_jdom.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
