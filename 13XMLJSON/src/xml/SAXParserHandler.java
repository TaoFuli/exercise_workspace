package xml;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler
{
	Book book;
	
	String tmpText;
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		
		System.out.println("---开始解析xml文档");
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		
		System.out.println("---完成解析xml文档");
		super.endDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		System.out.println("--解析到元素节点开始:"+qName);
		
		if(qName.equals("book"))
		{
			book = new Book();
			book.setId(Integer.parseInt(attributes.getValue("id")));
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		
		System.out.println("--解析到元素节点结束:"+qName);
		
		
		// 节点的名字 qName
		// tmpText
		try {
			BeanUtils.copyProperty(book, qName, tmpText);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		String str = new String(ch,start,length);
		str = str.trim();// 去掉换行和空格
		
		if(str.length()>0)
		{
			System.out.println("--解析到文本节点:"+str);
			
			// 记录文本节点的内容
			tmpText = str;
		}
	}

}
