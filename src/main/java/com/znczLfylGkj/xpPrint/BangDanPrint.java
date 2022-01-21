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

public class BangDanPrint implements Printable {

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
		g2.drawString("��ͨ��չ���޹�˾",(float)x+25,(float)y+heigth);

		float line = 2*heigth; //��һ�п�ʼ��ӡ�ĸ߶�
		g2.setFont(new Font("����", Font.PLAIN,8));//������������  
		heigth = font.getSize2D();// ����߶�  

		line+=2;
		//���ò���Ա 
		g2.drawString("����Ա:�����",(float)x+20,(float)y+line); 
		line+=heigth;

		//���ö�����  
		g2.drawString("������:202010240001", (float)x+20,(float)y+line);
		line+=heigth+2;
		
		switch (pageIndex) {  
			case 0:  
				return PAGE_EXISTS;//0 
			default:  
				return NO_SUCH_PAGE;//1
		}  
	}

}
