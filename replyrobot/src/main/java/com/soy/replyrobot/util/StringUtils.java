package com.soy.replyrobot.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>字符串工具类</p>
 * <p>StringUtils</p>
 * @author zhengsiyou
 * @data 2016-10-27 22:11:53
 * @version 2.0
 * @since jdk1.7
 */
public class StringUtils {
	/**
	 * 空判断
	 * @param content
	 * @return
	 */
	public static boolean isEmpty(String content){
		return content == null || content.length() == 0 || "".equals(content)
				|| content.matches("\\s*");
	}
	
	/**
	 * 非空判断
	 * @param content
	 * @return
	 */
	public static boolean isNotEmpty(String content){
		return !isEmpty(content);
	}
	
	
	
	/**
	 * 格式化日期
	 * com.soy.util
	 * 方法名：formatDate
	 * @author zhengsiyou
	 * @date 2015年9月15日-下午5:17:12
	 * @param date
	 * @param pattern
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String formatDate(Date date,String pattern){
		if(date!=null){
			return new SimpleDateFormat(pattern).format(date);
		}else{
			return "";
		}
	}
	
	
	/**
	 * 获取文件扩展名
	 * com.soy.util
	 * 方法名：getExt
	 * @author zhengsiyou
	 * @date 2015年10月13日-下午9:15:10
	 * @param filename 文件名或文件路径
	 * @param returnPoint 是否保留"."
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String getExt(String filename, boolean returnPoint){
		if(StringUtils.isNotEmpty(filename)){
			int pointPos = filename.lastIndexOf(".");
			int slashPos = filename.lastIndexOf("/");
			int escapePos = filename.lastIndexOf("\\");
			if(pointPos>slashPos && pointPos>escapePos){ //点号在后
				if(returnPoint){
					return filename.substring(pointPos);
				}else{
					return filename.substring(pointPos+1);
				}
			}
		}
		return "";
	}
	
	/**
	 * 获取文件扩展名（保留.）<br>
	 * com.soy.util
	 * 方法名：getExt
	 * @author zhengsiyou
	 * @date 2015年10月13日-下午9:17:31
	 * @param filename 文件名
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String getExt(String filename){
		return getExt(filename,true);
	}
	
	/**
	 * 生成文件名
	 * com.soy.util
	 * 方法名：generateFileName
	 * @author zhengsiyou
	 * @date 2015年10月13日-下午10:45:12
	 * @param filename 原文件名
	 * @param append 追加文件名前缀尾部的文字
	 * @param pattern 日期格式
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String generateFileName(String filename,String append,String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String date= dateFormat.format(new Date());
		return date+append+getExt(filename);
	}
	
	/**
	 * 生成文件名
	 * com.soy.util
	 * 方法名：generateFileName
	 * @author zhengsiyou
	 * @date 2015年10月13日-下午11:09:58
	 * @param filename 原文件名
	 * @param userId 用户id
	 * @param diffFile 预防重名的int
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String generateFileName(String filename,int userId,int diffFile){
		return generateFileName(filename,"-"+String.valueOf(userId)+"-"+String.valueOf(diffFile),"yyyyMMddHHmmss");
	}
	
	/**
	 * 根据File文件的长度统计文件的大小
	 * @param size
	 *            File的长度 file.lenght()
	 * @return 返回文件大小
	 */
	public static String countFileSize(long fileSize) {
		String fileSizeString = "";
		try {
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = fileSize;
			if (fileS == 0) {
				fileSizeString = "0KB";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df
						.format(((double) fileS / 1024 / 1024) - 0.01)
						+ "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
						+ "GB";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}
	
	
	/**
	 * 重命名
	 * com.soy.util
	 * 方法名：rename
	 * @author zhengsiyou
	 * @date 2015年10月16日-下午5:33:12
	 * @param filename
	 * @param suffix
	 * @return 
	 * 返回类型：String
	 * @since jdk1.6
	*/
	public static String rename(String filename, String suffix){
		if(StringUtils.isNotEmpty(filename)){
			int pointPos = filename.lastIndexOf(".");
			int slashPos = filename.lastIndexOf("/");
			int escapePos = filename.lastIndexOf("\\");
			if(pointPos>slashPos && pointPos>escapePos){ //点号在后
				return filename.substring(0, pointPos) + suffix + filename.substring(pointPos);
			}else{ //无后缀
				return filename + suffix;
			}
		}
		return "";
	}
	
	/**
	 * <p>首字符大写</p>
	 * <p>方法名：toFirstUpperCase</p>
	 * @author zhengsiyou
	 * @date 2016年3月8日-下午3:09:09
	 * @param str
	 * @return 
	 * 返回类型：String
	 * @since 1.1 jdk1.7
	*/
	public static String toFirstUpperCase(String str){
		if(str!=null && str.length()>0){
			char[] cs = str.toCharArray();
			if(cs[0]>=97 && cs[0]<=125){
				cs[0] -= 32;
				return String.valueOf(cs);
			}
		}
		return str;
	}
	
	/**
	 * <p>首字母小写</p>
	 * <p>方法名：toFirstLowerCase</p>
	 * @author zhengsiyou
	 * @date 2016年3月8日-下午3:10:03
	 * @param str
	 * @return 
	 * 返回类型：String
	 * @since 1.1 jdk1.7
	*/
	public static String toFirstLowerCase(String str){
		if(str!=null && str.length()>0){
			char[] cs = str.toCharArray();
			if(cs[0]>=65 && cs[0]<=90){
				cs[0] += 32;
				return String.valueOf(cs);
			}
		}
		return str;
	}
}
