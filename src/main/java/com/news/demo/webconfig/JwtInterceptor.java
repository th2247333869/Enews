package com.news.demo.webconfig;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/***
 * 拦截器  springboot HandlerInterceptorAdapter  拦截器
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {


    /***
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            throw new ServletException("invalid Authorization header");
        }
        //取得token
        String token = authHeader.substring(7);
        try {
            //检查token
            JwtUtil.checkToken(token);
            // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
            // 获取出方法上的Access注解
            return  false;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }*/




}
