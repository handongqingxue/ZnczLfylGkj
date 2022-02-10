package com.znczLfylGkj.task;

public class StartTask {

	public static void main(String[] args) {
		//DiBangTask3124 diBangTask3124=new DiBangTask3124();
		//diBangTask3124.start();
		
		//DiBangTask3190 diBangTask3190=new DiBangTask3190();
		//diBangTask3190.start();
		
		// 车牌识别的线程任务
		CpsbsxtTask cpsbsxtTask = new CpsbsxtTask();
		cpsbsxtTask.start();
		
		// 其他线程启动
				while (true) {
					// main程序一直运行
					
				}
	}
}
