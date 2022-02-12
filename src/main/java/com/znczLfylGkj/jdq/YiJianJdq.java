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
			System.out.println("连接一检继电器");
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
			System.out.println("断开一检继电器连接");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendData(String data) {
		try {
			if(client!=null) {
				if(!client.isClosed()) {
					/***************发送数据*****************/
					OutputStream out = client.getOutputStream();
					/***************将十六进制字符串转换为字节数组发送*****************/
					out.write (StringUtil.hexStringToByteArray(data));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
