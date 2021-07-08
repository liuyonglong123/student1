package com.liuyonglong.service;

import com.liuyonglong.bean.Student;
import com.liuyonglong.dao.StudentDao;

public class StudentService {
    //定义一个Dao层全局对象
     StudentDao sd = new StudentDao();


    /**
     *  服务层添加学生方法
     * @param student 参数
     * @return 返回值为是否成功
     */
    public boolean addStu(Student student){
         //判断Servlet层传递的数据是否为空
        if (student != null ){
            //那么就调用Dao层添加方法并传递数据过去
            int row = sd.addStu(student);
            //添加成功则返回影响行数到Servlet层
            return row > 0;
        }
        //否则就添加失败则返回false
        return false;
     }
}
