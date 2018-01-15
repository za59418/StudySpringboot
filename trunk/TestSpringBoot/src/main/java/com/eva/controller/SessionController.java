package com.eva.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by 01348085 on 2017/7/11.
 */
@RestController
@RequestMapping("/session")
public class SessionController {
    @RequestMapping("/test")
    public String test(){
        return "PING OK";
    }

    @RequestMapping("/put")
    public String put(HttpSession session,
                      @RequestParam("key") String key, @RequestParam("value") String value){
        session.setAttribute(key,value);
        return "PUT OK";
    }

    @RequestMapping("/get")
    public String get(HttpSession session,
                      @RequestParam("key") String key){
        String value = (String) session.getAttribute(key);

        if(value == null || "".equals(value)){
            return "NO VALUE GET";
        }
        return value;
    }

    @RequestMapping("/uid")
    public String getUid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uid");
        if (uuid == null){
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid",uuid);
        return session.getId();
    }
}
