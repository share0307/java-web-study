package com.kkk.test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

/**
 *
 */
@WebServlet(urlPatterns = {"/helloWorld"}) // 如果用了注解模式，则不需要在 web.xml 中写入相关配置
public class HelloWorld extends HttpServlet {

    // 定义消息字段，字符串类型
    private String message;

    /**
     *
     */
    public void init()
    {
        message = "hello world!";

        System.out.println(getClass() + " 被初始化了！");
    }

    /**
     * Get请求方式
     * @param request
     * @param response
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取参数
        String qs = request.getQueryString();

        response.setContentType("text/plain");

        response.setCharacterEncoding("utf-8");

        response.getWriter().write("获得参数：" + qs);

        System.out.println("hello get！");

        Date date = new Date();

        System.out.println("当前时间：" + (date.toString()));

        destroy();
    }

    /**
     * 接受Post请求
     * @param request
     * @param response
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");

        response.setContentType("text/plain");

        response.getWriter().println("接收到Post请求！");

        System.out.println("hello post！");
    }

    /**
     * 销毁动作
     */
    @Override
    public void destroy() {
        super.destroy();

        System.out.println("Hello World!! 被销毁了！！");
    }
}