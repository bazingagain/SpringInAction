package com.leon.learnspringsecurity.config;

import com.leon.learnspringsecurity.mapper.SpitterRepository;
import com.leon.learnspringsecurity.service.impl.SpitterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created on 30/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SpitterRepository spitterRepository;

    @Value("${secret-key}")
    private String secretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1.基于内存的用户认证
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");

        /**
        //2.基于数据表进行验证
//        auth.jdbcAuthentication().dataSource(dataSource);
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true " +
                "from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true " +
                        "from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
                .passwordEncoder(new StandardPasswordEncoder(secretKey));

        //3.基于LDPA的认证
        //3.1本地方式
        auth.ldapAuthentication().userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0")
                .passwordCompare()
                .passwordEncoder(new StandardPasswordEncoder(secretKey))
                .passwordAttribute("passwordcode");
        //3.2远程方式
        auth.ldapAuthentication().userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0")
                .contextSource().url("ldap://test.com:3389/dc=test,dc=com");
        //3.3配置嵌入式LDPA服务器
        auth.ldapAuthentication().userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0")
                .contextSource().root("dc=test,dc=com")
                .ldif("classpath:users.ldif");

         **/

        //4. 自定义认证服务
        auth.userDetailsService(new SpitterUserServiceImpl(spitterRepository));
    }
}
