package zool.java.basics.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {
		
		//װ��,jvm 1.5֮���֧��
		Integer i = 1;
		
		//����
		int j = i;
		
		//�Զ�װ��ĵ���Ӧ��,�ӽ����ϵ��Ƕ���123����������
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			int s = (int) it.next();//����
		}
	}

}
