package com.znczLfylGkj.entity;

public class DingDanZhuangTai {

	public static final String DAI_SHEN_HE_TEXT="待审核";
	public static final String YI_SHEN_HE_TEXT="已审核";
	public static final String PAI_DUI_ZHONG_TEXT="排队中";
	public static final String YI_JIAN_SHANG_BANG_TEXT="一检上磅";

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Integer getPx() {
		return px;
	}
	public void setPx(Integer px) {
		this.px = px;
	}
	private String mc;
	private Integer px;
}
