package cn.blmdz.wapplet.services.service;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.dao.UserDao;
import cn.blmdz.wapplet.dao.UserThirdDao;
import cn.blmdz.wapplet.enums.EnumsError;
import cn.blmdz.wapplet.exception.WAppletException;
import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.entity.UserThird;
import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;
import cn.blmdz.wapplet.model.vo.UserVo;
import net.sf.cglib.beans.BeanCopier;

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
    
    public UserVo findByUserId(Long userId) {
        User user = userDao.findById(userId);
        if (user == null) throw new WAppletException(EnumsError.ERROR_000102);
        UserVo userVo = new UserVo();
        BeanCopier.create(User.class, UserVo.class, false).copy(user, userVo, null);
        return userVo;
    }
    
    public void updateUser(User user) {
        User exist = userDao.findById(user.getId());
        if (exist == null) throw new WAppletException(EnumsError.ERROR_000102);
        user.setUpdateTime(Calendar.getInstance().getTime());
        userDao.update(user);
    }
}
