package com.eva.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 01348085 on 2017/7/12.
 */
@Component
@ConfigurationProperties(prefix = "sso")
public class SSOProperties {
    /**
     * 是否允许重复登陆
     */
    private boolean repeatLogin;

    public boolean isRepeatLogin() {
        return repeatLogin;
    }

    public void setRepeatLogin(boolean repeatLogin) {
        this.repeatLogin = repeatLogin;
    }
}
