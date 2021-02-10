package com.kkk.test.dao;

import com.kkk.test.entity.StudentEntity;
import com.kkk.test.util.DbUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentDao implements BaseDaoInterface{

    /**
     * 判断用户是否存在
     * @return
     */
    @Override
    public boolean exists() {
        return false;
    }

    /**
     * 获取用户列表
     */
    public List<StudentEntity> getList() throws SQLException, ClassNotFoundException
    {
        String sql = "select id,name,num,age,created_at from student;";

        ResultSet rs = DbUtil.instance().executeQuery(sql, null);

        List<StudentEntity> list = new ArrayList<StudentEntity>();

        while (rs.next())
        {
            StudentEntity student = new StudentEntity();

            student.setAge(rs.getInt("age"));
            student.setAge(rs.getInt("created_at"));
            student.setName(rs.getString("name"));
            student.setNum(rs.getString("num"));

            list.add(student);
        }

        return list;
    }

    /**
     * 创建学生
     * @param params
     * @return
     */
    public boolean store(Map params) throws SQLException, ClassNotFoundException {
        Date date   = new Date();
        Long ts  = date.getTime();

        System.out.println(params);

        Object[] studentParams = new Object[]{
                (String) params.get("name"),
                Integer.parseInt((String) params.get("num")),
                Integer.parseInt((String) params.get("age")),
                (ts / 1000)
        };

        String sql = "INSERT INTO student (name, num, age, created_at) values (?,?,?,?);";

        return DbUtil.instance().executeUpdate(sql, studentParams);
    }

}
