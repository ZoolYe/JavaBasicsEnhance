package zool.java.basics.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//把xml文档中的每一本书分装到book对象中，并把多个book对象放在一个list集合中返回
public class BeanListHandler extends DefaultHandler {

	private List<Book> list = new ArrayList<>();
	private String currentTag;
	private Book book;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if(currentTag.equals("书")) {
			book = new Book();
			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("书名".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setName(value);
		}
		if("作者".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setAuthor(value);
		}
		if("售价".equals(currentTag)) {
			String value = new String(ch,start,length);
			book.setPrice(value);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("书")) {
			list.add(book);
			book = null;
		}
		currentTag = null;
	}

	public List<Book> getBooks() {
		return list;
	}

}
