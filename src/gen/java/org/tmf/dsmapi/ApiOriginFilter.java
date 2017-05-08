package org.tmf.dsmapi;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:45.112+05:30")
@WebFilter(urlPatterns = "/*",asyncSupported = true)
public class ApiOriginFilter implements javax.servlet.Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        chain.doFilter(request, response);
    }

    public void destroy() {}

    public void init(FilterConfig filterConfig) throws ServletException {}
}