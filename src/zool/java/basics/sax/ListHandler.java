package zool.java.basics.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class ListHandler implements ContentHandler {

	@Override
	public void setDocumentLocator(Locator locator) {
	}

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
	}

	//读到的开始标签执行此方法
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.print("<"+qName+" ");
		for(int i=0; atts!=null && i<atts.getLength(); i++) {
			String attName = atts.getQName(i);
			String attValue = atts.getValue(i);
			System.out.print(attName+":"+attValue);
		}
		System.out.println(">");
	}

	//读到的结束标签执行此方法
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}

	//读到了文本内容执行此方法，将读到字符存入到字符数组中
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch,start,length));
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
	}

}
