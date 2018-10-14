package cn.blmdz.wapplet.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel.Type;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class WechatAppletVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 应用ID
     */
    private Integer id;
    
    /**
     * appId
     */
    private String appId;
    /**
     * 应用类型
     */
    @Getter(AccessLevel.NONE)
    private Type typeEnum;
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
    @JsonIgnore
    private Integer showOrder;
    /**
     * 是否有广告图
     */
    private Boolean ad;
    /**
     * 广告图
     */
    private String adImage;
    /**
     * 是否可以唤起
     */
    private Boolean arouse;
    /**
     * 唤起地址
     */
    private String arouseUrl;
    /**
     * 人数
     */
    private Integer people;

    //----------------json 前端
    
    public Integer getType() {
        return this.typeEnum.code();
    }
    
    public String getTypeName() {
        return this.typeEnum.description();
    }
}
