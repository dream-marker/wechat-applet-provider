package cn.blmdz.wapplet.services.helper;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.base.SocketObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SocketManagers implements SocketManager {

    @PostConstruct
    public void postConstruct() {
    }
    
    @Override
    public void connect(BaseUser user, WebSocketSession session) {
        log.info("{} success connected.", user.getNick());
    }
    
    @Override
    public void message(BaseUser user, SocketObject obj) {
        log.info("{} send: {}.", user.getNick(), obj.toString());
    }

    @Override
    public void close(BaseUser user) {
        log.info("{} success closed.", user.getNick());
    }

    @Override
    public void error(BaseUser user) {
        log.info("{} connection error.", user.getNick());
    }
}

