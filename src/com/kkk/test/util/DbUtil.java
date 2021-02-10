package com.kkk.test.util;

import java.sql.*;

/**
 * 数据库操作类
 */
public class DbUtil {
    // 驱动
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    // 连接地址
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_study";

    // 连接账户
    private static final String DB_USERNAME = "root";

    // 连接密码
    private static final String DB_PASSWORD = "a12345678";

    // 存储连接实例
    private static DbUtil instance = null;

    // 链接实例
    private static Connection connection = null;

    /**
     * 形成无法实例化
     */
    private DbUtil() {}

    /**
     * 获取实例
     * @return
     */
    public static final DbUtil instance()
    {
        if (instance == null) {
            instance = new DbUtil();
        }

        return instance;
    }

    /**
     * 执行连接
     */
    public void executeConnection() throws ClassNotFoundException
    {
        if (connection != null) {
            return ;
        }

        Class.forName(DB_DRIVER);

        try {
            // 连接数据库
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 执行插入数据
     * @param sql
     * @param params
     * @return
     */
    public boolean executeInsert(String sql, Object params[]) throws ClassNotFoundException, SQLException
    {
        // 先执行数据库链接
        this.executeConnection();

        // 获取 PreparedStatement
        PreparedStatement pstmt = this.createPreParedStatement(sql, params);

        return pstmt.execute();
    }

    /**
     * 执行修改操作(其实跟insert 操作一样)
     * @param sql
     * @param params
     * @return
     */
    public boolean executeUpdate(String sql, Object params[]) throws ClassNotFoundException, SQLException
    {
        // 先执行数据库链接
        this.executeConnection();

        // 获取 PreparedStatement
        PreparedStatement pstmt = this.createPreParedStatement(sql, params);

        return pstmt.execute();
    }

    /**
     * 获取 PreparedStatement
     * @return
     */
    private PreparedStatement createPreParedStatement(String sql, Object[] params) throws SQLException
    {
        System.out.println(sql);

        // 准备
        PreparedStatement pstmt = connection.prepareStatement(sql);

        if (params != null)
        {
            // 整理参数
            for (int i = 0;i < params.length; i ++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
        }

        return pstmt;
    }

    /**
     * 执行查询多条
     * @param sql
     * @param params
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return
     */
    public ResultSet executeQuery(String sql, Object[] params) throws ClassNotFoundException, SQLException
    {
        this.executeConnection();

        PreparedStatement pstmt = this.createPreParedStatement(sql, params);

        return pstmt.executeQuery();
    }

}
