package cn.blmdz.wapplet.base;

import java.io.Serializable;

import cn.blmdz.wapplet.enums.EnumsError;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回数据定义封装
 * @author xpoll
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    private Integer code;
    
    @Setter(AccessLevel.NONE)
    private String message;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean success;
	
	@Setter(AccessLevel.NONE)
	private T data;

	public static Response<Boolean> ok() {
		return build(Boolean.TRUE);
	}
	
	public Response<T> buildEnum(EnumsError enumsError) {
	    this.code = enumsError.code();
		this.message = enumsError.description();
		return this;
	}
	
	public Response<T> message(String msg) {
		this.message = msg;
		return this;
	}
	
	public Response<T> orNull(EnumsError enumsError) {
		if (this.getData() != null)
			return this;
		this.code = enumsError.code();
        this.message = enumsError.description();
		return this;
	}

	public Boolean isSuccess() {
		return success;
	}
    
    public static<T> Response<T> build(T data) {
        Response<T> response = new Response<T>();
        if (data == null) {
            response.code = EnumsError.ERROR_999998.code();
            response.message = EnumsError.ERROR_999998.description();
            response.success = Boolean.FALSE.booleanValue();
            return response;
        }
        response.code = EnumsError.ERROR_000000.code();
        response.message = EnumsError.ERROR_000000.description();
        response.success = Boolean.TRUE.booleanValue();
        response.data = data;
        return response;
    }
    
    public static<T> Response<T> error(EnumsError enumsError) {
        Response<T> response = new Response<T>();
        response.code = enumsError.code();
        response.message = enumsError.description();
        response.success = Boolean.FALSE.booleanValue();
        return response;
    }
}
