package cn.blmdz.wapplet.model.form;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserAreaForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 区域 */
    @NotNull(message = "表单参数不正确")
    @Min(value = 1, message = "表单参数不正确")
    @Max(value = 34, message = "表单参数不正确")
    private Integer area;

}
