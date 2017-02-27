package org.com.cay.handler;


import java.util.ArrayList;
import java.util.List;

import org.com.cay.entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	private int bookIndex = 0;
	String value = null;
	Book book = null;
	private List<Book> bookList = new ArrayList<Book>();
	
	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 * 用来遍历xml文件的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		//开始解析book元素
		if(qName.equals("book")){
			book = new Book();
			bookIndex++;
			System.out.println("=====开始解析第" + bookIndex + "个节点=====");
			//已知book下的属性值id
			//String value = attributes.getValue("id");
			//System.out.println(value);
			
			//未知book元素下的属性值
			int num = attributes.getLength();
			for(int i = 0;i < num; ++i){
				System.out.print("book元素的第" + (i + 1) + "个属性名为" + attributes.getQName(i));
				System.out.println("，属性值为" + attributes.getValue(i));
				
				if(attributes.getQName(i).equals("id")){
					book.setId(Integer.parseInt(attributes.getValue(i)));
				}
			}
		}else if(!qName.equals("book") && !qName.equals("bookstore")){
			System.out.print("节点名为：" + qName);
		}
	}
	
	/**
	 * 用来遍历xml文件的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经遍历结束
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			System.out.println("=====结束解析第" + bookIndex + "本书=====");
			System.out.println();
		}else if(qName.equals("name")){
			book.setName(value);
		}else if(qName.equals("author")){
			book.setAuthor(value);
		}else if(qName.equals("price")){
			book.setPrice(Double.parseDouble(value));
		}
		
	}
	
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("开始解析");
	}
	
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("结束解析");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if(!value.trim().equals(""))
			System.out.println(",节点值为：" + value);
	}
	
	
}
