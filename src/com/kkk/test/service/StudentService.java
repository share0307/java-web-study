package com.kkk.test.service;

import com.kkk.test.dao.StudentDao;
import com.kkk.test.entity.StudentEntity;
import java.sql.SQLException;
import java.util.*;

/**
 * 学生列表，提供方法
 */
public class StudentService {

    /**
     * 初始化方法
     */
    public void init()
    {
        System.out.println(getClass() + " 被初始化了！");
    }

    /**
     * 获取学生列表
     */
    public List<StudentEntity> getList() throws SQLException, ClassNotFoundException
    {
        StudentDao studentDao = new StudentDao();

        return studentDao.getList();
    }

    /**
     * 创建学生
     * @param params
     */
    public boolean store(Map params) throws SQLException, ClassNotFoundException
    {
        StudentDao studentDao = new StudentDao();

        return studentDao.store(params);
    }
    
}
