package zool.java.basics.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/* ʹ��xpath��ȡxml�ĵ�������
 * */
public class Demo2 {

	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\book.xml";
	
	public static void main(String[] args) throws Exception {
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ļ���������document����
		Document document = saxReader.read(new File(xmlPath));
		
		String zuozhe = document.selectSingleNode("//����").getText();
		System.out.println(zuozhe);
		
	}
	
}
