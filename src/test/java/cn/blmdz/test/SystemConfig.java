package cn.blmdz.test;

import com.alibaba.fastjson.JSON;

import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;

public class SystemConfig {
	public static void main(String[] args) {
		WechatAppletConfig wechatAppletConfig = new WechatAppletConfig();
		wechatAppletConfig.setShowName("木逸萧的社区");
		wechatAppletConfig.setShowImage("http://q.img.blmdz.cn/home/2018101211170688118886.jpg");
		wechatAppletConfig.setShowOrder(1);
		wechatAppletConfig.setArouse(false);
		wechatAppletConfig.setAppId("");
		wechatAppletConfig.setAppSecret("");
		System.out.println(JSON.toJSONString(wechatAppletConfig));
		wechatAppletConfig.setShowName("Xpoll的游戏乐园");
		wechatAppletConfig.setShowImage("http://q.img.blmdz.cn/home/2018101422232493961906.jpg");
		wechatAppletConfig.setShowOrder(3);
		wechatAppletConfig.setArouse(true);
		wechatAppletConfig.setArouseUrl("");
		wechatAppletConfig.setAppId("");
		wechatAppletConfig.setAppSecret("");
		System.out.println(JSON.toJSONString(wechatAppletConfig));
	}
}
