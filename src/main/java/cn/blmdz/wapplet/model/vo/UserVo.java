package cn.blmdz.wapplet.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.blmdz.wapplet.base.Constants;
import cn.blmdz.wapplet.model.enums.TableEnumUserArea;
import cn.blmdz.wapplet.model.enums.TableEnumUserGender;
import lombok.Data;

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 性别 */
    private Integer gender;
    /** 区域 */
    private Integer area;
    /** 生日 */
    @JsonFormat(pattern = Constants.Y, timezone = Constants.TIMEZONE)
    private Date birthday;

    //----------------json 前端

    public String getGenderName() {
        return TableEnumUserGender.conversion(this.gender).description();
    }
    
    public String getAreaName() {
        return TableEnumUserArea.conversion(this.area).show();
    }
}