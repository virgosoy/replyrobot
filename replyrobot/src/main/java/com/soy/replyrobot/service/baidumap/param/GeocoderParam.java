package com.soy.replyrobot.service.baidumap.param;

import com.soy.replyrobot.service.baidumap.paramtool.Required;

public class GeocoderParam extends BaiduApiParam {
	
	//输出格式为json或者xml	可选，默认xml
	private Output output;
	public static enum Output{
		JSON("json"),XML("xml");
		private String value;
		private Output(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//若用户所用ak的校验方式为sn校验时该参数必须。 （sn生成算法）	可选。
	private String sn;
	
	/*
		callback=showLocation(JavaScript函数名)	
		将json格式的返回值通过callback函数返回以实现jsonp功能
		可选
	*/
	private String callback;

	

	/* 
	 * 根据指定地址进行坐标的反定向解析，最多支持100个字节输入。
	 * 
	 * 可以输入三种样式的值，分别是： 
	 * 1、标准的地址信息，如北京市海淀区上地十街十号 
	 * 2、名胜古迹、标志性建筑物，如天安门，百度大厦 
	 * 3、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
	 * 
	 * 注意：后两种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
	 * 必须
	 */	
	@Required(relation="location",relationValues=Required.EMPTY)
	private String address;
	
	/*
	 * 地址所在的城市名。用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用。
	 * 可选
	 */
	private String city;
	
	//坐标的类型
	private Coordtype coordtype;
	public static enum Coordtype{
		BAIDU_LL("bd09ll"),BAIDU_MC("bd09mc"),GCJ_LL("gcj02ll"),WGS_LL("wgs84ll");
		//默认bd09ll
		//目前支持的坐标类型包括：
		//bd09ll（百度经纬度坐标）、
		//bd09mc（百度米制坐标）、
		//gcj02ll（国测局经纬度坐标）、
		//wgs84ll（ GPS经纬度）
		private String value;
		private Coordtype(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	//根据经纬度坐标获取地址
	@Required(relation="address",relationValues=Required.EMPTY)
	private Location location;
	
	//是否显示指定位置周边的poi
	private Pois pois;
	public static enum Pois{
		HIDE("0"),SHOW("1");
		//默认0
		//0为不显示，1为显示。当值为1时，显示周边100米内的poi。
		private String value;
		private Pois(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}
	
	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Coordtype getCoordtype() {
		return coordtype;
	}

	public void setCoordtype(Coordtype coordtype) {
		this.coordtype = coordtype;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Pois getPois() {
		return pois;
	}

	public void setPois(Pois pois) {
		this.pois = pois;
	}

	@Override
	public String apiUrl() {
		return "http://api.map.baidu.com/geocoder/v2/";
	}
	
	
}
