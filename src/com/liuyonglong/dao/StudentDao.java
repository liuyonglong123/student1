package com.liuyonglong.dao;

import com.liuyonglong.bean.Student;
import com.liuyonglong.util.ThreadDruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class StudentDao {
    //全局
    DataSource ds = ThreadDruidUtils.getDataSource();
    QueryRunner qr = new QueryRunner(ds);


    /**
     *  添加学生到数据库
     * @param student 参数
     * @return 影响行数
     */
    public int addStu(Student student){

        //准备sql语句
        String sql = "insert into stu values(null,?,?,?,?,?)";
        System.out.println(sql);
        //添加到数据库 返回的是影响行数
        int row = 0;
        try {
            row = qr.update(sql, student.getSname(), student.getGender(),
                    student.getSbir(), student.getHobby(), student.getPhoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
