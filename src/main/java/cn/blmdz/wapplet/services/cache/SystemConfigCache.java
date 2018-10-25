package cn.blmdz.wapplet.services.cache;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import cn.blmdz.wapplet.dao.SystemConfigDao;
import cn.blmdz.wapplet.model.entity.SystemConfig;
import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;
import cn.blmdz.wapplet.model.enums.TableEnumSystemConfigType;
import cn.blmdz.wapplet.model.sysconfig.HeweatcherConfig;
import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;
import cn.blmdz.wapplet.util.JsonMapper;

@Component
public class SystemConfigCache {
	
	private @Autowired SystemConfigDao systemConfigDao;

	private final LoadingCache<TableEnumSystemConfigType, Optional<SystemConfig>> systemConfigs;

	public SystemConfigCache() {
		systemConfigs = CacheBuilder.newBuilder()
				.expireAfterWrite(20, TimeUnit.MINUTES)
				.build(new CacheLoader<TableEnumSystemConfigType, Optional<SystemConfig>>(){
					@Override
					public Optional<SystemConfig> load(TableEnumSystemConfigType key) throws Exception {
						
						return Optional.fromNullable(systemConfigDao.findByType(key.code()));
					}
		});
	}
	
	public WechatAppletConfig getWechatAppletConfig(TableEnumUserThirdChannel type) {
	    
		String config = getType(TableEnumSystemConfigType.conversion(100 + type.code()));
		if (StringUtils.isNotBlank(config)) {
			return JsonMapper.nonDefaultMapper().fromJson(config, WechatAppletConfig.class);
		}
		return null;
	}
	
	public HeweatcherConfig getHeweatcherConfig(TableEnumSystemConfigType type) {
	    String config = getType(type);

        if (StringUtils.isNotBlank(config)) {
            return JsonMapper.nonDefaultMapper().fromJson(config, HeweatcherConfig.class);
        }
        return null;
	}
	
	public void refresh() {
        for (TableEnumSystemConfigType type : TableEnumSystemConfigType.values()) {
            systemConfigs.refresh(type);
        }
	}
	
	private String getType(TableEnumSystemConfigType type) {
		Optional<SystemConfig> optional = systemConfigs.getUnchecked(type);
		
		if (optional.isPresent()) return optional.get().getConfig();
		
		return null;
	}
	
}
