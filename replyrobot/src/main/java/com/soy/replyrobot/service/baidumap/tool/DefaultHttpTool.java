package com.soy.replyrobot.service.baidumap.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class DefaultHttpTool implements HttpTool {

	@Override
	public String connect(String url) throws IOException {
		URL u = new URL(url);
		URLConnection urlConnection = u.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
		StringWriter sw = new StringWriter();
		char[] buf = new char[8196];
		int len;
		while((len = isr.read(buf)) != -1){
			sw.write(buf, 0, len);
		}
		isr.close();
		inputStream.close();
		return sw.toString();
	}

}
