package com.soy.replyrobot.service.baidumap.param;

public class HighacciplocParam extends BaiduApiParam {
	
	//待定位ip 可选
	//如果为空，则针对定位服务的IP进行定位
	private String qcip;
	
	//待定位终端类型 必填
	@Required
	private Qterm qterm;
	public static enum Qterm{
		MOBILE("mb"),PC("pc");
		//	mb：终端定位设备类型为移动设备
		//	pc：终端定位设备类型为固定设备
		private String value;
		private Qterm(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//返回结果扩展设定	可选
	private Extensions extensions;
	public static enum Extensions{
		BASE("0"),ADDR("1"),POI("2"),ALL("3");
		//	0（默认）：只返回基础定位结果
		//	1：返回基础定位结果+地址信息
		//	2：返回基础定位结果+周边POI信息
		//	3：返回基础定位结果+地址信息+POI信息
		private String value;
		private Extensions(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//	返回坐标类型	可选，
	private Coord coord;
	public static enum Coord{
		MERCATOR("bd09"),BAIDU("bd09ll"),GCJ("gcj02");
		//	bd09（默认）：百度墨卡托坐标
		//	bd09ll：百度经纬度坐标
		//	gcj02：国测局经纬度坐标
		private String value;
		private Coord(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	//	返回结果编码类型	可选，
	private Coding coding;
	public static enum Coding{
		UTF8("utf-8"),GBK("gbk");
		//	utf-8（默认）：返回UTF-8类型
		//	gbk：返回GBK类型
		private String value;
		private Coding(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//	回调方式选择	必选，
	@Required
	private CallbackType callback_type;
	public static enum CallbackType{
		JSON("json"),JSONP("jsonp");
		//	json（默认）：json方式
		//	jsonp：jsonp方式，需设置callback参数
		private String value;
		private CallbackType(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//	jsonp回调函数	
	// 当callback_type=jsonp时，必填，取值为开发者所设置回调函数名
	@Required(relation="callback_type",relationValue="jsonp")
	private String callback;

	
	public String getQcip() {
		return qcip;
	}

	public void setQcip(String qcip) {
		this.qcip = qcip;
	}

	public Qterm getQterm() {
		return qterm;
	}

	public void setQterm(Qterm qterm) {
		this.qterm = qterm;
	}

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Coding getCoding() {
		return coding;
	}

	public void setCoding(Coding coding) {
		this.coding = coding;
	}

	public CallbackType getCallback_type() {
		return callback_type;
	}

	public void setCallback_type(CallbackType callback_type) {
		this.callback_type = callback_type;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
	
}
