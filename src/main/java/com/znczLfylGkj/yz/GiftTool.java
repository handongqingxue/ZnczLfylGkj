package com.znczLfylGkj.yz;

import gnu.io.SerialPort;

import java.util.List;
import java.util.logging.Logger;

public class GiftTool {

	private final static Logger LOGGER = Logger.getLogger("GiftTool");
	

    public static String run(byte[] msg) throws InterruptedException {
        SerialPort serialPortTest = null;
        byte[] bytes = null;
        String dataReceive = null;
        int i = 1;
        //ѭ����������
        List<String> serialPorts = MachineTool.uartPortUseAblefind();
        System.out.println("size==="+serialPorts.size());
        for (String name : serialPorts) {
        	System.out.println("name==="+name);
			serialPortTest = MachineTool.portParameterOpen(name, 9600);
            //��������
            //System.out.println("msg==="+(msg==null));
            MachineTool.uartSendDatatoSerialPort(serialPortTest, msg);
            // ����300ms���ȴ���Ƭ����Ӧ
            Thread.sleep(500);
            //��������
            bytes = MachineTool.uartReceiveDatafromSingleChipMachine(serialPortTest);
            if (bytes != null && bytes.length > 0) {
                dataReceive = ByteUtil.byte2hex(bytes);
                //�ڴ˴����Զ����ݽ����жϴ�����ʶ�����
                LOGGER.info((i++) + ". �Ӵ���" + name + "���յ����ݣ�" + dataReceive);
            } else {
                LOGGER.warning("���ںţ�" + name + "���յ�������Ϊ�գ�");
            }
            serialPortTest.close();
        }
        return ByteUtil.byte2hex(bytes);
    }

	public static void main(String[] args) {
		try {
			GiftTool.run(ByteUtil.hex2byte(ZhiLingUtil.getByDuanHao(83).replaceAll(" ", "")));
			//GiftTool.run(ByteUtil.hex2byte(ZhiLingUtil.getByDuanHao(81).replaceAll(" ", "")));
			/*
			while (true) {
				GiftTool.run(ByteUtil.hex2byte(WriteZhiLingConst.XIA_YI_QU));
				Thread.sleep(2000);
			}
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}