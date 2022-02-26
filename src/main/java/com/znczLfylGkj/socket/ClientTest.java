package com.znczLfylGkj.socket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.znczLfylGkj.util.LoadProperties;

public class ClientTest implements ActionListener,Runnable {

	private JFrame f;
	private JTextArea text;
	private JTextField txtInput;
	private JButton butSend,butConnect;
	private OutputStreamWriter out;
	private BufferedReader in;
	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ClientTest() {
		this.initFace();
	}

	public void show() {
		f.setVisible(true);
		
	}

	private void showMessage(String mes) {
		text.append(mes + "\n");
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
	private void sendName(){
		String name= null;
		name = JOptionPane.showInputDialog(f, "请输入姓名:");
		if(name==null) name = "无名";
		this.sendMessageToServer(name);
	}
	
	private void sendName2(){
		int bfNoFlag= 0;
		//name = JOptionPane.showInputDialog(f, "请输入姓名:");
		bfNoFlag=LoadProperties.getBangFangHao();
		this.sendMessageToServer(bfNoFlag+"");
	}
	
	private void connectServer() {
		try {
			//Socket socket = new Socket("127.0.0.1",8000);//能输入配置
			this.showMessage("连接成功!");
			out = new OutputStreamWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.sendName();//第一时间发送自己的名字
			Thread th = new Thread(this);
			th.start();			
		} catch (UnknownHostException e) {
			this.showMessage("服务器不存在...");
			e.printStackTrace();
		} catch (IOException e) {
			this.showMessage("与服务器建立连接异常...");
			e.printStackTrace();
		}

	}
	
	public void connectServer2() {
		try {
			//String serverIp="127.0.0.1";
			String serverIp=LoadProperties.getServerIp();
			//socket = new Socket("10.10.99.20",8000);//能输入配置
			socket = new Socket(serverIp,8000);//能输入配置
			System.out.println("连接成功!...");
			out = new OutputStreamWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.sendName2();//第一时间发送一检或二检标志
			Thread th = new Thread(this);
			th.start();			
		} catch (UnknownHostException e) {
			System.out.println("服务器不存在...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("与服务器建立连接异常...");
			//e.printStackTrace();
		}

	}

	private void initFace() {
		f = new JFrame("客户端");
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this.makeMainPanel());
		f.add(this.makeSayPanel(), BorderLayout.SOUTH);
	}

	private JPanel makeMainPanel() {
		JPanel p = new JPanel(new BorderLayout());
		text = new JTextArea();
		p.add(new JScrollPane(text));
		return p;
	}

	private JPanel makeSayPanel() {
		JPanel p = new JPanel();
		txtInput = new JTextField(20);
		butSend = new JButton("发送");
		butConnect = new JButton("连接");
		butSend.addActionListener(this);
		butConnect.addActionListener(this);
		p.add(txtInput);
		p.add(butSend);
		p.add(butConnect);
		return p;
	}

	public static void main(String[] args) {
		ClientTest client = new ClientTest();
		//client.show();
		client.connectServer2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==butSend){
			sysSend();
		}
		else if(o==butConnect){
			this.connectServer2();
		}
		
		
	}

	private void sysSend() {
		String str = this.txtInput.getText();
		this.showMessage("我说:"+str);
		this.sendMessageToServer(str);
		
	}

	@Override
	public void run() {
		while(true){
			try {
				String line = in.readLine();
				if(line==null) {
					//关闭流\socket
					break;
				}
				this.showMessage(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.err();
				break;
			}
			
		}
		
	}
	private void err(){
		
	}
}
