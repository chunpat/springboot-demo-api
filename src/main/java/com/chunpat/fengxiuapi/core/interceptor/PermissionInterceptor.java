package com.chunpat.fengxiuapi.core.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.exception.AuthenticatedException;
import com.chunpat.fengxiuapi.exception.ForbiddenException;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.service.UserService;
import com.chunpat.fengxiuapi.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    public PermissionInterceptor() {
        super();
    }

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if(!scopeLevel.isPresent()){
           return true;
        };

        String authorization = request.getHeader("Authorization");
        System.out.println("authorization");
        System.out.println(authorization);
        if(authorization == null || !authorization.startsWith("Bearer")){
            throw new AuthenticatedException();
        }
        String[] split = authorization.split(" ");
        if(!(split.length == 2)){
            throw new AuthenticatedException();
        }
        DecodedJWT decodedJWT = JwtToken.verify(split[1]);
        //用户权限
        Claim claimScope = decodedJWT.getClaim("scope");
        if(claimScope.asInt() < scopeLevel.get().value()){
            throw new AuthenticatedException(10006);
        }
        //用户id
        Claim claimUid = decodedJWT.getClaim("uid");
        //写入用户信息
        this.setUserToThreadLocal(claimUid.asLong(),claimScope.asInt());
        return true;
    }

    //缓存用户
    public void setUserToThreadLocal(Long uid,Integer scope){
        Optional<User> User = userService.getById(uid);
        LocalUser.setUser(User.get(),scope);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        LocalUser.clear();
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    private Optional<ScopeLevel> getScopeLevel(Object handler){
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            return Optional.ofNullable(scopeLevel);
        }
        return Optional.empty();
    }
}
