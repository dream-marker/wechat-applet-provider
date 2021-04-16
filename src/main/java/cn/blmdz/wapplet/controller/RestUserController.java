package cn.blmdz.wapplet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.form.UserAreaForm;
import cn.blmdz.wapplet.model.form.UserBirthdayForm;
import cn.blmdz.wapplet.model.vo.UserVo;
import cn.blmdz.wapplet.services.service.UserService;
import cn.blmdz.wapplet.util.UserUtil;

@RestController
@RequestMapping(value="/api/user")
public class RestUserController {

    private @Autowired UserService userService;
    
    /**
     * 获取用户信息
     */
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<UserVo> user(HttpServletRequest request) {
        
        BaseUser baseUser = UserUtil.getBaseUser(request);
        
        return Response.build(userService.findByUserId(baseUser.getUserId()));
    }

    /**
     * 设置生日
     */
    @RequestMapping(value="/birthday", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> birthday(HttpServletRequest request, @RequestBody @Valid UserBirthdayForm userBirthdayForm) {
        BaseUser baseUser = UserUtil.getBaseUser(request);
        User user = new User();
        user.setBirthday(userBirthdayForm.getBirthday());
        user.setId(baseUser.getUserId());
        userService.updateUser(user);
        return Response.ok();
    }

    /**
     * 设置区域
     */
    @RequestMapping(value="/area", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> area(HttpServletRequest request, @RequestBody @Valid UserAreaForm userAreaForm) {
        BaseUser baseUser = UserUtil.getBaseUser(request);
        User user = new User();
        user.setArea(userAreaForm.getArea());
        user.setId(baseUser.getUserId());
        userService.updateUser(user);
        return Response.ok();
    }
}
