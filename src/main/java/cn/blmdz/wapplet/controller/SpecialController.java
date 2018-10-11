//package cn.blmdz.wapplet.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import cn.blmdz.wapplet.model.vo.SocketObject;
//
//
///**
// * 特殊controller
// * @author xpoll
// */
//@Controller
//public class SpecialController {
//
//    private @Autowired SimpMessagingTemplate template;
//    
//    @MessageMapping("/say")
//    public <T> void greeting(SocketObject<T> obj) {
//        System.out.println(obj);
//        template.convertAndSend("/simple/greeting", obj);
//    }
//}
