package com.znczLfylGkj.task;

import com.znczLfylGkj.cpsbsxt.Car;
import com.znczLfylGkj.jdq.ErJianJdq;
import com.znczLfylGkj.jdq.JdqZlUtil;
import com.znczLfylGkj.jdq.YiJianJdq;
import com.znczLfylGkj.util.APIUtil;

public class StartTask {

	public static void main(String[] args) {
		//DiBangTask3124 diBangTask3124=new DiBangTask3124();
		//diBangTask3124.start();
		
		//DiBangTask3190 diBangTask3190=new DiBangTask3190();
		//diBangTask3190.start();
		
		// 车牌识别的线程任务
		//CpsbsxtTask cpsbsxtTask = new CpsbsxtTask();
		//cpsbsxtTask.start();
		
		YiJianJdq yjjdq=new YiJianJdq();
		JdqZlUtil.open(yjjdq);
		
		ErJianJdq ejjdq=new ErJianJdq();
		JdqZlUtil.open(ejjdq);

		testLiuCheng();
		
		// 其他线程启动
		while (true) {
			// main程序一直运行
			
		}
	}
	
	public static void testLiuCheng() {
		/*
		Car car=new Car();
		car.setsLicense(" 鲁B9023");
		APIUtil.updateYJCPSBDDXX(car);
		*/
		
		try {
			//APIUtil.checkYJSBHXBHWGSState();
			//Thread.sleep(10000);
			//APIUtil.yiJianChengZhongZhong();
			//Thread.sleep(1000);
			//APIUtil.checkYJXBHWGSState();
			Thread.sleep(10000);
			APIUtil.checkIfYJXBYwc();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
