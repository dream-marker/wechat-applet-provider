package cn.blmdz.wapplet.services.manager;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.dao.UserThirdDao;
import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.entity.UserThird;
import cn.blmdz.wapplet.model.enums.TableEnumStatusUser;

@Component
public class UserRecognitionManager {

    private @Autowired UserThirdDao userThirdDao;
    private @Autowired WappletTransactionalManager wappletTransactionalManager;

    /**
     * 用户认证识别
     */
    @Transactional
    public BaseUser recognition(BaseUser baseUser) {
        List<UserThird> userThirds = userThirdDao.findByAccount_1(baseUser.getAccount_1());

        Calendar calendar = Calendar.getInstance();
        
        if (CollectionUtils.isEmpty(userThirds)) {
            
            User user = new User();
            user.setNick(baseUser.getNick());
            user.setAvatar(baseUser.getAvatar());
            user.setGender(baseUser.getGender());
            user.setBirthday(calendar.getTime());
            user.setArea(-1);
            user.setChannel(baseUser.getChannel().code());
            user.setStatus(TableEnumStatusUser.NORMAL.code());
            user.setCreateTime(calendar.getTime());
            user.setUpdateTime(calendar.getTime());

            UserThird userThird = new UserThird();
            userThird.setUserId(-1L);
            userThird.setAccount_1(baseUser.getAccount_1());
            userThird.setAccount_2(baseUser.getAccount_2());
            userThird.setNick(baseUser.getNick());
            userThird.setAvatar(baseUser.getAvatar());
            userThird.setChannel(baseUser.getChannel().code());
            userThird.setCreateTime(calendar.getTime());
            
            wappletTransactionalManager.createUser(user, userThird);
            
            baseUser.setUserId(user.getId());
            baseUser.setThirdId(userThird.getId());
            
            return baseUser;
        } else {

            UserThird userThird = new UserThird();
            userThird.setUserId(userThirds.get(0).getUserId());
            userThird.setAccount_1(baseUser.getAccount_1());
            userThird.setAccount_2(baseUser.getAccount_2());
            userThird.setNick(baseUser.getNick());
            userThird.setAvatar(baseUser.getAvatar());
            userThird.setChannel(baseUser.getChannel().code());
            userThird.setCreateTime(calendar.getTime());
            
            userThirdDao.create(userThird);

            baseUser.setThirdId(userThird.getId());
        }
        
        return baseUser;
    }
    
}
