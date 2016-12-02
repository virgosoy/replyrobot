package com.soy.replyrobot.service.baidumap.param;

/**
 * <p>经纬度位置</p>
 * @author zhengsiyou
 */
public class Location {
	//纬度
	private double lat;
	//经度
	private double lng;
	
	public Location(){
	}
	/**
	 * @param lat 纬度
	 * @param lng 经度
	 */
	public Location(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	/**
	 * @param lat 纬度
	 * @param lng 经度
	 */
	public Location(String lat, String lng) {
		this.lat = Double.parseDouble(lat);
		this.lng = Double.parseDouble(lng);
	}


	/**
	 * <p>获取纬度</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * <p>设置纬度</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * <p>获取经度</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * <p>设置经度</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return lat+","+lng;
	}
}
