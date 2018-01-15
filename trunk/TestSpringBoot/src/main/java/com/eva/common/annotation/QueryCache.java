package com.eva.common.annotation;

import com.eva.common.CacheNameSpace;

import java.lang.annotation.*;

/**
 * Created by 01348085 on 2017/7/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface QueryCache {
    CacheNameSpace nameSpace();
}
