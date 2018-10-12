package cn.blmdz.wapplet.services.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import cn.blmdz.wapplet.dao.UserThirdDao;
import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;

@Component
public class UserThirdCache {
    
    private @Autowired UserThirdDao userThirdDao;

    private final LoadingCache<TableEnumUserThirdChannel, Integer> appPeopleCount;


    public UserThirdCache() {
        appPeopleCount = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<TableEnumUserThirdChannel, Integer>(){
                    @Override
                    public Integer load(TableEnumUserThirdChannel key) throws Exception {
                        return userThirdDao.channelCount(key.code());
                    }
        });
    }
    
    public int getAppPeopleCount(TableEnumUserThirdChannel type) {
        return appPeopleCount.getUnchecked(type);
    }
}
