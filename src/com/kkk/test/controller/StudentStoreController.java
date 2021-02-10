package com.kkk.test.controller;

import com.kkk.test.service.StudentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建学生 controller类
 */
@WebServlet("/student/store")
public class StudentStoreController extends BaseController {

    /**
     * 创建学生
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        Map params = this.getAllParams(request);

        StudentService studentService = new StudentService();

        try {
            studentService.store(params);

            System.out.println("创建学生成功！");

            response.sendRedirect(request.getHeader("Referer"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            System.out.println("创建学生失败！原因为：" + throwables.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            System.out.println("创建学生失败！原因为：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("IOException！原因为：" + e.getMessage());
        }
    }


    /**
     * 获取所有参数
     * @param request
     * @return
     */
    private Map getAllParams(HttpServletRequest request)
    {
        Map params = new HashMap();

        for (Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();)
        {
            // 获取参数名字
            String paramsName = (String) enumeration.nextElement();

            params.put(paramsName, request.getParameter(paramsName));
        }

        return params;
    }

}
