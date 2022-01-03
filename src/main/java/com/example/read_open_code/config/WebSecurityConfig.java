package com.example.read_open_code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        // 密码编码器，对前端提交的password进行编码，并比对
        @Bean
        public PasswordEncoder passwordEncoder(){
            // 推荐使用BCrypt进行验证，数据库存储的是使用Bcrypt加密的密码
            return new BCryptPasswordEncoder();
        }

        // 安全访问控制,重写父类方法configure(HttpSecurity http)
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // 管理url权限
            http.authorizeRequests()
                    // 匹配原则为：按顺序优先匹配路径，再验证权限，权限通过则放行，不再继续向下匹配路径，因此更细致、具体的路径放在上面
                    .antMatchers("/level1/**").hasRole("vip1")// 允许vip1角色
                    .antMatchers("/level2/**").hasAuthority("p1")// 允许p2权限
                    .antMatchers("/**").authenticated();
            // 使用自定义登录页面需要取消拦截POST请求，即关掉csrf控制，spring security为防止csrf的发生，限制了除GET以外的请求，默认开启csrf控制
            http.csrf().disable();
            // 自定义登录页面，使用后security提供的登录页面login作废，即使参数为“/login”，调用的也是自定义登录url的"/login"
            // loginPage:登录页面url,当没有登录需要登录时就会跳到这个地址，loginProcessingUrl:自定义登录页面表单提交的地址
            http.formLogin().loginPage("/login").loginProcessingUrl("/login").successForwardUrl("/login-success");

            // 当访问的退出操作的url时，默认进行以下操作：使HTTP Session无效，清除SecurityContextHolder，跳转退出成功后的url
            http.logout().logoutUrl("/logout")// 自定义触发退出操作的url，默认是"/logout",设置之后security所提供的logout作废
                .logoutSuccessUrl("logout-success");// 自定义退出成功后跳转的url，默认是"/login?logout"
        }

}


