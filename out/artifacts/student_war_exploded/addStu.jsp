
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生页面</title>
<%--    引入js--%>
    <script type="text/javascript" src="WEB-INF/jquery-3.6.0.js"></script>
</head>
<body>
<%--要传头像所以用 post请求 entype必须为multipart/form-data--%>
<form action="stu" method="post" enctype="multipart/form-data">
<%--     设置请求分发时执行的方法名称--%>
    <input type="hidden" name="method" value="addStu">
    姓名:<input type="text" name="sname"><br>
    性别:男<input type="radio" value="男" name="gender">
        女<input type="radio" value="女" name="gender"><br>

    生日:<input type="text" class="Wdate" name="sbir"
            onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"><br>

    爱好:
        <input type="checkbox" value="打球" name="hobby">打球
        <input type="checkbox" value="唱歌" name="hobby">唱歌
        <input type="checkbox" value="跳舞" name="hobby">跳舞
        <input type="checkbox" value="把妹" name="hobby">把妹<br>
    头像:<input type="file" name="file"><br>
    <input type="submit" value="添加学生">

</form>
</body>
</html>
