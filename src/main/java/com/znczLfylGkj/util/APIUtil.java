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

import com.znczLfylGkj.entity.*;

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
	
	public static JSONObject editBangDanJiLu(Integer id, Float mz) {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("id", id);
	        parames.put("mz", mz);
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
	
	public static void zhuaPaiHuiDiao(String cph) {
		System.out.println("查询订单状态为排队中的订单");
		JSONObject resultJO=APIUtil.getDingDan(cph,DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);
        if("ok".equals(resultJO.getString("status"))) {
        	System.out.println("存在该订单");
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
        else {
        	System.out.println("message==="+resultJO.getString("message"));
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
		float zhongLiang=4998;
		JSONObject gbjlJO=APIUtil.selectBangDanJiLuByDdId(dd1.getId());
		JSONObject bdJO=gbjlJO.getJSONObject("bdjl");
		int bdId = bdJO.getInt("id");
		APIUtil.editBangDanJiLu(bdId,zhongLiang);

		System.out.println("更改订单的实际重量、重量差额比");
    	DingDan dd2=new DingDan();
    	dd2.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
    	dd2.setYjzt(DingDan.SHANG_BANG_ZHONG);
    	dd2.setSjzl(zhongLiang);
    	dd2.setZlceb(dd1.getYzxzl()/zhongLiang);
		APIUtil.editDingDanByZt(dd2);

		//float zhongLiang=2998;
		System.out.println("生成一检过磅记录");
		GuoBangJiLu gbjl=new GuoBangJiLu();
		gbjl.setGbzl(zhongLiang);
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
    	dd3.setId(10);
    	dd3.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
    	dd3.setXddztMc(DingDanZhuangTai.DAI_YI_JIAN_SHEN_HE_TEXT);
    	dd3.setYjzt(DingDan.SHANG_BANG_ZHONG);
    	dd3.setXyjzt(DingDan.YI_WAN_CHENG);
    	APIUtil.editDingDanByZt(dd3);
	}
	
	public static void main(String[] args) {
		//APIUtil.zhuaPaiHuiDiao("9028");
		APIUtil.yiJianShangBang();
		
		//这里是磅房外的车牌识别摄像头抓拍到车牌号后回调的方法，回调时根据抓拍到的车牌号找到状态是排队中的订单（每次只能获得一条订单，根据上一部审核的先后顺序，先来后到，先审核的先进行车牌识别）
		//识别后根据抓拍到的订单号与订单里的订单号对比，一致的话抬起道闸，订单状态变为一检上磅
	}
}
