package zool.java.basics.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//��xml�ĵ��е�ÿһ�����װ��book�����У����Ѷ��book�������һ��list�����з���
public class BeanListHandler extends DefaultHandler {

	private List<Book> list = new ArrayList<>();
	private String currentTag;
	private Book book;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if(currentTag.equals("��")) {
			book = new Book();
			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("����".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setName(value);
		}
		if("����".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setAuthor(value);
		}
		if("�ۼ�".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setPrice(value);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("��")) {
			list.add(book);
			book = null;
		}
		currentTag = null;
	}

	public List<Book> getBooks() {
		return list;
	}

}
