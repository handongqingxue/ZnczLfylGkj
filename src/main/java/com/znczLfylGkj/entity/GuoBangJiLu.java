package com.znczLfylGkj.entity;

public class GuoBangJiLu {

	public static final Integer ZHENG_CHANG=1;
	public static final Integer YI_CHANG=2;
	
	public static final Integer RU_CHANG_GUO_BANG=1;
	public static final Integer CHU_CHANG_GUO_BANG=2;
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getGbzl() {
		return gbzl;
	}
	public void setGbzl(Float gbzl) {
		this.gbzl = gbzl;
	}
	public String getZp1() {
		return zp1;
	}
	public void setZp1(String zp1) {
		this.zp1 = zp1;
	}
	public String getZp2() {
		return zp2;
	}
	public void setZp2(String zp2) {
		this.zp2 = zp2;
	}
	public String getZp3() {
		return zp3;
	}
	public void setZp3(String zp3) {
		this.zp3 = zp3;
	}
	public Integer getGbzt() {
		return gbzt;
	}
	public void setGbzt(Integer gbzt) {
		this.gbzt = gbzt;
	}
	public String getGbsj() {
		return gbsj;
	}
	public void setGbsj(String gbsj) {
		this.gbsj = gbsj;
	}
	public Integer getGblx() {
		return gblx;
	}
	public void setGblx(Integer gblx) {
		this.gblx = gblx;
	}
	public Integer getDdId() {
		return ddId;
	}
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	private Float gbzl;
	private String zp1;
	private String zp2;
	private String zp3;
	private Integer gbzt;
	private String gbsj;
	private Integer gblx;
	private Integer ddId;
	private String ddh;
	private String cph;
}
