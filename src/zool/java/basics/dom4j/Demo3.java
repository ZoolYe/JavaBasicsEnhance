package zool.java.basics.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo3 {

	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\users.xml";
	/* 查找users.xml文档中是否有和用户相匹配的用户名和密码
	 * selectSingleNode获取单个节点
	 * */
	
	public static void main(String[] args) throws Exception {
		
		String userName ="张三";
		String password ="123";
		
		//检测xml文档中是否有匹配的用户名和密码
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(xmlPath));
		
		//获取xml文件中的，user标签username属性等于张三 	并且		password属性等于123的节点
		Node node = document.selectSingleNode("//user[@username='"+userName+"'and @password='"+password+"']");
		
		if(node==null){
			System.out.println("用户名或密码错误！");
			return;
		}
		
		Element el = (Element) node;
		System.out.println(el.attributeValue("id")+" : "+el.attributeValue("password")+" : "+el.attributeValue("email"));
		
	}

}
