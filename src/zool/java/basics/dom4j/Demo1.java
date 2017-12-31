package zool.java.basics.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

//使用dom4j来操作xml文档
public class Demo1 {
	
	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\book.xml";
	
	//读取xml文档
	@Test
	public void read() throws Exception {
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文档，并返回Document对象
		Document document = saxReader.read(new File(xmlPath));
		
		//获取根节点
		Element root = document.getRootElement();
		
		Element book = root.elements("书").get(0);
		
		String bookName = book.element("书名").getText();
		
		System.out.println(bookName);
		
	}
	
	//读取xml文档，标签中的属性
	@Test
	public void readAttr() throws Exception {
		
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文档，并返回Document对象
		Document document = saxReader.read(new File(xmlPath));
		//获取根节点
		Element root = document.getRootElement();
		//获取书节点
		Element book_node = root.elements("书").get(0);
		//通过书节点获取书名节点，再获取书名节点的属性值
		String book_attr = book_node.element("书名").attributeValue("name");
		System.out.println(book_attr);
		
	}
	
	
	//向xml文件中添加数据
	@Test
	public void add() throws Exception {
		
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文件，并返回document对象
		Document document = saxReader.read(new File(xmlPath));
		//获取根节点
		Element root = document.getRootElement();
		
		//获取书节点
		Element bookNode = root.element("书");
		
		//向书节点中添加子节点，并向节点中添加内容
		bookNode.addElement("售价").setText("119￥");
		
		//创建格式化输出器，文档格式相对美观
		OutputFormat format = OutputFormat.createPrettyPrint();
		//创建格式化输出器，文档格式压缩
		//OutputFormat format = OutputFormat.createCompactFormat();
		//设置编码表
		format.setEncoding("UTF-8");
		
		//将document对象写入到xml文件中
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	//向xml文件的指定位置上添加元素
	@Test
	public void add2() throws Exception {
		
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文件，并返回document对象
		Document document = saxReader.read(new File(xmlPath));
		//获取根节点
		Element root = document.getRootElement();
		//获取书节点
		Element bookNode = root.element("书");
		//获取书的所有子节点,返回的是List集合，集合中都是节点
		List listNode = bookNode.elements();
		
		//创建一个售价标签，并添加数据
		Element priceNode = DocumentHelper.createElement("售价");
		priceNode.setText("78￥");
		
		//向集合的指定位置上添加元素，5角标
		listNode.add(5, priceNode);
		
		//创建一个格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//将document写到xml文件中
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath), format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	//删除xml文件中的节点
	@Test
	public void delete() throws Exception {
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文件，并返回document对象
		Document document = saxReader.read(new File(xmlPath));
		//获取根节点
		Element root = document.getRootElement();
		//获取书节点
		Element bookNode = root.element("书");
		//获取书的所有子节点,返回的是List集合，集合中都是节点
		List list = bookNode.elements();
		//移除集合中角标为0的节点
		list.remove(0);
		
		//创建一个格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//将document写到xml文件中
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}

	@Test
	public void update() throws Exception {
		
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文件，并返回document对象
		Document document = saxReader.read(new File(xmlPath));
		//获取根节点
		Element root = document.getRootElement();
		//获取书节点
		Element bookNode = root.elements().get(1);
		//通过书节点获取作者节点，并设置文本内容
		bookNode.element("作者").setText("郭神_android大神");
		//创建一个格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//将document写到xml文件中
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
}
