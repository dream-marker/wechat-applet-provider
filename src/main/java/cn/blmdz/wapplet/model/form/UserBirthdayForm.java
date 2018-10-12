package cn.blmdz.wapplet.model.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.blmdz.wapplet.base.Constants;
import lombok.Data;

@Data
public class UserBirthdayForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 生日 */
    @NotNull(message = "表单参数不正确")
    @JsonFormat(pattern = Constants.Y, timezone = Constants.TIMEZONE)
    private Date birthday;

}
