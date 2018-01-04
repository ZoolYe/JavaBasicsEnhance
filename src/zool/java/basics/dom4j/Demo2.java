package zool.java.basics.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/* 使用xpath提取xml文档的数据
 * */
public class Demo2 {

	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\book.xml";
	
	public static void main(String[] args) throws Exception {
		//获取解析器
		SAXReader saxReader = new SAXReader();
		//读取xml文件，并返回document对象
		Document document = saxReader.read(new File(xmlPath));
		
		String zuozhe = document.selectSingleNode("//作者").getText();
		System.out.println(zuozhe);
		
	}
	
}
