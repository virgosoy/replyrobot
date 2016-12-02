package com.soy.replyrobot.service.baidumap.tool;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * <p>HTTP连接工具</p>
 * @author zhengsiyou
 */
public interface HttpTool {
	
	/**
	 * <p>访问url返回String内容</p>
	 * @author zhengsiyou
	 * @param url
	 * @return 
	 * @throws IOException 
	 */
	public String connect(String url) throws IOException;
	
//	public String connect(String url,Map<String,Object> params,RequestMethod method);
	
}
