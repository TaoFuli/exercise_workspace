package xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		// 方式2 SAX方式
		// 
		
		// 1. 创建工厂
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		// 2. 工厂创建解析对象
		SAXParser parser = spf.newSAXParser();
		
		// 3. 使用解析对象进行解析
		SAXParserHandler handler = new SAXParserHandler();//　处理对象
		parser.parse("book3.xml",handler);
		
		System.out.println(handler.book);

	}

}
