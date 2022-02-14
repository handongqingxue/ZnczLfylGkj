package com.znczLfylGkj.task;

import java.util.ArrayList;
import java.util.List;

import com.znczLfylGkj.db.xk3190.ByteUtil;
import com.znczLfylGkj.db.xk3190.MachineTool;

import gnu.io.SerialPort;

public class DiBangTask3190 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�����ذ��߳�");
		try {
			getWeight();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static int getWeight() throws InterruptedException {
        SerialPort serialPortTest = null;
        byte[] bytes = null;
        String dataReceive = null;
        int preWeight=0;
        int weight=0;
        int steadyCount=0;//�ȶ�����
        int i = 1;
        //ѭ����������
        List<String> serialPorts = MachineTool.uartPortUseAblefind();
        System.out.println("size==="+serialPorts.size());
        for (String name : serialPorts) {
        	System.out.println("name==="+name);
			serialPortTest = MachineTool.portParameterOpen(name, 9600);
			
			while (true) {
				Thread.sleep(3000);
	            //��������
	            bytes = MachineTool.uartReceiveDatafromSingleChipMachine(serialPortTest);
	            System.out.println("b==="+bytes);
	            //if (bytes != null && bytes.length > 0) {
	                //dataReceive = ByteUtil.byte2hex(bytes);
	                //�ڴ˴����Զ����ݽ����жϴ���ʶ�����
	                System.out.println((i++) + ". �Ӵ���" + name + "���յ����ݣ�" + dataReceive);
	                //String str=ByteUtil.byte2hex(bytes);
	    			//String str="022B30303030303030314403";
	    			String str="022B30303030313030314403";
	    			//str=str.substring(str.indexOf("022b"), 32);
	    			
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
	    			weight=ByteUtil.connectZf2Weight(list);
	    			System.out.println("����==="+weight);
					//if(weight>0) {
						if(steadyCount>5) {
							break;
						}
						
						if(weight==preWeight)
							steadyCount++;
						else
							steadyCount=0;
						preWeight=weight;
					//}
	            //} else {
	            	//System.out.println("���ںţ�" + name + "���յ�������Ϊ�գ�");
	            //}
			}
            
            serialPortTest.close();
        }
        return weight;
    }
}
