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
		
		// ����ʶ����߳�����
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
		
		// �����߳�����
		while (true) {
			// main����һֱ����
			
		}
	}
}
