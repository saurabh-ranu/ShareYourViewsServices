package com.omnie.shareyourviewservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices11;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer

public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
	private static String REALM="MY_OAUTH_REALM";
	
    private String resourceId= "test";
    

    int accessTokenValiditySeconds = 3600;

    @Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

    @Autowired
	private UserApprovalHandler userApprovalHandler;
    
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
    	 JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    	 converter.setSigningKey("123");
         return converter;
    }

    @Bean
    public TokenStore tokenStore() {
    	JwtTokenStore tokenStore = new JwtTokenStore(accessTokenConverter());
    	tokenStore.setTokenEnhancer(accessTokenConverter());
        return tokenStore;
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .authenticationManager(authenticationManager)
            .accessTokenConverter(accessTokenConverter())
            .userApprovalHandler(userApprovalHandler)
            .tokenServices(tokenServices(tokenStore()));
    }
    
  
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
            .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')").realm(REALM+"/client");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("normal-app")
                .authorizedGrantTypes("password", "authorization_code", "implicit","refresh_token")
                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                
                
        .and()
            .withClient("trusted-app")
                .authorizedGrantTypes("client_credentials", "password", "implicit","refresh_token")
                .authorities("ROLE_TRUSTED_CLIENT")
                .scopes("read", "write")
                .resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .secret("secret");
    }
	  
   
    
    @Bean(name="tokenServices")
    @Primary
    public DefaultTokenServices11 tokenServices(TokenStore tokenStore) {
        DefaultTokenServices11 defaultTokenServices = new DefaultTokenServices11();
        defaultTokenServices.setTokenStore(tokenStore);
        System.out.println("tokenStore "+tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
        return defaultTokenServices;
    }
    

    
}
