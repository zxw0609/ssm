<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>闲言-修改用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/mian.css">
</head>
<%HttpSession s=request.getSession();%>
<c:if test="${empty user}">
    <script type="text/javascript" >
        alert("您还未登录");
        window.location.href="login.jsp";
    </script>
    <%--<jsp:forward page="login.jsp"/>--%>
</c:if>
<body class="lay-blog">
<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="index.html">
                <img src="../res/static/images/logo.png" alt="" class="logo-img">
                <img src="../res/static/images/logo-text.png" alt="" class="logo-text">
            </a>
        </h1>
        <form class="layui-form blog-seach pull-left" action="../Infor/find">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <i class="layui-icon layui-icon-search"></i>
                    <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
        </form>
        <div class="blog-nav pull-right">
            <ul class="layui-nav pull-left">
                <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
                <li class="layui-nav-item"><a href="informationPublish.jsp">信息发布</a></li>
                <li class="layui-nav-item"><a href="login.jsp">登录/注册</a></li>
                <li class="layui-nav-item layui-this">
                    <a class="layui-icon layui-icon-username" href="#"></a>
                    <dl class="layui-nav-child" style="z-index: 2000;">
                        <dd><a href="../Infor/userFind">已发信息</a></dd>
                        <dd><a href="updateUser.jsp">修改信息</a></dd>
                        <dd><a href="updatePas.jsp">修改密码</a></dd>
                        <dd><a href="../User/exit">退出登录</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <ul class="pop-nav" id="pop-nav">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="informationPublish.jsp">信息发布</a></li>
        <li><a href="login.jsp">登录/注册</a></li>
    </ul>
</div>
<div class="container-wrap">
    <div class="container container-message container-details container-about">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box">
                    <ul class="layui-tab-title">

                        <li class="layui-this">修改个人信息</li>
                    </ul>
                    <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                        <div class="layui-tab-item layui-show">
                            <div class="layui-form layui-form-pane">
                                <form method="post" action="../User/update" enctype="multipart/form-data">
                                    <div class="layui-form-item">
                                        <label for="L_stu" class="layui-form-label">学号</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="L_stu" name="stu" required lay-verify="required"
                                                   autocomplete="off" value="${user.stu}"class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label for="L_name" class="layui-form-label">姓名</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="L_name" name="name" required lay-verify="required"
                                                   autocomplete="off" value="${user.name}"class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label for="L_grade" class="layui-form-label">班级</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="L_grade" name="grade" required lay-verify="required"
                                                   autocomplete="off" value="${user.grade}"class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label for="L_magor" class="layui-form-label">专业</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="L_magor" name="magor" required lay-verify="required"
                                                   autocomplete="off" value="${user.magor}" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label for="L_department" class="layui-form-label">院系</label>
                                        <div class="layui-input-inline">
                                            <input type="text" id="L_department" name="department" required
                                                   lay-verify="required" value="${user.department}"autocomplete="off" class="layui-input">
                                        </div>
                                    </div>

                                    <div class="layui-form-item">
                                        <label class="layui-form-label">头像</label>
                                        <div class="layui-input-inline" style="border: 1px solid #e6e6e6;">
                                            修改头像
                                            <input type="file" name="upload" style="position: absolute;overflow: hidden;right: 0;top: 0;opacity: 0;cursor: pointer;">
                                        </div>
                                    </div>

                                    <div class="layui-form-item">
                                        <button class="layui-btn" lay-filter="*" lay-submit>修改</button>
                                        <span style="padding-left:20px;">
						                </span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <p>
        <span>&copy; 2019</span>
        <span><a href="http://www.layui.com" target="_blank">layui.com</a></span>
        <span>MIT license</span>
    </p>
    <p><span>日行一善</span></p>
</div>
<script src="../res/layui/layui.js">

</script>
<script>
    layui.config({
        base: '../res/static/js/'
    }).use('blog');
</script>
</body>
</html>