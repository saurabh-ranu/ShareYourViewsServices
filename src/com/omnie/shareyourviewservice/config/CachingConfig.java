package com.omnie.shareyourviewservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



@Configuration
@EnableCaching
public class CachingConfig {
	
	@Bean(name = "ehcache")
    public EhCacheManagerFactoryBean getEhCacheManagerFactoryBean(){
          EhCacheManagerFactoryBean  cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
          Resource configLocation = new  ClassPathResource("ehcache.xml");
          cacheManagerFactoryBean.setConfigLocation(configLocation);
          return cacheManagerFactoryBean;
    }
	
	@Bean
	public CacheManager ehCacheManager() {
		return new EhCacheCacheManager(getEhCacheManagerFactoryBean().getObject());
	}
	
}
