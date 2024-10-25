package com.combat.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.combat.pojo.Result;
import com.combat.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.请求url
        String url = request.getRequestURL().toString();
        log.info("请求url为：",url);

        //2.判断url中是否包含login，如果有直接放行，并进入登录界面
        if (url.contains("login")){
            log.info("执行登录操作");
            return true;
        }

        //3.获得请求头的令牌
        String jwt = request.getHeader("token");

        //4.判断令牌是否存在，如果不存在，返回错误并回到登录界面
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头为空");
            Result error  = Result.error("NOT_LOGIN");
            //手动将对象转换为josn格式
            String not_Login = JSONObject.toJSONString(error);
            response.getWriter().write(not_Login);
            return false;
        }

        //5.解析token，解析失败返回错误
        try {
            JwtUtils.parse_jwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析失败，返回错误");
            Result error  = Result.error("NOT_LOGIN");
            //手动将对象转换为josn格式
            String not_Login = JSONObject.toJSONString(error);
            response.getWriter().write(not_Login);
            return false;
        }

        //6.成功通过判断，放行
        return true;

    }

    @Override //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override //视图渲染完毕后运行, 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
