package cn.blmdz.wapplet.services.helper;

import org.springframework.web.socket.WebSocketSession;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.base.SocketObject;

public interface SocketManager {

    void connect(BaseUser user, WebSocketSession session);
    
    void message(BaseUser user, SocketObject obj);
    
    void close(BaseUser user);
    
    void error(BaseUser user);
}
