package com.znczLfylGkj.jdq;

public class JdqZlUtil {

	public static void openYiJianShangBangDz() {
		try {
			YiJianJdq yjjdq=new YiJianJdq();
			yjjdq.open();
			yjjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			Thread.sleep(1000);
			yjjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//����ʱ�����ִ�и�λ����
			yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdqZlUtil.openYiJianShangBangDz();
	}
}
