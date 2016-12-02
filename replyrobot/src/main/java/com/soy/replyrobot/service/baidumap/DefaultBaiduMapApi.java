package com.soy.replyrobot.service.baidumap;

import java.io.IOException;

import com.soy.replyrobot.service.baidumap.exception.BaiduApiException;
import com.soy.replyrobot.service.baidumap.param.BaiduApiParam;
import com.soy.replyrobot.service.baidumap.param.GeocoderParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;
import com.soy.replyrobot.service.baidumap.paramtool.ParseParamTool;
import com.soy.replyrobot.service.baidumap.paramtool.ParseParamToolFactory;
import com.soy.replyrobot.service.baidumap.tool.DefaultHttpTool;
import com.soy.replyrobot.service.baidumap.tool.HttpTool;

public class DefaultBaiduMapApi implements BaiduMapApi {
	
	/**
	 * 开发者密钥
	 * @since
	 */
	private String ak;
	
	/**
	 * 解析参数工具
	 * @since
	 */
	private ParseParamTool parseParamTool = ParseParamToolFactory.createIgnoreTest();
	
	/**
	 * 连接工具
	 * @since
	 */
	private HttpTool httpTool = new DefaultHttpTool();
	
	public DefaultBaiduMapApi(String ak){
		this.ak = ak;
		parseParamTool.setAk(ak);
	}
	
	
	@Override
	public String highacciploc(HighacciplocParam param) {
		return execute(param);
	}
	
	@Override
	public String geocoder(GeocoderParam param) {
		return execute(param);
	}
	
	/**
	 * <p>所有方法都可以这样执行</p>
	 * @author zhengsiyou
	 * @param param
	 * @return 
	 */
	private String execute(BaiduApiParam param){
		try {
			String url = getFullUrl(param);
			System.err.format("url请求地址：%s\n", url);
			return httpTool.connect(url);
		} catch (IOException e) {
			throw new BaiduApiException(e);
		}
	}
	
	/**
	 * <p>获取完整的url（带参数）</p>
	 * @author zhengsiyou
	 * @param param	参数
	 * @return 
	 */
	private String getFullUrl(BaiduApiParam param){
		StringBuilder sb = new StringBuilder(param.apiUrl());
		String paramStr = parseParamTool.parse(param);
		if(paramStr==null){
			throw new BaiduApiException("参数列表为null");
		}else if(paramStr.length()>0){
			sb.append('?');
			sb.append(paramStr);
		}
		return sb.toString();
	}



}
