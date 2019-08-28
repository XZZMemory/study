package com.memory.study.interceptor;

import com.memory.study.constant.CommonConstant;
import com.memory.study.constant.ErrorCode;
import com.memory.study.framework.exception.ServiceException;
import com.memory.study.utils.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * created by memory
 * on 2019/8/28 09 50
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行preHandle");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader(CommonConstant.AUTHORIZATION);
        loginRequiredCheck((HandlerMethod) handler, token);
        return true;
    }

    public boolean loginRequiredCheck(HandlerMethod handler, String token) {
        logger.info("执行loginRequiredCheck");
        Method method = handler.getMethod();
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        if (loginRequired != null) {
            if (token == null) {
                logger.error("未登录");
                ErrorCode errorCode = ErrorCode.TOKEN_INVALID;
                throw new ServiceException(errorCode);
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
