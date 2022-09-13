package com.mmall.gateway.utils;

import com.mmall.gateway.exception.MmallException;
import com.mmall.gateway.exception.MmallExceptionEnum;

/**
 * 主要用来检验数据的合法性 后续可以自行扩充
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 17:03
 */
public class Assert {

    public Assert() {

    }

    public static void isTrue(boolean expression, MmallExceptionEnum mmallExceptionEnum) throws MmallException {

        if (!expression) {

            throw new MmallException(mmallExceptionEnum);

        }

    }

    public static void isFalse(boolean expression, MmallExceptionEnum mmallExceptionEnum) throws MmallException {

        if (expression) {

            throw new MmallException(mmallExceptionEnum);

        }

    }

}
