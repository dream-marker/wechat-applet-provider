package cn.blmdz.wapplet.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.blmdz.wapplet.dao.UserDao;
import cn.blmdz.wapplet.dao.UserThirdDao;
import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.entity.UserThird;

@Component
public class WappletTransactionalManagerImpl implements WappletTransactionalManager {

    private @Autowired UserDao userDao;
    private @Autowired UserThirdDao userThirdDao;

    @Override
    @Transactional
    public void createUser(User user, UserThird userThird) {
        userDao.create(user);
        userThirdDao.create(userThird);
    }

}
