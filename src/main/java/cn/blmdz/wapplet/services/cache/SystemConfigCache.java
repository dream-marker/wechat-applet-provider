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
import cn.blmdz.wapplet.model.enums.TableEnumChannelUserThird;
import cn.blmdz.wapplet.model.enums.TableEnumTypeSystemConfig;
import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;
import cn.blmdz.wapplet.util.JsonMapper;

@Component
public class SystemConfigCache {
	
	private @Autowired SystemConfigDao systemConfigDao;

	private final LoadingCache<TableEnumTypeSystemConfig, Optional<SystemConfig>> systemConfigs;

	public SystemConfigCache() {
		systemConfigs = CacheBuilder.newBuilder()
				.expireAfterWrite(20, TimeUnit.MINUTES)
				.build(new CacheLoader<TableEnumTypeSystemConfig, Optional<SystemConfig>>(){
					@Override
					public Optional<SystemConfig> load(TableEnumTypeSystemConfig key) throws Exception {
						
						return Optional.fromNullable(systemConfigDao.findByType(key.code()));
					}
		});
	}
	
	public WechatAppletConfig getWechatAppletConfig(TableEnumChannelUserThird type) {
	    
		String config = getType(TableEnumTypeSystemConfig.conversion(Integer.parseInt(String.valueOf(1000) + String.valueOf(type.code()))));
		if (StringUtils.isNotBlank(config)) {
			return JsonMapper.nonDefaultMapper().fromJson(config, WechatAppletConfig.class);
		}
		return null;
	}
	
	public void refresh() {
        for (TableEnumTypeSystemConfig type : TableEnumTypeSystemConfig.values()) {
            systemConfigs.refresh(type);
        }
	}
	
	private String getType(TableEnumTypeSystemConfig type) {
		Optional<SystemConfig> optional = systemConfigs.getUnchecked(type);
		
		if (optional.isPresent()) return optional.get().getConfig();
		
		return null;
	}
	
}
