package com.liuyonglong.controller;

import com.liuyonglong.bean.Student;
import com.liuyonglong.dao.BaseServlet;
import com.liuyonglong.service.StudentService;
import com.liuyonglong.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@MultipartConfig //告诉Servlet 需要上传文件
@WebServlet("/stu")
public class StudentServlet extends BaseServlet {


    //添加学生的方法
    public void addStu(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取数据
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String sbir = req.getParameter("sbir");
      //  String[] hobby = req.getParameterValues("hobby");
      //  String hobbys = Arrays.toString(hobby);
        String[] hobbys = req.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbys);

        //获取文件名上传组件
        Part part = req.getPart("file");
        //获取上传文件的名称 tomcat 8.0以后才支持
        String fileName = part.getSubmittedFileName();
        System.out.println("fileName = " + fileName);

        //使用UUID生成文件名
        String uuid = UUID.randomUUID().toString();
        //拼接完整的文件名 且唯一
        fileName = uuid + fileName;
        //头像保存路径
        String path = "E:\\upload";
        //  File.separator 文件夹分隔符常量  拼接完整的路径
        String filepath = path + File.separator + fileName;
        System.out.println("filepath = " + filepath);
        //将头像写入磁盘
        part.write(filepath);
        Student student = new Student(null, sname, gender,
                DateUtils.strTranferDate(sbir, "yyyy-MM-dd"), hobby, fileName);
        //创建业务逻辑层对象并调用添加方法
        StudentService ss = new StudentService();
        boolean b = ss.addStu(student);
        //如果添加成功那么去到查询页面  否则去错误页面
        if (b){
            resp.sendRedirect("stu?method=queryStu");
        }else {
            req.getRequestDispatcher("adderror.jsp").forward(req,resp);
        }
    }
}
