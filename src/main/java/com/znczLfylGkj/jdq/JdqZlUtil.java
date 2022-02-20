package com.znczLfylGkj.jdq;

import com.znczLfylGkj.util.LoadProperties;

/**
 * 继电器指令工具类
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

	/**
	 * 开启一检继电器
	 */
	public static void openYiJianJdq() {
		JdqZlUtil.yjjdq.open();
	}

	/**
	 * 关闭一检继电器
	 */
	public static void closeYiJianJdq() {
		JdqZlUtil.yjjdq.close();
	}

	/**
	 * 开启二检继电器
	 */
	public static void openErJianJdq() {
    	System.out.println("开启二检继电器");
		JdqZlUtil.ejjdq.open();
	}

	/**
	 * 关闭二检继电器
	 */
	public static void closeErJianJdq() {
		JdqZlUtil.ejjdq.close();
	}

	/**
	 * 抬起一检上磅道闸
	 */
	public static void openYiJianShangBangDz() {
		try {
			yjjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			yjjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//脉冲时间过后执行复位操作
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 抬起一检下磅道闸
	 */
	public static void openYiJianXiaBangDz() {
		try {
			yjjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI2);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			yjjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI2);//脉冲时间过后执行复位操作
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 抬起二检上磅道闸
	 */
	public static void openErJianShangBangDz() {
		try {
			ejjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI1);
			int erJianJdqMaiChong = LoadProperties.getErJianJdqMaiChong();
			Thread.sleep(erJianJdqMaiChong);
			ejjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI1);//脉冲时间过后执行复位操作
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 抬起二检下磅道闸
	 */
	public static void openErJianXiaBangDz() {
		try {
			ejjdq.sendData(WriteZhiLingConst.KAI_JI_DIAN_QI2);
			int yiJianJdqMaiChong = LoadProperties.getYiJianJdqMaiChong();
			Thread.sleep(yiJianJdqMaiChong);
			ejjdq.sendData(WriteZhiLingConst.GUAN_JI_DIAN_QI2);//脉冲时间过后执行复位操作
			//Thread.sleep(1000);
			//yjjdq.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//YiJianJdq yjjdq=new YiJianJdq();
		//JdqZlUtil.setYjjdq(yjjdq);
		//JdqZlUtil.openYiJianJdq();
    	//JdqZlUtil.openYiJianShangBangDz();
		
		ErJianJdq ejjdq=new ErJianJdq();
		JdqZlUtil.setEjjdq(ejjdq);
		JdqZlUtil.openErJianJdq();
    	JdqZlUtil.openErJianXiaBangDz();
	}
}
