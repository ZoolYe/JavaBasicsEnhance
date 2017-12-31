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

//ʹ��dom4j������xml�ĵ�
public class Demo1 {
	
	public static String xmlPath = "D:\\ZOOL\\Java\\JavaBasicsEnhance\\src\\zool\\java\\basics\\dom4j\\book.xml";
	
	//��ȡxml�ĵ�
	@Test
	public void read() throws Exception {
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ĵ���������Document����
		Document document = saxReader.read(new File(xmlPath));
		
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		
		Element book = root.elements("��").get(0);
		
		String bookName = book.element("����").getText();
		
		System.out.println(bookName);
		
	}
	
	//��ȡxml�ĵ�����ǩ�е�����
	@Test
	public void readAttr() throws Exception {
		
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ĵ���������Document����
		Document document = saxReader.read(new File(xmlPath));
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//��ȡ��ڵ�
		Element book_node = root.elements("��").get(0);
		//ͨ����ڵ��ȡ�����ڵ㣬�ٻ�ȡ�����ڵ������ֵ
		String book_attr = book_node.element("����").attributeValue("name");
		System.out.println(book_attr);
		
	}
	
	
	//��xml�ļ����������
	@Test
	public void add() throws Exception {
		
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ļ���������document����
		Document document = saxReader.read(new File(xmlPath));
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		
		//��ȡ��ڵ�
		Element bookNode = root.element("��");
		
		//����ڵ�������ӽڵ㣬����ڵ����������
		bookNode.addElement("�ۼ�").setText("119��");
		
		//������ʽ����������ĵ���ʽ�������
		OutputFormat format = OutputFormat.createPrettyPrint();
		//������ʽ����������ĵ���ʽѹ��
		//OutputFormat format = OutputFormat.createCompactFormat();
		//���ñ����
		format.setEncoding("UTF-8");
		
		//��document����д�뵽xml�ļ���
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	//��xml�ļ���ָ��λ�������Ԫ��
	@Test
	public void add2() throws Exception {
		
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ļ���������document����
		Document document = saxReader.read(new File(xmlPath));
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//��ȡ��ڵ�
		Element bookNode = root.element("��");
		//��ȡ��������ӽڵ�,���ص���List���ϣ������ж��ǽڵ�
		List listNode = bookNode.elements();
		
		//����һ���ۼ۱�ǩ�����������
		Element priceNode = DocumentHelper.createElement("�ۼ�");
		priceNode.setText("78��");
		
		//�򼯺ϵ�ָ��λ�������Ԫ�أ�5�Ǳ�
		listNode.add(5, priceNode);
		
		//����һ����ʽ�������
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//��documentд��xml�ļ���
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath), format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	//ɾ��xml�ļ��еĽڵ�
	@Test
	public void delete() throws Exception {
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ļ���������document����
		Document document = saxReader.read(new File(xmlPath));
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//��ȡ��ڵ�
		Element bookNode = root.element("��");
		//��ȡ��������ӽڵ�,���ص���List���ϣ������ж��ǽڵ�
		List list = bookNode.elements();
		//�Ƴ������нǱ�Ϊ0�Ľڵ�
		list.remove(0);
		
		//����һ����ʽ�������
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//��documentд��xml�ļ���
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}

	@Test
	public void update() throws Exception {
		
		//��ȡ������
		SAXReader saxReader = new SAXReader();
		//��ȡxml�ļ���������document����
		Document document = saxReader.read(new File(xmlPath));
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//��ȡ��ڵ�
		Element bookNode = root.elements().get(1);
		//ͨ����ڵ��ȡ���߽ڵ㣬�������ı�����
		bookNode.element("����").setText("����_android����");
		//����һ����ʽ�������
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		//��documentд��xml�ļ���
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlPath),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
}
