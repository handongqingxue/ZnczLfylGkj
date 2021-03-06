package com.znczLfylGkj.db.xk3190;

import gnu.io.SerialPort;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GiftTool {

	private final static Logger LOGGER = Logger.getLogger("GiftTool");
	
    public static void getWeight() throws InterruptedException {
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
			
			while (true) {
				Thread.sleep(3000);
	            //接收数据
	            bytes = MachineTool.uartReceiveDatafromSingleChipMachine(serialPortTest);
	            System.out.println("b==="+bytes);
	            if (bytes != null && bytes.length > 0) {
	                dataReceive = ByteUtil.byte2hex(bytes);
	                //在此处可以对数据进行判断处理，识别操作
	                LOGGER.info((i++) + ". 从串口" + name + "接收的数据：" + dataReceive);
	                String str=ByteUtil.byte2hex(bytes);
	    			//String str="022B30303030363030314403";
	    			str=str.substring(str.indexOf("022b"), 32);
	    			
	    			String str5 = str.substring(4, 6);
	    			String str6 = str.substring(6, 8);
	    			String str7 = str.substring(8, 10);
	    			String str8 = str.substring(10, 12);
	    			String str9 = str.substring(12, 14);
	    			String str10 = str.substring(14, 16);
	    			
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
	            } else {
	                LOGGER.warning("串口号：" + name + "接收到的数据为空！");
	            }
			}
            
            //serialPortTest.close();
        }
    }

	public static void main(String[] args) {
		try {
			GiftTool.getWeight();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String s="30314203022b30303030303030314203022b30303030303030314203022b30303030303030314203022b30303030303030314203022b30303030303030314203022b30303030303030314203022b30303030303030314203";
		//System.out.println(s.indexOf("022b"));
		//System.out.println(s.substring(8, 32));
	}
}
