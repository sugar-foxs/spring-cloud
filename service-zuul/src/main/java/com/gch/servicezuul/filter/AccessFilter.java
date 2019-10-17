package com.gch.servicezuul.filter;

import com.gch.servicezuul.service.SsoFeign;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author guchunhui
 * 2019-10-15 23:59
 **/
@Component
public class AccessFilter extends ZuulFilter {
    @Autowired
    private SsoFeign ssoFeign;

    /**
     * 通过int值来定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        // PreDecoration之前运行
        return 0;
    }

    /**
     * 过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
     * public static final String ERROR_TYPE = "error";
     * public static final String POST_TYPE = "post";
     * public static final String PRE_TYPE = "pre";
     * public static final String ROUTE_TYPE = "route";
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        //访问路径
        String url = request.getRequestURL().toString();
        System.out.println("url:"+url);

        //从cookie里面取值（Zuul丢失Cookie的解决方案：https://blog.csdn.net/lindan1984/article/details/79308396）
        String accessToken = request.getParameter("accessToken");
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                }
            }
        }
        System.out.println("access token:"+accessToken);
        //过滤规则：cookie有令牌且存在于Redis，或者访问的是登录页面、登录请求则放行
        if (url.contains("sso-server/sso/loginPage") || url.contains("sso-server/sso/login") || (!StringUtils.isEmpty(accessToken) && ssoFeign.hasKey(accessToken))) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            //重定向到登录页面
            try {
                response.sendRedirect("http://localhost:8769/sso-server/sso/loginPage?url=" + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
}
