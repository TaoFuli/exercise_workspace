package xml;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
	
		// 方式1. DOM方式
		// 一次性将文档读入,创建一个文档树对象
		
		// Node类型
		// 1. 元素节点 Node.ELEMENT_NODE
		// 2. 属性节点 Node.ATTRIBUTE_NODE
		// 3.文本节点 Node.TEXT_NODE
		// 4. 注释节点 Node.COMMENT_NODE
		// 5.文档节点 Node.DOCUMENT_NODE
		
		// 得到指定Tag的节点结合 getElementsByTagName
		// 得到某节点上的所有子节点 getChildNodes()
		// 得到节点属性getAttribute()
		// 节点名 getNodeName()
		// 节点的值 getNodeValue()				???
		// 节点中的文本 e2.getTextContent()
		
		// 1.   创建一个工厂对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		// 2.   使用工厂对象创建一个DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// 3. 读取解析xml
		Document doc = db.parse("book3.xml");
		
		// 4. 从文档中获取节点
		NodeList nl = doc.getElementsByTagName("book");
		
		
		for(int i=0;i<nl.getLength();i++)
		{
			Element e = (Element)nl.item(i);
			
			
			
			// 1. 读取属性 getAttribute()
			System.out.println("编号:"+e.getAttribute("id"));
			
			// 2.子节点
			NodeList nl2 = e.getChildNodes();
			
			
			
			System.out.println("数量"+nl2.getLength());
			for(int j=0;j<nl2.getLength();j++)
			{
				// 得到子节点
				Node n2 = nl2.item(j);
				if(n2.getNodeType() == Node.ELEMENT_NODE)
				{
					Element e2 = (Element)n2;
					System.out.println(e2.getNodeName()+":"+e2.getTextContent());
					
				}
			}
			
		}
		

	}

}
