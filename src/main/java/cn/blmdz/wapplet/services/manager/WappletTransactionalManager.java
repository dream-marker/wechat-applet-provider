package cn.blmdz.wapplet.services.manager;

import cn.blmdz.wapplet.model.entity.User;
import cn.blmdz.wapplet.model.entity.UserThird;

public interface WappletTransactionalManager {

    /**
     * 用户创建
     */
    void createUser(User user, UserThird userThird);
}
