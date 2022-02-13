package com.znczLfylGkj.jdq;

import com.znczLfylGkj.util.LoadProperties;

/**
 * �̵���ָ�����
 * */
public class JdqZlUtil {
	
	private static YiJianJdq yjjdq;
	private static ErJianJdq ejjdq;
	
	public static ErJianJdq getEjjdq() {
		return ejjdq;
	}

	public static void setEjjdq(ErJianJdq ejjdq) {
		JdqZlUtil.ejjdq = ejjdq;
	}

	public static YiJianJdq getYjjdq() {
		return yjjdq;
	}

	public static void setYjjdq(YiJianJdq yjjdq) {
		JdqZlUtil.yjjdq = yjjdq;
	}

	public static void open(YiJianJdq yjjdq) {
		JdqZlUtil.yjjdq=yjjdq;
		JdqZlUtil.yjjdq.open();
	}

	public static void open(ErJianJdq ejjdq) {
		JdqZlUtil.ejjdq=ejjdq;
		JdqZlUtil.ejjdq.open();
	}

	/**
	 * ̧��һ���ϰ���բ
	 */
	public static void openYiJianShangBangDz() {
		try {
			yjjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			yjjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//����ʱ�����ִ�и�λ����
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ̧��һ���°���բ
	 */
	public static void openYiJianXiaBangDz() {
		try {
			yjjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI2);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			yjjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI2);//����ʱ�����ִ�и�λ����
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ̧������ϰ���բ
	 */
	public static void openErJianShangBangDz() {
		try {
			ejjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			int erJianJdqMaiChong = LoadProperties.getErJianJdqMaiChong();
			Thread.sleep(erJianJdqMaiChong);
			ejjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//����ʱ�����ִ�и�λ����
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ̧������°���բ
	 */
	public static void openErJianXiaBangDz() {
		try {
			ejjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			ejjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//����ʱ�����ִ�и�λ����
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
