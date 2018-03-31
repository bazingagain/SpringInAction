package com.leon.learnspringsecurity.config;

import com.leon.learnspringsecurity.dao.SpitterMapper;
import com.leon.learnspringsecurity.service.impl.SpitterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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
    private SpitterUserServiceImpl spitterUserService;

    @Value("${secret-key}")
    private String secretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .defaultSuccessUrl("/");//登录成功后默认跳转到"/"
//                .and()
//                .authorizeRequests()
//                .antMatchers("/spitter/me").authenticated()
//                .antMatchers(HttpMethod.POST, "/spitter").authenticated()
//                .anyRequest().permitAll();

//        http.formLogin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/spitter/me").hasAuthority("SPITTER")
//                .antMatchers(HttpMethod.POST, "/spitter").hasRole("SPITTER")
//                .antMatchers("/spitter/other").access("hasRole('SPITTER')")
//                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")//登录成功后默认跳转到"/"
                .and()
                .rememberMe()
                .tokenValiditySeconds(3600)
                .key("spitterKey")
                .and()
                .logout()
                .logoutSuccessUrl("/login")//退出登录后的默认url是"/home"  默认开启csrf之后,LogoutFilter仅能使用POST方式请求
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //这种方式可以设置通过get方式访问加了csrf的logout,但不提倡
//                .deleteCookies("remember-me")
                .and()
                .authorizeRequests()
                .antMatchers("/spitter/me").hasAuthority("ROLE_SPITTER")
                .antMatchers(HttpMethod.POST, "/spitter").hasRole("SPITTER")
                .antMatchers("/spitter/other").access("hasRole('SPITTER')")
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure() //需要HTTPS
                .antMatchers("/").requiresInsecure(); //首页使用 HTTP
        //禁用 csrf保护 (默认自带)
//        http.csrf().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1.基于内存的用户认证
//        auth.inMemoryAuthentication()
//                .withUser("test").password("hehe").roles("SPITTER").and()
//                .withUser("admin").password("password").roles("SPITTER", "ADMIN").and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//

        //2.基于数据表进行验证
//        auth.jdbcAuthentication().dataSource(dataSource);
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, true " +
//                "from spitter where username=?")
//                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from spitter where username=?");
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, true " +
//                        "from spitter where username=?")
//                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from spitter where username=?")
//                .passwordEncoder(new StandardPasswordEncoder(secretKey));

        /**
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
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();

        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder(idForEncode, encoders);
        auth.userDetailsService(spitterUserService)
                .passwordEncoder(passwordEncoder);
    }
}
