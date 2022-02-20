package com.znczLfylGkj.xpPrint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import org.json.JSONObject;

import com.znczLfylGkj.entity.GuoBangJiLu;

public class BangDanPrint implements Printable {
	
	private GuoBangJiLu gbjl;
	
	public BangDanPrint(GuoBangJiLu gbjl) {
		this.gbjl=gbjl;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//�� Graphics2D ����չ Graphics �࣬���ṩ�Լ�����״������ת������ɫ������ı����ָ�Ϊ���ӵĿ��ơ�
		//���������� Java(tm) ƽ̨�ϳ��ֶ�ά��״���ı���ͼ��Ļ����ࡣ 
		Graphics2D g2 = (Graphics2D) graphics;  
		g2.setColor(Color.black);//���ô�ӡ��ɫΪ��ɫ

		//��ӡ�������  
		double x= pageFormat.getImageableX();  //������� PageFormat��ص� Paper����Ŀɳ����������Ϸ���� x���ꡣ  
		double y= pageFormat.getImageableY();  //������� PageFormat��ص� Paper����Ŀɳ����������Ϸ���� y���ꡣ

		//Font.PLAIN�� ��ͨ��ʽ����  	Font.ITALIC б����ʽ����	Font.BOLD ������ʽ������
		Font font = new Font("����",Font.BOLD,10); //����ָ�����ơ���ʽ�Ͱ�ֵ��С������һ���� Font��
		
		g2.setFont(font);//���ñ����ӡ����     
		
		float heigth = font.getSize2D();//��ȡ����ĸ߶�  
		
		//����СƱ�ı������  
		g2.drawString("�����������޹�˾",(float)x+25,(float)y+heigth);

		float line = 2*heigth; //��һ�п�ʼ��ӡ�ĸ߶�
		g2.setFont(new Font("����", Font.PLAIN,8));//������������  
		heigth = font.getSize2D();// ����߶�  

		//���ö�����  
		g2.drawString("������:"+gbjl.getDdh(), (float)x+20,(float)y+line);
		line+=heigth+2;

		//���ó��ƺ�  
		g2.drawString("���ƺ�:"+gbjl.getCph(), (float)x+20,(float)y+line);
		line+=heigth+2;

		//����˾������  
		g2.drawString("˾������:"+gbjl.getSjxm(), (float)x+20,(float)y+line);
		line+=heigth+2;

		//����˾�����֤��  
		g2.drawString("˾�����֤��:"+gbjl.getSjsfzh(), (float)x+20,(float)y+line);
		line+=heigth+2;

		//���ù�������  
		g2.drawString("��������:"+gbjl.getGbzl() , (float)x+20,(float)y+line);
		line+=heigth+2;
		
		line+=2;
		//���ù������� 
		g2.drawString("��������:"+gbjl.getGblxName(),(float)x+20,(float)y+line);
		line+=heigth;

		//���ù���ʱ��  
		g2.drawString("����ʱ��:"+gbjl.getGbsj(), (float)x+20,(float)y+line);
		line+=heigth+100;
		g2.drawString(".", (float)x+20,(float)y+line);
		
		switch (pageIndex) {  
			case 0:  
				return PAGE_EXISTS;//0 
			default:  
				return NO_SUCH_PAGE;//1
		}  
	}

}
