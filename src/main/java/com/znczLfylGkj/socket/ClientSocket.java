package com.znczLfylGkj.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.znczLfylGkj.cpsbsxt.Car;
import com.znczLfylGkj.util.APIUtil;

import net.sf.json.JSONObject;

public class ClientSocket implements Runnable {

	public static final int YI_JIAN=1;
	public static final int ER_JIAN=2;
	public static final String PUSH_CPH="pushCph";
	private OutputStreamWriter out;
	private BufferedReader in;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				String line = in.readLine();
				System.out.println("line==="+line);
				if(line==null) {
					//关闭流\socket
					break;
				}
				this.readMessage(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}

	private void readMessage(String mesJOStr) {
		System.out.println("mesJOStr==="+mesJOStr);
		JSONObject mesJO = net.sf.json.JSONObject.fromObject(mesJOStr);
		String action = mesJO.getString("action");
		System.out.println("action==="+action);
		switch (action) {
		case PUSH_CPH:
			Car car1=new Car();
			String cph = mesJO.getString("cph");
			car1.setsLicense(" "+cph);
			APIUtil.updateYJCPSBDDXX(car1);
			break;
		}
	}
	
	private void sendName(){
		int yjFlag= 0;
		//name = JOptionPane.showInputDialog(f, "请输入姓名:");
		yjFlag=1;
		this.sendMessageToServer(yjFlag+"");
	}
	
	private void sendMessageToServer(String mes){
		try {
			out.write(mes+"\n");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectServer() {
		try {
			Socket socket = new Socket("127.0.0.1",8000);//能输入配置
			System.out.println("连接成功!");
			out = new OutputStreamWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.sendName();//第一时间发送一检或二检标志
			Thread th = new Thread(this);
			th.start();			
		} catch (UnknownHostException e) {
			System.out.println("服务器不存在...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("与服务器建立连接异常...");
			e.printStackTrace();
		}

	}
}
