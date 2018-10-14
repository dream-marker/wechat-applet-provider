package cn.blmdz.wapplet.base;

import java.text.SimpleDateFormat;

/**
 * 常量
 * @author xpoll
 */
public class Constants {
	
	//############################  [配置]  ###################################

	//############################  [时间]  ###################################
	public final static String TIMEZONE = "Asia/Shanghai"; // GMT+08:00 因为有1990-09-11差一天的问题（有的好的）
	public final static String YHS = "yyyyMMddHHmmss.SSS";
	public final static String YH = "yyyy-MM-dd HH:mm:ss";
	public final static String Y = "yyyy-MM-dd";
	public final static String YM = "yyyyMM";
	public final static SimpleDateFormat SDF_YHS = new SimpleDateFormat(YHS);
	public final static SimpleDateFormat SDF_YH = new SimpleDateFormat(YH);
	public final static SimpleDateFormat SDF_Y = new SimpleDateFormat(Y);
	public final static SimpleDateFormat SDF_YM = new SimpleDateFormat(YM);
	
	//############################  [默认]  ###################################
}
