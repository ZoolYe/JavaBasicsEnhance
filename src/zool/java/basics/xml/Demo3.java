package zool.java.basics.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//ʹ��dom��ʽ��xml�ĵ�������ɾ�Ĳ�
public class Demo3 {

	@Test
	public void read() throws Exception {
		
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//ͨ��Ԫ������ȡ�ڵ㣬���ص������Ԫ���������нڵ�
		NodeList node_list = document.getElementsByTagName("����");
		//ͨ���Ǳ��ȡ�ڵ�
		Node node = node_list.item(0);
		//��ȡ�ڵ���ı�
		String context = node.getTextContent();
		System.out.println(context);
	}

	@Test
	public void read2() throws Exception {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\\\ZOOL\\\\Java\\\\JavaBasicsEnhance\\\\src\\\\zool\\\\java\\\\basics\\\\xml\\\\book.xml");
		
		//��ȡ���ڵ�
		Node root = document.getElementsByTagName("���").item(0);
		//��ȡxml�ĵ��е����нڵ�
		list(root);
	}

	
	//��ȡxml�ĵ��е����нڵ�
	private void list(Node node) {
		
		if(node instanceof Element) {
			System.out.println(node.getNodeName());
		}
		
		NodeList node_list = node.getChildNodes();
		for(int i=0; i<node_list.getLength(); i++) {
			Node child = node_list.item(i);
			list(child);
		}
	}
	
	//��ȡxml�ĵ��б�ǩ���Ե�ֵ
	@Test
	public void read3() throws Exception {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//���ڵ�ǿת��Ԫ�أ�����ȡ����ķ���
		Element book_name = (Element) document.getElementsByTagName("����").item(0);
		//ͨ������������ȡ���Ե�ֵ
		String bookName_str = book_name.getAttribute("name");
		System.out.println(bookName_str);
	}
	
	//��xml�ĵ�����ӽڵ�
	@Test
	public void add() throws Exception {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		
		//�����ڵ�
		Element price = document.createElement("�ۼ�");
		//�򴴽��Ľڵ�������ı�����
		price.setTextContent("109.0��");
		
		//�Ѵ����Ľڵ㣬��ӵ��ĸ��ڵ��У��Ȼ�ȡ���ڵ㣬��ͨ�����ڵ������ӽڵ㷽������Ҫ��ӵĽڵ���ӽ�ȥ
		Element book_node = (Element) document.getElementsByTagName("��").item(0);
		//�򸸽ڵ�������ӽڵ�
		book_node.appendChild(price);
		
		//�����ڴ��и��º����ݣ����µ�xml�ļ���
		//��ȡת������
		TransformerFactory trFactory = TransformerFactory.newInstance();
		//��ȡת����
		Transformer transformer = trFactory.newTransformer();
		//ת������������1������һ���ڵ� document�ڵ㣬����2:����һ��StreamResult�� ��StreamResult����FileOutputStream��
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//��xml�ĵ���ָ��λ�ò���ڵ�
	@Test
	public void add2() throws Exception {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//�����ۼ۽ڵ�
		Element price = document.createElement("�۸�");
		//���ۼ۽ڵ�������ı�����
		price.setTextContent("���˼۸��˵��");
		//��ȡ��һ����ڵ�
		Node book_node = document.getElementsByTagName("��").item(0);
		//��ȡ�ο��ڵ�
		Node refNode = document.getElementsByTagName("�ۼ�").item(0);
		//����ڵ���ָ��λ���ϲ����ӽڵ㣬��refNode�ڵ�֮ǰ����price�ڵ�
		book_node.insertBefore(price, refNode);
		
		//���ڴ��е����ݸ��µ�xml�ļ���
		//��ȡת������
		TransformerFactory trFactory = TransformerFactory.newInstance();
		//��ȡת����
		Transformer transformer = trFactory.newTransformer();
		//ת������������1������һ���ڵ� document�ڵ㣬����2:����һ��StreamResult�� ��StreamResult����FileOutputStream��
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//��xml�ĵ��еı�ǩ��������
	@Test
	public void add3() throws Exception {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡdom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����xml�ĵ����õ������ĵ���document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//��ȡ��һ�������ڵ�
		Element book_name = (Element) document.getElementsByTagName("����").item(1);
		//���ڵ�������ԣ�����1��������������2������ֵ
		book_name.setAttribute("name", "��ʵ�����ûʲô��������");
		
		//���ڴ��е����ݸ��µ�xml�ļ���
		//��ȡת������
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		//��ȡת����
		Transformer transformer = tfFactory.newTransformer();
		//ת������������1������һ���ڵ� document�ڵ㣬����2:����һ��StreamResult�� ��StreamResult����FileOutputStream��
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//ɾ���ڵ�
	@Test
	public void delete() throws Exception {
		
		String xml_path = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml";
		Document document = getDocument(xml_path);
		//��ȡҪɾ���Ľڵ�
		Node del_node = document.getElementsByTagName("�ۼ�").item(2);
		//��ȡҪɾ���Ľڵ�ĸ��ڵ�
		Node par_node = del_node.getParentNode();
		//ͨ�����ڵ�ɾ���ӽڵ�
		par_node.removeChild(del_node);
		updateXmlFile(document, xml_path);
		
	}
	
	//���±�ǩ�е��ı�����
	@Test
	public void update() throws Exception {
		
		String xml_path = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml";
		Document document = getDocument(xml_path);
		Node upNode = document.getElementsByTagName("�ۼ�").item(1);
		upNode.setTextContent("109��");
		updateXmlFile(document, xml_path);
	}
	
	/**
	 * @author ZOOL
	 * @param ����Ҫ������xml�ļ�����·���ַ���
	 * @return ����xml�ļ���document�Ķ���
	 * */
	public Document getDocument(String str_path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(str_path);
		return document;
	}
	
	/**
	 * @author ZOOL
	 * @param ����Ҫ�����ļ���document�ڵ����
	 * @param ����Ҫ�޸ĵ�xml�ļ��ַ�������·��
	 * */
	public void updateXmlFile(Document document,String xml_path) throws FileNotFoundException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(xml_path)));
	}
	
}
