package zool.java.basics.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		
		//1����������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2���õ�dom������
		DocumentBuilder builder = factory.newDocumentBuilder();
        //3������xml�ĵ����õ������ĵ���document
		Document document = builder.parse("src/book.xml");
		
	}

}
