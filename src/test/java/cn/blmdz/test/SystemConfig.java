package cn.blmdz.test;

import com.alibaba.fastjson.JSON;

import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;

public class SystemConfig {
	public static void main(String[] args) {
		WechatAppletConfig wechatAppletConfig = new WechatAppletConfig();
		wechatAppletConfig.setAppId("");
		wechatAppletConfig.setAppSecret("");
		System.out.println(JSON.toJSONString(wechatAppletConfig));
	}
}
