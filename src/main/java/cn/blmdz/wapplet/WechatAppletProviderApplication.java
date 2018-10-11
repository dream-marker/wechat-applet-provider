package cn.blmdz.wapplet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.blmdz.wapplet.dao")
public class WechatAppletProviderApplication {
    
	public static void main(String[] args) {
	    SpringApplication.run(WechatAppletProviderApplication.class, args);
	}
}
