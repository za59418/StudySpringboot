package com.eva.utils;

import java.util.UUID;

/**
 * Created by 01348085 on 2017/7/12.
 */
public class SsoUtils {

    public static String getUUID(){
        return "sso-" + UUID.randomUUID().toString();
    }

}
