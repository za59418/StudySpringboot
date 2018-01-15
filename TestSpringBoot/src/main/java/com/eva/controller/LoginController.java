package com.eva.controller;

import com.eva.common.Constant;
import com.eva.common.SSOProperties;
import com.eva.dao.UserDao;
import com.eva.entity.User;
import com.eva.utils.SsoCookie;
import com.eva.utils.SsoUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by 01348085 on 2017/7/12.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private SSOProperties ssoProperties;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String web(){
        return "index";
    }

    @RequestMapping("/index.htm")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model){
        String url = WebUtils.getSavedRequest(request).getRequestUrl();
        model.addAttribute("returnUrl",url);
        return "login";
    }

    @RequestMapping(value = "/login.htm",method = RequestMethod.POST)
    public String web(String username,String password,String returnUrl,HttpSession session,HttpServletRequest request){

        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            session.setAttribute("user", user);
//            String url = WebUtils.getSavedRequest(request).getRequestUrl();
            return "redirect:"+returnUrl;
//            return "index";
        } catch(Exception e) {
            return "login";//返回登录页面
        }
    }

    private void saveUserInfo(User userInfo, HttpSession session, HttpServletResponse response) {
        String userId = userInfo.getId().toString();
        // 保存session
        session.setAttribute(Constant.LOGIN_SESSION, userInfo);

//        if (!ssoProperties.isRepeatLogin()){
//            // 先踢掉之前在线的人
//            String oldCookie = (String) MemcachedUtils.get(userId);
//            logger.info("不可重复登陆，清楚已在线人：{} 的缓存：{}", userId, oldCookie);
//            if (StringUtils.isNotBlank(oldCookie)){
//                MemcachedUtils.delete(oldCookie);
//                MemcachedUtils.delete(userId);
//
//            }
//        }

        String key = SsoUtils.getUUID();

        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        // 以cookie值为key，userId为value存储
        valueOperations.set(key, userId, new Date(1000 * 60 * 30).getTime() ); //  设置30分钟后超时

        // 以userId为Key，cookie值为value存储
        valueOperations.set(userId, key, new Date(1000 * 60 * 30).getTime() ); //  设置30分钟后超时

        logger.info("添加登陆人：{} 的缓存：{}", userId, key);
        // 存储cookie值
        SsoCookie.setCookie(key, response);
    }


    private void checkReturnUrl(String returnUrl){
        if (!StringUtils.startsWithIgnoreCase(returnUrl, "http")){
            returnUrl = "/" + returnUrl;
        }
    }


    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }

}
