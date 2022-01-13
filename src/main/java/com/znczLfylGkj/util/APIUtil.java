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
		System.out.println("��ѯ����״̬Ϊ�Ŷ��еĶ���");
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
		System.out.println("���Ҷ���״̬Ϊһ���ϰ��Ķ�������һ���ϰ�״̬�Ӵ��ϰ�����Ϊ�ϰ���");
		DingDan dd=new DingDan();
		dd.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
		dd.setYjzt(DingDan.DAI_SHANG_BANG);
		dd.setXyjzt(DingDan.SHANG_BANG_ZHONG);
		APIUtil.editDingDanByZt(dd);
		
		System.out.println("��ѯ����״̬Ϊһ���ϰ���һ��״̬Ϊ�ϰ��еĶ���");
		JSONObject resultJO=APIUtil.getDingDanByZt(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT,DingDan.SHANG_BANG_ZHONG,DingDan.DAI_SHANG_BANG);
		DingDan dd1=(DingDan)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(resultJO.get("dingDan").toString()), DingDan.class);
		System.out.println("���ݳ��س������������޸Ķ�����Ӧ�İ�����¼");
		float zhongLiang=4998;
		JSONObject gbjlJO=APIUtil.selectBangDanJiLuByDdId(dd1.getId());
		JSONObject bdJO=gbjlJO.getJSONObject("bdjl");
		int bdId = bdJO.getInt("id");
		APIUtil.editBangDanJiLu(bdId,zhongLiang);

		System.out.println("���Ķ�����ʵ����������������");
    	DingDan dd2=new DingDan();
    	dd2.setDdztMc(DingDanZhuangTai.YI_JIAN_SHANG_BANG_TEXT);
    	dd2.setYjzt(DingDan.SHANG_BANG_ZHONG);
    	dd2.setSjzl(zhongLiang);
    	dd2.setZlceb(dd1.getYzxzl()/zhongLiang);
		APIUtil.editDingDanByZt(dd2);

		//float zhongLiang=2998;
		System.out.println("����һ�������¼");
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
		
		System.out.println("���Ķ���״̬Ϊ��һ����ˡ�һ��״̬Ϊ�����");
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
		
		//�����ǰ�����ĳ���ʶ������ͷץ�ĵ����ƺź�ص��ķ������ص�ʱ����ץ�ĵ��ĳ��ƺ��ҵ�״̬���Ŷ��еĶ�����ÿ��ֻ�ܻ��һ��������������һ����˵��Ⱥ�˳�������󵽣�����˵��Ƚ��г���ʶ��
		//ʶ������ץ�ĵ��Ķ������붩����Ķ����ŶԱȣ�һ�µĻ�̧���բ������״̬��Ϊһ���ϰ�
	}
}
