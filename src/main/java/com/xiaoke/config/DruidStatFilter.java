package com.xiaoke.config;

/**
 打开监控统计功能
 */
import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",
        initParams = {
        @WebInitParam(name = "exclusions",value = ".js,.gif,.jpg,.bmp,.png,.css,.ico,/druid/")}
        )
public class DruidStatFilter extends WebStatFilter {
}
