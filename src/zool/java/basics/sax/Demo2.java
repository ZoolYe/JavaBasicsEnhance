package zool.java.basics.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;


public class Demo2 {

	/* sax解析xml文档
	 * */
	
	public static void main(String[] args) throws Exception {
		//1，创建解析工厂
	 	SAXParserFactory factory = SAXParserFactory.newInstance();
	 	
		//2，得到解析器
		SAXParser saxParser = factory.newSAXParser();
	 	
		//3，得到读取器
		XMLReader xmlReader = saxParser.getXMLReader();
		
		//4，设置内容处理器，一定要在读取之前进行设置
		//设置一个内容处理器
		xmlReader.setContentHandler(new TagValueHandler());
		
		//5，读取xml文档内容
		xmlReader.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\sax\\book.xml");
	}

}
