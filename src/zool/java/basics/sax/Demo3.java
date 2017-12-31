package zool.java.basics.sax;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;


public class Demo3 {
	
	public static void main(String[] args) throws Exception {

		//1��������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2���õ�������
		SAXParser saxParser = factory.newSAXParser();
		
		//3���õ���ȡ��
		XMLReader xmlReader = saxParser.getXMLReader();
		
		//4���������ݴ�������һ��Ҫ�ڶ�ȡ֮ǰ��������
		//����һ�����ݴ�����
		BeanListHandler beanListHandler = new BeanListHandler();
		xmlReader.setContentHandler(beanListHandler);
		
		//5����ȡxml�ĵ�����
		xmlReader.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\sax\\book.xml");
		
		List<Book> list = beanListHandler.getBooks();
		System.out.println(list);
	}
	
}
