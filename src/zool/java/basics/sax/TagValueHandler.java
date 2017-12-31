package zool.java.basics.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//��ȡָ����ǩ��ֵ
public class TagValueHandler extends DefaultHandler {

	private String currentTag;//��¼��ȡ���ı�ǩ��
	private int needNumber = 0;//��Ҫ��ȡ��һ����ǩ��ֵ
	private int currentNumber;//��ǰ���������ǵ�һ����ǩ
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
			throws SAXException {
		currentTag = qName;
		if(qName.equals("����")) {
			currentNumber++;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		if(currentTag.equals("����") && currentNumber == needNumber) {
			System.out.println(new String(ch,start,length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
			currentTag = "";
	}
	
}
