package com.soy.replyrobot.service.baidumap;

import java.io.IOException;

import com.soy.replyrobot.service.baidumap.exception.BaiduApiException;
import com.soy.replyrobot.service.baidumap.param.BaiduApiParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;
import com.soy.replyrobot.service.baidumap.tool.DefaultHttpTool;
import com.soy.replyrobot.service.baidumap.tool.HttpTool;
import com.soy.replyrobot.service.baidumap.tool.ParseParamTool;
import com.soy.replyrobot.service.baidumap.tool.ParseParamToolFactory;

public class BaiduMapApiImpl implements BaiduMapApi {
	
	/**
	 * 开发者密钥
	 * @since
	 */
	private String ak;
	
	/**
	 * 解析参数工具
	 * @since
	 */
	private ParseParamTool parseParamTool;
	
	/**
	 * 连接工具
	 * @since
	 */
	private HttpTool httpTool = new DefaultHttpTool();
	
	public BaiduMapApiImpl(String ak){
		this.ak = ak;
		parseParamTool = ParseParamToolFactory.create(ak);
	}
	
	
	@Override
	public String highacciploc(HighacciplocParam param) {
		try {
			String url = getFullUrl(HIGHACCIPLOC_URL,param);
			return httpTool.connect(url);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * <p>TODO</p>
	 * @author zhengsiyou
	 * @date 2016年12月2日-下午1:37:26
	 * @param url	api的url
	 * @param param	参数
	 * @return 
	 * @since 
	 */
	private String getFullUrl(String url,BaiduApiParam param){
		StringBuilder sb = new StringBuilder(HIGHACCIPLOC_URL);
		String paramStr = parseParamTool.parse(param);
		if(paramStr==null){
			throw new BaiduApiException("参数列表为null");
		}else if(paramStr.length()>0){
			sb.append('?');
			sb.append(paramStr);
			return sb.toString();
		}else{
			return "";
		}
	}

}
