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
		// �����������  
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
		connection.setRequestMethod("POST");//����post��ʽ
		connection.setDoInput(true); 
		connection.setDoOutput(true); 
		//header�ڵĵĲ���������set    
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
			/*
	        parames.put("xddztMc", dd.getXddztMc());
	        parames.put("xyjzt", dd.getXyjzt());
	        parames.put("xejzt", dd.getXejzt());
	        */
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
	
	public static JSONObject editBangDanJiLu() {
		JSONObject resultJO = null;
		try {
			Map parames = new HashMap<String, String>();
	        parames.put("ddId", 7);
	        parames.put("mz", 1000);
	        resultJO = APIUtil.doHttp("editBangDanJiLu",parames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	public static void zhuaPaiHuiDiao(String cph) {
		JSONObject resultJO=APIUtil.getDingDan(cph,DingDanZhuangTai.PAI_DUI_ZHONG_TEXT);
        if("ok".equals(resultJO.getString("status"))) {
        	System.out.println("���ڸö���");
        	System.out.println("̧���բ");
        	JSONObject ddJO=resultJO.getJSONObject("dingDan");
        	System.out.println("ddId==="+ddJO.getInt("id"));
        	System.out.println("���ɰ�����¼");
        	APIUtil.newBangDanJiLu(ddJO.getInt("id"));
        	System.out.println("�ı䶩��״̬Ϊһ���ϰ�");
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
		DingDan dd=new DingDan();
		dd.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
		dd.setYjzt(DingDan.DAI_SHANG_BANG);
		dd.setXyjzt(DingDan.SHANG_BANG_ZHONG);
		APIUtil.editDingDanByZt(dd);
		
		//JSONObject resultJO=APIUtil.getDingDanByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.SHANG_BANG_ZHONG,DingDan.DAI_SHANG_BANG);
		
	}
	
	public static void main(String[] args) {
		//APIUtil.zhuaPaiHuiDiao("9028");
		APIUtil.yiJianShangBang();
		
		//�����ǰ�����ĳ���ʶ������ͷץ�ĵ����ƺź�ص��ķ������ص�ʱ����ץ�ĵ��ĳ��ƺ��ҵ�״̬���Ŷ��еĶ�����ÿ��ֻ�ܻ��һ��������������һ����˵��Ⱥ�˳�������󵽣�����˵��Ƚ��г���ʶ��
		//ʶ������ץ�ĵ��Ķ������붩����Ķ����ŶԱȣ�һ�µĻ�̧���բ������״̬��Ϊһ���ϰ�
	}
}
