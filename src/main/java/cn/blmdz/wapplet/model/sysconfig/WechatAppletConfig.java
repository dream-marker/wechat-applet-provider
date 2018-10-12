package cn.blmdz.wapplet.model.sysconfig;

import lombok.Data;

@Data
public class WechatAppletConfig {
    /**
     * 展示名称
     */
    private String showName;
    /**
     * 展示图片
     */
    private String showImage;
    /**
     * 展示排序
     */
    private Integer showOrder;
    
    /**
     * 广告图
     */
    private String adImage;
    /**
     * 唤起地址
     */
    private String arouseUrl;
    
    /**
     * appId
     */
    private String appId;
    /**
     * appSecret
     */
    private String appSecret;
}
