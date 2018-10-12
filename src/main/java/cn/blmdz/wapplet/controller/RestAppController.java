package cn.blmdz.wapplet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.model.vo.WechatAppletVo;
import cn.blmdz.wapplet.services.service.AppService;

@RestController
@RequestMapping(value="/api/app")
public class RestAppController {

    private @Autowired AppService appService;
    
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<List<WechatAppletVo>> apps() {
        return Response.build(appService.list());
    }
}
