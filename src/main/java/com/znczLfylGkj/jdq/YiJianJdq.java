package com.znczLfylGkj.jdq;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.znczLfylGkj.util.LoadProperties;
import com.znczLfylGkj.util.StringUtil;

public class YiJianJdq {

    private Socket client;
    private Thread t_read; 

	public void open() {
		try {
			String yiJianJdqIp = LoadProperties.getYiJianJdqIp();
			int yiJianJdqPort = LoadProperties.getYiJianJdqPort();
			System.out.println("yiJianJdqIp==="+yiJianJdqIp);
			System.out.println("yiJianJdqPort==="+yiJianJdqPort);
			client=new Socket(yiJianJdqIp,yiJianJdqPort);
			t_read= new Thread(new ThreadReadSocket(client));
			t_read.start();
			System.out.println("����һ��̵���");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			client.close();
			System.out.println("�Ͽ�һ��̵�������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendData(String data) {
		try {
			if(client!=null) {
				if(!client.isClosed()) {
					/***************��������*****************/
					OutputStream out = client.getOutputStream();
					/***************��ʮ�������ַ���ת��Ϊ�ֽ����鷢��*****************/
					out.write (StringUtil.hexStringToByteArray(data));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
