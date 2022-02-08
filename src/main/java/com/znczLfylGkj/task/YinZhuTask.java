package com.znczLfylGkj.task;

import com.znczLfylGkj.util.HexadecimalUtil;
import com.znczLfylGkj.util.RXTXUtil;
import com.znczLfylGkj.yz.ZhiLingUtil;

public class YinZhuTask {

	public static String sendMsg(String zhiLing, long sleepTime) {
		try {
			//String serialPortName = LoadProperties.getSerialPortName();
			String serialPortName = "COM6";
			// ¿ªÆô´®¿Ú
			//RXTXUtil.openSerialPort(LoadProperties.getSerialPortName(), 100);
			RXTXUtil.openSerialPort(serialPortName, 9600);

			String executeOrder = RXTXUtil.executeOrder(zhiLing, serialPortName, 9600);

			Thread.sleep(sleepTime);
			RXTXUtil.closeSerialPort();
			return executeOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zhiLing;
	}
	
	public static void main(String[] args) {
		YinZhuTask.sendMsg(ZhiLingUtil.get83().replaceAll(" ", ""), 1500);
		YinZhuTask.sendMsg(ZhiLingUtil.getByStr("Â³").replaceAll(" ", ""), 800);
		YinZhuTask.sendMsg(ZhiLingUtil.getByStr("9").replaceAll(" ", ""), 800);
		YinZhuTask.sendMsg(ZhiLingUtil.getByStr("8").replaceAll(" ", ""), 800);
		YinZhuTask.sendMsg(ZhiLingUtil.getByStr("8").replaceAll(" ", ""), 800);
		YinZhuTask.sendMsg(ZhiLingUtil.getByStr("8").replaceAll(" ", ""), 800);
		YinZhuTask.sendMsg(ZhiLingUtil.get81().replaceAll(" ", ""), 1500);
	}
}
