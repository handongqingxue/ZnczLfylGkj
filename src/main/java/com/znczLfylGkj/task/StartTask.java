package com.znczLfylGkj.task;

import com.znczLfylGkj.cpsbsxt.Car;
import com.znczLfylGkj.jdq.JdqZlUtil;
import com.znczLfylGkj.jdq.YiJianJdq;
import com.znczLfylGkj.util.APIUtil;

public class StartTask {

	public static void main(String[] args) {
		//DiBangTask3124 diBangTask3124=new DiBangTask3124();
		//diBangTask3124.start();
		
		//DiBangTask3190 diBangTask3190=new DiBangTask3190();
		//diBangTask3190.start();
		
		// ����ʶ����߳�����
		//CpsbsxtTask cpsbsxtTask = new CpsbsxtTask();
		//cpsbsxtTask.start();
		
		YiJianJdq yjjdq=new YiJianJdq();
		JdqZlUtil.open(yjjdq);

		testLiuCheng();
		
		// �����߳�����
		while (true) {
			// main����һֱ����
			
		}
	}
	
	public static void testLiuCheng() {
		/*
		Car car=new Car();
		car.setsLicense(" ³B9023");
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
