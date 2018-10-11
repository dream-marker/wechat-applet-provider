package cn.blmdz.wapplet.exception;

import cn.blmdz.wapplet.enums.EnumsError;
import lombok.Getter;

/**
 * extends RuntimeException
 * 项目异常返回
 * @author xpoll
 */
public class WAppletException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private EnumsError enumsError;

    public WAppletException() {
        super();
    }

    public WAppletException(String message) {
        super(message);
    }
    
    public WAppletException(EnumsError enumsError) {
        super(enumsError.description());
        this.enumsError = enumsError;
    }

    public WAppletException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WAppletException(Throwable throwable) {
        super(throwable);
    }

}
