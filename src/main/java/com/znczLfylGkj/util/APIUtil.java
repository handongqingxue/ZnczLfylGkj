package com.znczLfylGkj.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.Map.*;

import org.json.JSONObject;

import com.znczLfylGkj.cpsbsxt.Car;
import com.znczLfylGkj.entity.*;
import com.znczLfylGkj.jdq.ErJianJdq;
import com.znczLfylGkj.jdq.JdqZlUtil;
import com.znczLfylGkj.jdq.WriteZhiLingConst;
import com.znczLfylGkj.jdq.YiJianJdq;
import com.znczLfylGkj.task.DiBangTask3124;
import com.znczLfylGkj.task.DiBangTask3190;
import com.znczLfylGkj.task.YinZhuTask;
import com.znczLfylGkj.xpPrint.BangDanPrint;
import com.znczLfylGkj.xpPrint.XPPrinter;
import com.znczLfylGkj.yz.ByteUtil;
import com.znczLfylGkj.yz.GiftTool;
import com.znczLfylGkj.yz.YzZlUtil;

public class APIUtil {
	
	public static final String SERVICE_URL="http://10.10.99.20:8080/ZnczLfyl/gkj/";
	//public static final String SERVICE_URL="http://localhost:8080/ZnczLfyl/gkj/";
	public static final int YI_HAO_BANG_FANG=1;
	public static final int ER_HAO_BANG_FANG=2;

	//https://www.cnblogs.com/aeolian/p/7746158.html
	//https://www.cnblogs.com/bobc/p/8809761.html
	public static JSONObject doHttp(String method, Map<String, Object> params) throws IOException {
		// 构建请求参数  
        StringBuffer paramsSB = new StringBuffer();
		if (params != null) {  
            for (Entry<String, Object> e : params.entrySet()) {
            	paramsSB.append(e.getKey());  
            	paramsSB.append("=");  
            	paramsSB.append(e.getValue());  
            	paramsSB.append("&");  
            }  
            paramsSB.substring(0, paramsSB.length() - 1);  
        }  
		
		StringBuffer sbf = new StringBuffer(); 
		String strRead = null; 
		URL url = new URL(SERVICE_URL+method);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");//请求post方式
		connection.setDoInput(true); 
		connection.setDoOutput(true); 
		//header内的的参数在这里set    
		//connection.setRequestProperty("key", "value");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.connect(); 
		
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(),"UTF-8"); 
		//OutputStream writer = connection.getOutputStream(); 
		writer.write(paramsSB.toString());
		writer.flush();
		InputStream is = connection.getInputStream(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		while ((strRead = reader.readLine()) != null) {
			sbf.append(strRead); 
			sbf.append("\r\n"); 
		}
		reader.close();
		
		connection.disconnect();
		String result = sbf.toString();
		System.out.println("result==="+result);
		JSONObject resultJO = new JSONObject(result);
		return resultJO;
	}

	public static JSONObject getDingDan(String cph, String ddztMc) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("cph", cph);  
	        parames.put("ddztMc", ddztMc);
	        resultJO = doHttp("getDingDan",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}

