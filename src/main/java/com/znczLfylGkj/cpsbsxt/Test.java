package com.znczLfylGkj.cpsbsxt;

import java.io.File;

public class Test {
	
	static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;

	public static void main(String[] args) {
		 boolean initSuc = hCNetSDK.NET_DVR_Init();
		 System.out.println("initSuc: " + initSuc);
	}
}
