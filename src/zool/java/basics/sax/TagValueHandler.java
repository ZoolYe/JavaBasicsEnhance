package zool.java.basics.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//获取指定标签的值
public class TagValueHandler extends DefaultHandler {

	private String currentTag;//记录读取到的标签名
	private int needNumber = 0;//想要获取第一个标签的值
	private int currentNumber;//当前解析到的是第一个标签
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
			throws SAXException {
		currentTag = qName;
		if(qName.equals("作者")) {
			currentNumber++;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		if(currentTag.equals("作者") && currentNumber == needNumber) {
			System.out.println(new String(ch,start,length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
			currentTag = "";
	}
	
}