	public static JSONObject getDingDanByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("yjbfh", yjbfh);
	        parames.put("ejbfh", ejbfh);
	        parames.put("ddztMc", ddztMc);
	        parames.put("yjzt", yjzt);
	        parames.put("ejzt", ejzt);
	        resultJO = doHttp("getDingDanByZt",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject editDingDan(DingDan dd) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("id", dd.getId());
	        parames.put("ddztMc", dd.getDdztMc());
	        parames.put("yjbfh", dd.getYjbfh());
	        parames.put("ejbfh", dd.getEjbfh());
	        resultJO = doHttp("editDingDan",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject editDingDanByZt(DingDan dd) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("yjbfh", dd.getYjbfh());
	        parames.put("ejbfh", dd.getEjbfh());
	        parames.put("ddztMc", dd.getDdztMc());
	        parames.put("yjzt", dd.getYjzt());
	        parames.put("ejzt", dd.getEjzt());
	        parames.put("xddztMc", dd.getXddztMc());
	        parames.put("xyjzt", dd.getXyjzt());
	        parames.put("xejzt", dd.getXejzt());
	        if(dd.getSjzl()!=null)
	        	parames.put("sjzl", dd.getSjzl());
	        if(dd.getZlceb()!=null)
	        	parames.put("zlceb", dd.getZlceb());
	        resultJO = doHttp("editDingDanByZt",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject newBangDanJiLu(Float mz, Float pz, Float jz, Integer ddId) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        if(mz!=null)
	        	parames.put("mz", mz);
	        if(pz!=null)
	        	parames.put("pz", pz);
	        if(jz!=null)
	        	parames.put("jz", jz);
	        if(ddId!=null)
	        	parames.put("ddId", ddId);  
	        resultJO = doHttp("newBangDanJiLu",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject editBangDanJiLu(Integer id, Float mz, Float pz, Float jz) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("id", id);
	        if(mz!=null)
	        	parames.put("mz", mz);
	        if(pz!=null)
	        	parames.put("pz", pz);
	        if(jz!=null)
	        	parames.put("jz", jz);
	        resultJO = doHttp("editBangDanJiLu",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject selectBangDanJiLuByDdId(Integer ddId) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("ddId", ddId);
	        resultJO = doHttp("selectBangDanJiLuByDdId",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject newGuoBangJiLu(GuoBangJiLu gbjl) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("gbzl", gbjl.getGbzl());
	        parames.put("zp1", gbjl.getZp1());
	        parames.put("zp2", gbjl.getZp2());
	        parames.put("zp3", gbjl.getZp3());
	        parames.put("gbzt", gbjl.getGbzt());
	        parames.put("gblx", gbjl.getGblx());
	        parames.put("ddId", gbjl.getDdId());
	        resultJO = doHttp("newGuoBangJiLu",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject checkDingDanIfExistByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
			if(yjbfh!=0)
				parames.put("yjbfh", yjbfh);
			if(ejbfh!=0)
				parames.put("ejbfh", ejbfh);
			parames.put("ddztMc", ddztMc);
			parames.put("yjzt", yjzt);
			parames.put("ejzt", ejzt);
			resultJO = doHttp("checkDingDanIfExistByZt",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	/**
	 * 更新一检称重订单信息
	 */
	public static void updateYJCZDDXX() {
		/*
		checkYJSBHWGSState();
		checkYJSBHXBHWGSState();
		yiJianChengZhongZhong();
		checkYJXBHWGSState();
		checkIfYJXBYwc();
		*/
	}
	
	/**
	 * 打印过磅记录小票(现在改成订单所有过磅都完成后一起打印，这个方法暂时不用了)
	 * @param gblx
	 */
	public static void printGbjl(int gblx) {
		System.out.println("打印过磅记录小票");
		JSONObject resultJO = null;
		Integer bfh = LoadProperties.getBangFangHao();
		switch (gblx) {
		case GuoBangJiLu.RU_CHANG_GUO_BANG:
			System.out.println("查询订单状态为一检上磅，一检状态为待下磅的订单");
			resultJO=getDingDanByZt(bfh,0,DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.DAI_XIA_BANG,DingDan.DAI_SHANG_BANG);
			break;
		case GuoBangJiLu.CHU_CHANG_GUO_BANG:
			System.out.println("查询订单状态为二检上磅，二检状态为待下磅的订单");
			resultJO=getDingDanByZt(0,bfh,DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT,DingDan.YI_WAN_CHENG,DingDan.DAI_XIA_BANG);
			break;
		}
		
		String status = resultJO.getString("status");
		if("ok".equals(status)) {
			JSONObject dingDanJO=resultJO.getJSONObject("dingDan");
			int ddId = dingDanJO.getInt("id");
			JSONObject gbjlResultJO=selectGuoBangJiLuByDdId(ddId,gblx);
			
			GuoBangJiLu gbjl=(GuoBangJiLu)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(gbjlResultJO.get("gbjl").toString()), GuoBangJiLu.class);
			
	        BangDanPrint bdp=new BangDanPrint(gbjl,BangDanPrint.GUO_BANG_JI_LU);
	        XPPrinter xpp=new XPPrinter(bdp);
	        xpp.printer();
		}
		else {
        	System.out.println("message==="+resultJO.getString("message"));
        	System.out.println("音柱播报：找不到相关过磅记录");
		}
	}
	
	/**
	 * 打印磅单记录小票
	 */
	public static void printBdjl() {
		System.out.println("打印磅单记录小票");
		Integer bfh = LoadProperties.getBangFangHao();
		System.out.println("查询订单状态为二检上磅，二检状态为待下磅的订单");
		JSONObject resultJO=getDingDanByZt(0,bfh,DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT,DingDan.YI_WAN_CHENG,DingDan.DAI_XIA_BANG);
		String status = resultJO.getString("status");
		if("ok".equals(status)) {
			JSONObject dingDanJO=resultJO.getJSONObject("dingDan");
			int ddId = dingDanJO.getInt("id");
			JSONObject bdjlResultJO=selectBangDanJiLuByDdId(ddId);

			BangDanJiLu bdjl=(BangDanJiLu)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(bdjlResultJO.get("bdjl").toString()), BangDanJiLu.class);
			
	        BangDanPrint bdp=new BangDanPrint(bdjl,BangDanPrint.BANG_DAN_JI_LU);
	        XPPrinter xpp=new XPPrinter(bdp);
	        xpp.printer();
		}
		else {
        	System.out.println("message==="+resultJO.getString("message"));
        	System.out.println("音柱播报：找不到相关磅单记录");
		}
	}
	
	public static JSONObject selectGuoBangJiLuByDdId(Integer ddId, Integer gblx) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("ddId", ddId);
	        parames.put("gblx", gblx);
	        resultJO = doHttp("selectGuoBangJiLuByDdId",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static void updateEJCZDDXX() {
		/*
		checkEJSBHWGSState();
		checkEJSBHXBHWGSState();
		erJianChengZhongZhong();
		checkEJXBHWGSState();
		checkIfEJXBYwc();
		*/
	}
	
	public static void playWeight(float djczl, int jyFlag) {
		YinZhuTask.sendMsg(YzZlUtil.get98().replaceAll(" ", ""), 1500,jyFlag);
		String djczlStr = String.valueOf((int)djczl);
		System.out.println("djczlStr==="+djczlStr);
		for (int i = 0; i < djczlStr.length(); i++) {
			char ch = djczlStr.charAt(i);
			
			String chStr = String.valueOf(ch);
			System.out.println("chStr==="+chStr);
			int chi = Integer.parseInt(chStr);
			
			if(chi==0)
				chi=36;
			System.out.println("chi==="+chi);
    		YinZhuTask.sendMsg(YzZlUtil.getByDuanHao(chi).replaceAll(" ", ""), 800,jyFlag);
		}
	}
	
	public static void main(String[] args) {
		//Car car1=new Car();
		//car1.setsLicense(" 鲁B9023");
		//APIUtil.updateYJCPSBDDXX(car1);
		
		//APIUtil.updateYJCZDDXX();

		//Car car2=new Car();
		//car2.setsLicense(" 鲁B9023");
		//APIUtil.updateEJCPSBDDXX(car2);
		
		//APIUtil.updateEJCZDDXX();
		
		//APIUtil.checkDingDanIfExistByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.DAI_SHANG_BANG,DingDan.DAI_SHANG_BANG);
		
		
		//printGbjl(GuoBangJiLu.RU_CHANG_GUO_BANG);
		
		/*
		DingDan dd=new DingDan();
    	dd.setId(83);
    	dd.setDdztMc(DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT);
    	dd.setEjzt(DingDan.DAI_SHANG_BANG);
    	dd.setEjbfh(2);
    	APIUtil.editDingDan(dd);
    	*/
		
		//JSONObject resultJO=APIUtil.getDingDan("9005",DingDanZhuangTai.ER_JIAN_PAI_DUI_ZHONG_TEXT);
	}
}
