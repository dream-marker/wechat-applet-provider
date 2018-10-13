package cn.blmdz.wapplet.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.socket.WebSocketSession;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.enums.EnumsError;
import cn.blmdz.wapplet.exception.WAppletException;

public class UserUtil {

    public static String USER_SESSION_REQUEST = "user_session_request";
    
    public static String USER_SESSION_SOCKET = "user_session_socket";

    /**
     * 用户获取
     */
    public static BaseUser getBaseUserUnCheck(HttpServletRequest request) {
        System.out.println("----------------sessionId: " + request.getSession().getId());
        return (BaseUser) request.getSession().getAttribute(USER_SESSION_REQUEST);
    }

    /**
     * 用户获取
     */
    public static BaseUser getBaseUser(HttpServletRequest request) {
        BaseUser user = getBaseUserUnCheck(request);
        if (user == null) throw new WAppletException(EnumsError.ERROR_000005);
        return user;
    }
    
    /**
     * 用户获取
     */
    public static BaseUser getBaseUser(WebSocketSession session) {
        System.out.println("----------------sessionId: " + session.getId());
        return (BaseUser) session.getAttributes().get(USER_SESSION_SOCKET);
    }
    
    /**
     * 用户设置
     */
    public static BaseUser setBaseUser(HttpServletRequest request, BaseUser baseUser) {
    	baseUser.setSession(request.getSession().getId());
        request.getSession().setAttribute(USER_SESSION_REQUEST, baseUser);
        return baseUser;
    }
    /**
     * 用户设置
     */
    public static BaseUser setBaseUser(WebSocketSession session, BaseUser baseUser) {
        session.getAttributes().put(USER_SESSION_SOCKET, baseUser);
        return baseUser;
    }
	
}
