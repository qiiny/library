package top.qiin.library.util;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
* @Description:
* @Param:
* @return:
* @Author: Qin
* @Date: 2019/12/30
*/


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyAdmin {
}
