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

//使用dom方式对xml文档进行增删改查
public class Demo3 {

	@Test
	public void read() throws Exception {
		
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//通过元素名获取节点，返回的是这个元素名的所有节点
		NodeList node_list = document.getElementsByTagName("书名");
		//通过角标获取节点
		Node node = node_list.item(0);
		//获取节点的文本
		String context = node.getTextContent();
		System.out.println(context);
	}

	@Test
	public void read2() throws Exception {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\\\ZOOL\\\\Java\\\\JavaBasicsEnhance\\\\src\\\\zool\\\\java\\\\basics\\\\xml\\\\book.xml");
		
		//获取根节点
		Node root = document.getElementsByTagName("书架").item(0);
		//获取xml文档中的所有节点
		list(root);
	}

	
	//获取xml文档中的所有节点
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
	
	//获取xml文档中标签属性的值
	@Test
	public void read3() throws Exception {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//将节点强转成元素，来获取更多的方法
		Element book_name = (Element) document.getElementsByTagName("书名").item(0);
		//通过属性名来获取属性的值
		String bookName_str = book_name.getAttribute("name");
		System.out.println(bookName_str);
	}
	
	//向xml文档中添加节点
	@Test
	public void add() throws Exception {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		
		//创建节点
		Element price = document.createElement("售价");
		//向创建的节点中添加文本内容
		price.setTextContent("109.0￥");
		
		//把创建的节点，添加到哪个节点中，先获取父节点，再通过父节点的添加子节点方法，将要添加的节点添加进去
		Element book_node = (Element) document.getElementsByTagName("书").item(0);
		//向父节点中添加子节点
		book_node.appendChild(price);
		
		//把在内存中更新后内容，更新到xml文件中
		//获取转换工厂
		TransformerFactory trFactory = TransformerFactory.newInstance();
		//获取转换器
		Transformer transformer = trFactory.newTransformer();
		//转换方法，参数1：接收一个节点 document节点，参数2:接收一个StreamResult流 ，StreamResult传入FileOutputStream流
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//向xml文档中指定位置插入节点
	@Test
	public void add2() throws Exception {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//创建售价节点
		Element price = document.createElement("价格");
		//向售价节点中添加文本内容
		price.setTextContent("熟人价格好说！");
		//获取第一个书节点
		Node book_node = document.getElementsByTagName("书").item(0);
		//获取参考节点
		Node refNode = document.getElementsByTagName("售价").item(0);
		//在书节点中指定位置上插入子节点，在refNode节点之前插入price节点
		book_node.insertBefore(price, refNode);
		
		//把内存中的数据更新到xml文件中
		//获取转换工厂
		TransformerFactory trFactory = TransformerFactory.newInstance();
		//获取转换器
		Transformer transformer = trFactory.newTransformer();
		//转换方法，参数1：接收一个节点 document节点，参数2:接收一个StreamResult流 ，StreamResult传入FileOutputStream流
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//向xml文档中的标签插入属性
	@Test
	public void add3() throws Exception {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档，得到代表文档的document
		Document document = builder.parse("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml");
		//获取第一个书名节点
		Element book_name = (Element) document.getElementsByTagName("书名").item(1);
		//给节点添加属性，参数1：属性名，参数2：属性值
		book_name.setAttribute("name", "其实这个书没什么技术含量");
		
		//把内存中的数据更新到xml文件中
		//获取转换工厂
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		//获取转换器
		Transformer transformer = tfFactory.newTransformer();
		//转换方法，参数1：接收一个节点 document节点，参数2:接收一个StreamResult流 ，StreamResult传入FileOutputStream流
		transformer.transform(new DOMSource(document), 
				new StreamResult(new FileOutputStream("D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml")));
	}
	
	//删除节点
	@Test
	public void delete() throws Exception {
		
		String xml_path = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml";
		Document document = getDocument(xml_path);
		//获取要删除的节点
		Node del_node = document.getElementsByTagName("售价").item(2);
		//获取要删除的节点的父节点
		Node par_node = del_node.getParentNode();
		//通过父节点删除子节点
		par_node.removeChild(del_node);
		updateXmlFile(document, xml_path);
		
	}
	
	//更新标签中的文本内容
	@Test
	public void update() throws Exception {
		
		String xml_path = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\xml\\book.xml";
		Document document = getDocument(xml_path);
		Node upNode = document.getElementsByTagName("售价").item(1);
		upNode.setTextContent("109￥");
		updateXmlFile(document, xml_path);
	}
	
	/**
	 * @author ZOOL
	 * @param 传入要解析的xml文件绝对路径字符串
	 * @return 返回xml文件的document的对象
	 * */
	public Document getDocument(String str_path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(str_path);
		return document;
	}
	
	/**
	 * @author ZOOL
	 * @param 传入要更新文件的document节点对象
	 * @param 传入要修改的xml文件字符串绝对路径
	 * */
	public void updateXmlFile(Document document,String xml_path) throws FileNotFoundException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(xml_path)));
	}
	
}
