package com.znczLfylGkj.task;

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
		APIUtil.updateYJCZDDXX();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		APIUtil.checkYJSBHXBHWGSState();
		
		// 其他线程启动
		while (true) {
			// main程序一直运行
			
		}
	}
}
