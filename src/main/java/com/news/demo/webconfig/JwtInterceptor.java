package com.news.demo.webconfig;


import com.news.demo.Utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/***
 * 拦截器  springboot HandlerInterceptorAdapter  拦截器
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {


    /***
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        Enumeration<String> headerNames = request.getHeaderNames();

        // 从方法处理器中获取出要调用的方法
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            throw new ServletException("invalid Authorization header");
        }
        //取得token
        String token = authHeader.substring(7);
        try {
            //检查token
            Map<String,Object> result =  JwtUtils.valid(token);
            return  true;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }




}
