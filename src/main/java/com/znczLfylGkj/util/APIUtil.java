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
import com.znczLfylGkj.task.YinZhuTask;
import com.znczLfylGkj.yz.YzZlUtil;

public class APIUtil {
	
	public static final String SERVICE_URL="http://localhost:8080/ZnczLfyl/gkj/";

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
	        resultJO = APIUtil.doHttp("getDingDan",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}

	public static JSONObject getDingDanByZt(String ddztMc, Integer yjzt, Integer ejzt) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("ddztMc", ddztMc);
	        parames.put("yjzt", yjzt);
	        parames.put("ejzt", ejzt);
	        resultJO = APIUtil.doHttp("getDingDanByZt",parames);
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
	        resultJO = APIUtil.doHttp("editDingDan",parames);
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
	        resultJO = APIUtil.doHttp("editDingDanByZt",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject newBangDanJiLu(Integer ddId) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("ddId", ddId);  
	        resultJO = APIUtil.doHttp("newBangDanJiLu",parames);
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
	        resultJO = APIUtil.doHttp("editBangDanJiLu",parames);
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
	        resultJO = APIUtil.doHttp("selectBangDanJiLuByDdId",parames);
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
	        resultJO = APIUtil.doHttp("newGuoBangJiLu",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static JSONObject checkDingDanIfExistByZt(String ddztMc, Integer yjzt, Integer ejzt) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
			parames.put("ddztMc", ddztMc);
			parames.put("yjzt", yjzt);
			parames.put("ejzt", ejzt);
			resultJO = APIUtil.doHttp("checkDingDanIfExistByZt",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	/**
	 * 更新一检车牌识别订单信息
	 * @param car
	 */
	public static void updateYJCPSBDDXX(Car car) {
		System.out.println("查询订单状态为排队中的订单");
		JSONObject resultJO=APIUtil.getDingDan(car.getsLicense(),DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);
        if("ok".equals(resultJO.getString("status"))) {
        	System.out.println("存在该订单");
        	System.out.println("根据其他订单状态验证是否存在其他订单");
        	JSONObject ddExistResult = APIUtil.checkDingDanIfExistByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.DAI_SHANG_BANG,DingDan.DAI_SHANG_BANG);
        	if("ok".equals(ddExistResult.getString("status"))) {
            	System.out.println("音柱播报：其他订单状态存在其他订单");
        	}
        	else {
	        	System.out.println("抬起道闸");
	        	JSONObject ddJO=resultJO.getJSONObject("dingDan");
	        	System.out.println("ddId==="+ddJO.getInt("id"));
	        	System.out.println("生成磅单记录");
	        	APIUtil.newBangDanJiLu(ddJO.getInt("id"));
	        	System.out.println("改变订单状态为一检上磅");
	        	DingDan dd=new DingDan();
	        	dd.setId(ddJO.getInt("id"));
	        	dd.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
	        	dd.setYjzt(DingDan.DAI_SHANG_BANG);
	        	APIUtil.editDingDan(dd);
        	}
        }
        else {
        	System.out.println("message==="+resultJO.getString("message"));
        	System.out.println("音柱播报：没有找到匹配订单");
    		YinZhuTask.sendMsg(YzZlUtil.get86().replaceAll(" ", ""), 1500,YinZhuTask.YI_JIAN);
        }
	}
	
	public static void yiJianShangBang() {
		System.out.println("查找订单状态为一检上磅的订单，将一检上磅状态从待上磅更改为上磅中");
		DingDan dd=new DingDan();
		dd.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
		dd.setYjzt(DingDan.DAI_SHANG_BANG);
		dd.setXyjzt(DingDan.SHANG_BANG_ZHONG);
		APIUtil.editDingDanByZt(dd);
		
		System.out.println("查询订单状态为一检上磅，一检状态为上磅中的订单");
		JSONObject resultJO=APIUtil.getDingDanByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.SHANG_BANG_ZHONG,DingDan.DAI_SHANG_BANG);
		DingDan dd1=(DingDan)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(resultJO.get("dingDan").toString()), DingDan.class);
		System.out.println("根据称重出来的重量，修改订单对应的磅单记录");
		Float mz=null;
		Float pz=null;
		Float jz=null;
		JSONObject gbjlJO=APIUtil.selectBangDanJiLuByDdId(dd1.getId());
		JSONObject bdJO=gbjlJO.getJSONObject("bdjl");
		int bdId = bdJO.getInt("id");
		if(dd1.getLxlx()==DingDan.SONG_YUN) {
			mz=(float)5000;
		}
		else {
			pz=(float)1000;
		}
		APIUtil.editBangDanJiLu(bdId,mz,pz,jz);

    	if(dd1.getLxlx()==DingDan.SONG_YUN) {
			System.out.println("更改订单的实际重量、重量差额比");
	    	DingDan dd2=new DingDan();
	    	dd2.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
	    	dd2.setYjzt(DingDan.SHANG_BANG_ZHONG);
	    	dd2.setSjzl(mz);
	    	dd2.setZlceb(dd1.getYzxzl()/mz);
	    	APIUtil.editDingDanByZt(dd2);
    	}

		//float zhongLiang=2998;
		System.out.println("生成一检过磅记录");
		GuoBangJiLu gbjl=new GuoBangJiLu();
		if(dd1.getLxlx()==DingDan.SONG_YUN)
			gbjl.setGbzl(mz);
		else
			gbjl.setGbzl(pz);
		//gbjl.setZp1(zp1);
		//gbjl.setZp2(zp2);
		//gbjl.setZp3(zp3);
		gbjl.setGbzt(GuoBangJiLu.ZHENG_CHANG);
		gbjl.setGblx(GuoBangJiLu.RU_CHANG_GUO_BANG);
		gbjl.setDdId(dd1.getId());
		//gbjl.setDdId(16);
		APIUtil.newGuoBangJiLu(gbjl);
		
		System.out.println("更改订单状态为待一检审核、一检状态为已完成");
    	DingDan dd3=new DingDan();
    	dd3.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
    	dd3.setXddztMc(DingDanZhuangTai.DAI_YI_JIAN_SHEN_HE_TEXT);
    	dd3.setYjzt(DingDan.SHANG_BANG_ZHONG);
    	dd3.setXyjzt(DingDan.YI_WAN_CHENG);
    	APIUtil.editDingDanByZt(dd3);
	}
	
