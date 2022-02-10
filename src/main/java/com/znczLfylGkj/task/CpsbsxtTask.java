package com.znczLfylGkj.task;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.znczLfylGkj.cpsbsxt.FMSGCallBack;
import com.znczLfylGkj.cpsbsxt.HCNetSDK;
import com.znczLfylGkj.cpsbsxt.HCNetSDK.NET_DVR_DEVICEINFO_V30;

public class CpsbsxtTask extends Thread {
	static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean initSuc = hCNetSDK.NET_DVR_Init();
		
		System.out.println("initSuc: " + initSuc);
		//  ע��ص�
	 	FMSGCallBack fMSFCallBack = new FMSGCallBack();  //�����ص�����ʵ��
		Pointer pUser = null;
		hCNetSDK.NET_DVR_SetDVRMessageCallBack_V30(fMSFCallBack, pUser );
		//ע��1
        //String  m_sDeviceIP = LoadProperties.getHikvisionJinMenIP();//�豸ip��ַ
        String  m_sDeviceIP = "192.168.1.11";
        //int iPort = Integer.parseInt(LoadProperties.getHikvisionJinMenPort());
        int iPort = 8000;
        //String userName =LoadProperties.getHikvisionJinMenUserName();
        //String password = LoadProperties.getHikvisionJinMenPassword();
        String userName ="admin";
        String password = "lanfan2022";
        NET_DVR_DEVICEINFO_V30 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        NativeLong lUserID = hCNetSDK.NET_DVR_Login_V30(m_sDeviceIP, (short) iPort, userName, password, m_strDeviceInfo);

        long userID = lUserID.longValue();
        if (userID == -1){
           System.out.println("ע��ʧ�ܣ�ipΪ�� " + m_sDeviceIP);
           return;
        }
        System.out.println(m_sDeviceIP + "  userID: " + userID);
        
        NativeLong lAlarmHandle = hCNetSDK.NET_DVR_SetupAlarmChan_V30(lUserID);
        if (lAlarmHandle.intValue() == -1)
        {
        	System.out.println(m_sDeviceIP + "����ʧ�ܣ�");
            return;
        }
	}
}
