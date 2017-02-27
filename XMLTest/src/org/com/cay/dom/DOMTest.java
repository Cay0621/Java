package org.com.cay.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMTest domTest = new DOMTest();
		domTest.createXML();

	}

	public void xmlParser() {
		// 创建一个DocumentBuilderFactory对象

		try {
			DocumentBuilder builder = getDocumentBuilder();
			// 通过DocumentBuilder对象的parse方法加载xml文件
			Document document = builder.parse("books.xml");
			// 获取所有的节点集合
			NodeList books = document.getElementsByTagName("book");
			//
			System.out.println("共有" + books.getLength() + "本书！");// 节点个数

			// 遍历
			for (int i = 0; i < books.getLength(); ++i) {
				// 通过NodeList.item(index)方法遍历每个Node
				System.out.println("=====开始解析第" + (i + 1) + "个节点=====");
				Node book = books.item(i);
				// 获取Node节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength()
						+ "个属性");
				for (int j = 0; j < attrs.getLength(); ++j) {
					Node attr = attrs.item(j);
					System.out.print("属性名：" + attr.getNodeName());
					System.out.println("，属性值：" + attr.getNodeValue());
				}
				/*
				 * //如果属性值有且只有一个，并且知道该属性的名称，可以简化 //强制类型转换成Element类型 Element elem
				 * = (Element) books.item(i); String attrValue =
				 * elem.getAttribute("id"); System.out.println("id属性值为" +
				 * attrValue);
				 */

				// 遍历book节点的子节点
				NodeList childNodes = book.getChildNodes();// 包括空格和换行
				System.out.println("第" + (i + 1) + "个节点有"
						+ childNodes.getLength() + "个子节点");

				for (int k = 0; k < childNodes.getLength(); ++k) {
					// 区分text类型的node(空格和换行)和element类型的node,排除空格和换行
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						System.out.print("节点名："
								+ childNodes.item(k).getNodeName() + ",节点值：");
						// System.out.println(childNodes.item(k).getFirstChild().getNodeValue());//只是将该node下的下一个子节点的value值输出，如果是仍是element的话，返回null
						System.out.println(childNodes.item(k).getTextContent());// 会将该node下的所有文本进行返回

					}
				}

				System.out.println("=====结束解析第" + (i + 1) + "个节点=====");
				System.out.println();
			}

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createXML() {
		DocumentBuilder builder = getDocumentBuilder();
		Document document = builder.newDocument();
		document.setXmlStandalone(true);
		// 创建根节点
		Element bookstore = document.createElement("bookstore");
		// 向根节点添加子节点
		Element book = document.createElement("book");
		// 添加属性
		book.setAttribute("id", "1");
		
		//向子节点中添加属性
		Element name = document.createElement("name");
		name.setTextContent("Cay");
		book.appendChild(name);

		bookstore.appendChild(book);
		// 向文档中添加根节点
		document.appendChild(bookstore);

		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");//是否换行
			tf.transform(new DOMSource(document), new StreamResult(new File(
					"books_dom.xml")));

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder;
	}
}
