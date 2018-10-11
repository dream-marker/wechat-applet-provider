package cn.blmdz.wapplet.services.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.dao.UserDao;
import cn.blmdz.wapplet.dao.UserThirdDao;
import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.entity.UserThird;
import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;

@Service
public class UserService {

    private @Autowired UserThirdDao userThirdDao;
    private @Autowired UserDao userDao;
    
    public BaseUser findByAccount_2(String account_2) {
        if (StringUtils.isBlank(account_2)) return null;
        UserThird userThird = userThirdDao.findByAccount_2(account_2);
        if (userThird == null) return null;
        BaseUser baseUser = new BaseUser();

        User user = userDao.findById(userThird.getUserId());
        baseUser.setUserId(user.getId());
        baseUser.setThirdId(userThird.getId());
        baseUser.setNick(user.getNick());
        baseUser.setAvatar(user.getAvatar());
        baseUser.setAccount_1(userThird.getAccount_1());
        baseUser.setAccount_2(userThird.getAccount_2());
        baseUser.setGender(user.getGender());
        baseUser.setChannel(TableEnumUserThirdChannel.conversion(userThird.getChannel()));
        
        return baseUser;
    }
}
