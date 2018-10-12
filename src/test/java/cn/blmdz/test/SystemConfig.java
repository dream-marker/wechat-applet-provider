package cn.blmdz.test;

import com.alibaba.fastjson.JSON;

import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;

public class SystemConfig {
	public static void main(String[] args) {
		WechatAppletConfig wechatAppletConfig = new WechatAppletConfig();
		wechatAppletConfig.setShowName("木逸萧的社区");
		wechatAppletConfig.setShowImage("http://q.img.blmdz.cn/home/2018101211170688118886.jpg");
		wechatAppletConfig.setShowOrder(1);
		wechatAppletConfig.setAppId("wxe999d4c1904d3f23");
		wechatAppletConfig.setAppSecret("ddd36814cdd616810d390e4e5131260e");
		System.out.println(JSON.toJSONString(wechatAppletConfig));
	}
}
