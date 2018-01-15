package com.eva.common.annotation;

import java.lang.annotation.*;

/**
 * Created by 01348085 on 2017/7/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface QueryCacheKey {
}
