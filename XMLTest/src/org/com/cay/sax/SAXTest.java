package org.com.cay.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.com.cay.entity.Book;
import org.com.cay.handler.SAXParserHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取一个SAXParserFactory的实例
		SAXTest saxTest = new SAXTest();
		saxTest.createXML();

	}

	public List<Book> xmlParser() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 通过SAXParserFactory的newSAXParser方法获得SAXParser实例

		try {
			SAXParser parser = factory.newSAXParser();
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);

			System.out.println("共有" + handler.getBookList().size() + "本书...");

			for (Book book : handler.getBookList()) {
				System.out.println("-------------------");
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getPrice());
				System.out.println("-------------------");
			}

			return handler.getBookList();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void createXML() {
		List<Book> bookList = xmlParser();
		// 生成xml
		SAXTransformerFactory ttf = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();

		try {
			TransformerHandler handler = ttf.newTransformerHandler();
			// 通过handler对象创建一个TransformerHandler对象
			Transformer tf = handler.getTransformer();
			// 对xml文件进行设置
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			Result result = new StreamResult(new FileOutputStream(new File(
					"books_sax.xml")));
			
			//创建Result对象，使其与handler关联
			handler.setResult(result);
			
			//利用handler对象进行xml文件内容的编写
			//打开document
			handler.startDocument();
			
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookstore", attr);
			
			for(Book book : bookList){
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId().toString());
				handler.startElement("", "", "book", attr);
				
				//创建name节点属性
				attr.clear();
				handler.startElement("", "", "name", attr);
				handler.characters(book.getName().toCharArray(), 0, book.getName().length());
				handler.endElement("", "", "name");
				
				//创建author节点属性
				attr.clear();
				handler.startElement("", "", "author", attr);
				handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
				handler.endElement("", "", "author");
				
				//创建price节点属性
				attr.clear();
				handler.startElement("", "", "price", attr);
				handler.characters(String.valueOf(book.getPrice()).toCharArray(), 0, String.valueOf(book.getPrice()).length());
				handler.endElement("", "", "price");
				
				handler.endElement("", "", "book");
			}
			
			handler.endElement("", "", "bookstore");
			//关闭document
			handler.endDocument();
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
