package cn.blmdz.wapplet.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.pagehelper.PageHelper;

/**
 * 额外总配置文件
 * @author xpoll
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    

    
	/**
	 * 分页插件
	 */
	@Bean
    public PageHelper pageHelper(DataSource dataSource) {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
	
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        // 用于html的后缀匹配
//        configurer.setUseSuffixPatternMatch(false);
//    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域访问
        registry.addMapping("/**")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedOrigins(CorsConfiguration.ALL)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true)
                .maxAge(3600);
        
        /**
         * registry.addMapping("/**").maxAge(3600);
         * 
         * 或者在Interceptor或过滤器中增加以下配置
         * 
         * response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8088"); // cookie信息携带必须设置来源
         * response.setHeader("Access-Control-Allow-Credentials", "true"); // 携带cookie信息
         * response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
         * response.setHeader("Access-Control-Max-Age", "3600");
         * response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
         */
    }
	
}
