package com.znczLfylGkj.db.xk3124;

import gnu.io.SerialPort;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GiftTool {

	private final static Logger LOGGER = Logger.getLogger("GiftTool");
	
    public static String getWeight() throws InterruptedException {
        SerialPort serialPortTest = null;
        byte[] bytes = null;
        String dataReceive = null;
        int i = 1;
        //循环遍历串口
        List<String> serialPorts = MachineTool.uartPortUseAblefind();
        System.out.println("size==="+serialPorts.size());
        for (String name : serialPorts) {
        	System.out.println("name==="+name);
			serialPortTest = MachineTool.portParameterOpen(name, 9600);
            //接收数据
            bytes = MachineTool.uartReceiveDatafromSingleChipMachine(serialPortTest);
            if (bytes != null && bytes.length > 0) {
                dataReceive = ByteUtil.byte2hex(bytes);
                //在此处可以对数据进行判断处理，识别操作
                LOGGER.info((i++) + ". 从串口" + name + "接收的数据：" + dataReceive);
            } else {
                LOGGER.warning("串口号：" + name + "接收到的数据为空！");
            }
            
            serialPortTest.close();
        }
        return ByteUtil.byte2hex(bytes);
    }

	public static void main(String[] args) {
		try {
			while (true) {
				Thread.sleep(3000);
				String str=GiftTool.getWeight();
				//String str="022930203030303037303030303030300D31";
				String str5 = str.substring(8, 10);
				String str6 = str.substring(10, 12);
				String str7 = str.substring(12, 14);
				String str8 = str.substring(14, 16);
				String str9 = str.substring(16, 18);
				String str10 = str.substring(18, 20);
				
				System.out.println("str5==="+str5);
				System.out.println("str6==="+str6);
				System.out.println("str7==="+str7);
				System.out.println("str8==="+str8);
				System.out.println("str9==="+str9);
				System.out.println("str10==="+str10);
				
				List<String> list=new ArrayList<String>();
				list.add(ByteUtil.hex2Zf(str5));
				list.add(ByteUtil.hex2Zf(str6));
				list.add(ByteUtil.hex2Zf(str7));
				list.add(ByteUtil.hex2Zf(str8));
				list.add(ByteUtil.hex2Zf(str9));
				list.add(ByteUtil.hex2Zf(str10));
				int weight=ByteUtil.connectZf2Weight(list);
				System.out.println("重量==="+weight);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
