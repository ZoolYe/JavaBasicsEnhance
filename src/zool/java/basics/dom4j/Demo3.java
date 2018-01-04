package zool.java.basics.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo3 {

	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\users.xml";
	/* ����users.xml�ĵ����Ƿ��к��û���ƥ����û���������
	 * selectSingleNode��ȡ�����ڵ�
	 * */
	
	public static void main(String[] args) throws Exception {
		
		String userName ="����";
		String password ="123";
		
		//���xml�ĵ����Ƿ���ƥ����û���������
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(xmlPath));
		
		//��ȡxml�ļ��еģ�user��ǩusername���Ե������� 	����		password���Ե���123�Ľڵ�
		Node node = document.selectSingleNode("//user[@username='"+userName+"'and @password='"+password+"']");
		
		if(node==null){
			System.out.println("�û������������");
			return;
		}
		
		Element el = (Element) node;
		System.out.println(el.attributeValue("id")+" : "+el.attributeValue("password")+" : "+el.attributeValue("email"));
		
	}

}
