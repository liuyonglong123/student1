package com.liuyonglong.dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理post请求的乱码
        req.setCharacterEncoding("utf-8");
        //响应的乱码
        resp.setContentType("text/html;charset=utf-8");
        //获取隐藏标签里的请求参数
        String method = req.getParameter("method");
        System.out.println("method = " + method);
        //如果取到了
        if (method != null && method.trim() != ""){
            //获取Servlet类的类对象
            Class<? extends BaseServlet> clazz = this.getClass();
            //通过方法名来获取方法对象
            try {
                Method meth = clazz.getMethod(method, HttpServletRequest.class,
                        HttpServletResponse.class);
                //调用方法
                meth.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("请先指定请求方法的名字"+method);
        }
    }
}