	public static void erJianShangBang() {
		System.out.println("查找订单状态为二检上磅的订单，将二检上磅状态从待上磅更改为上磅中");
		DingDan dd=new DingDan();
		dd.setDdztMc(DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT);
		dd.setYjzt(DingDan.YI_WAN_CHENG);
		dd.setEjzt(DingDan.DAI_SHANG_BANG);
		dd.setXejzt(DingDan.SHANG_BANG_ZHONG);
		APIUtil.editDingDanByZt(dd);

		System.out.println("查询订单状态为二检上磅，二检状态为上磅中的订单");
		JSONObject resultJO=APIUtil.getDingDanByZt(DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT,DingDan.YI_WAN_CHENG,DingDan.SHANG_BANG_ZHONG);
		DingDan dd1=(DingDan)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(resultJO.get("dingDan").toString()), DingDan.class);
		System.out.println("根据称重出来的重量，修改订单对应的磅单记录");
		Float mz=null;
		Float pz=null;
		Float jz=null;
		JSONObject gbjlJO=APIUtil.selectBangDanJiLuByDdId(dd1.getId());
		JSONObject bdJO=gbjlJO.getJSONObject("bdjl");
		int bdId = bdJO.getInt("id");
		if(dd1.getLxlx()==DingDan.SONG_YUN) {
			mz=(float)bdJO.getDouble("mz");
			pz=(float)1000;
			jz=mz-pz;
			APIUtil.editBangDanJiLu(bdId,null,pz,jz);
		}
		else {
			mz=(float)5000;
			pz=(float)bdJO.getDouble("pz");
			jz=mz-pz;
			APIUtil.editBangDanJiLu(bdId,mz,pz,jz);
		}
		
    	if(dd1.getLxlx()==DingDan.QU_YUN) {
			System.out.println("更改订单的实际重量、重量差额比");
	    	DingDan dd2=new DingDan();
	    	dd2.setDdztMc(DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT);
	    	dd2.setYjzt(DingDan.YI_WAN_CHENG);
	    	dd2.setEjzt(DingDan.SHANG_BANG_ZHONG);
	    	dd2.setSjzl(mz);
	    	dd2.setZlceb(dd1.getYzxzl()/mz);
	    	APIUtil.editDingDanByZt(dd2);
    	}
		
		System.out.println("生成二检过磅记录");
		GuoBangJiLu gbjl=new GuoBangJiLu();
		if(dd1.getLxlx()==DingDan.SONG_YUN)
			gbjl.setGbzl(pz);
		else
			gbjl.setGbzl(mz);
		//gbjl.setZp1(zp1);
		//gbjl.setZp2(zp2);
		//gbjl.setZp3(zp3);
		gbjl.setGbzt(GuoBangJiLu.ZHENG_CHANG);
		gbjl.setGblx(GuoBangJiLu.CHU_CHANG_GUO_BANG);
		gbjl.setDdId(dd1.getId());
		APIUtil.newGuoBangJiLu(gbjl);
		
		System.out.println("更改订单状态为待二检审核、二检状态为已完成");
    	DingDan dd3=new DingDan();
    	dd3.setDdztMc(DingDanZhuangTai.ER_JIAN_SHANG_BANG_TEXT);
    	dd3.setXddztMc(DingDanZhuangTai.DAI_ER_JIAN_SHEN_HE_TEXT);
    	dd3.setEjzt(DingDan.SHANG_BANG_ZHONG);
    	dd3.setXejzt(DingDan.YI_WAN_CHENG);
    	APIUtil.editDingDanByZt(dd3);
	}
	
	public static void main(String[] args) {
		//APIUtil.updateYJCPSBDDXX("265366");
		//APIUtil.yiJianShangBang();
		APIUtil.erJianShangBang();
		
		//APIUtil.checkDingDanIfExistByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.DAI_SHANG_BANG,DingDan.DAI_SHANG_BANG);
		
		//这里是磅房外的车牌识别摄像头抓拍到车牌号后回调的方法，回调时根据抓拍到的车牌号找到状态是排队中的订单（每次只能获得一条订单，根据上一部审核的先后顺序，先来后到，先审核的先进行车牌识别）
		//识别后根据抓拍到的订单号与订单里的订单号对比，一致的话抬起道闸，订单状态变为一检上磅
	}
}
