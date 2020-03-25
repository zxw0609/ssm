<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>闲言-修改物品信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/mian.css">
</head>
<%HttpSession s=request.getSession();%>
<c:if test="${not empty error}">
    <script type="text/javascript" language="javascript">alert("${error}");</script>
    <%s.removeAttribute("error");%>
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
        <form class="layui-form blog-seach pull-left" method="post" action="../Infor/find">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <i class="layui-icon layui-icon-search"></i>
                    <input type="text" name="xinxi" lay-verify="title" autocomplete="off"  class="layui-input">
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
        <li><a href="informationPublish.jsp">上传物品信息</a></li>
        <li><a href="login.jsp">登录/注册</a></li>
    </ul>
</div>
<div class="container-wrap">
    <div class="container container-message ">
        <div class="contar-wrap" id="contar-wrap">
            <div class="item">
                <div class="item-box">
                    <form class="layui-form layui-form-pane" method="post" action="../Infor/update" enctype="multipart/form-data">
                        <div class="layui-form-item">
                            <label class="layui-form-label">物品名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="tname" lay-verify="required" value="${infor.tname}"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">时间</label>
                                <div class="layui-input-block">
                                    <input type="text" name="tape" id="date1" lay-verify="required" autocomplete="off"
                                           value="${infor.tape}" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">图片</label>
                            <div class="layui-input-inline" style="border: 1px solid #e6e6e6;">
                                修改/添加图片
                                <input type="file" name="upload" style="position: absolute;overflow: hidden;right: 0;top: 0;opacity: 0;cursor: pointer;">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">地点</label>
                            <div class="layui-input-block">
                                <input type="text" name="locar" lay-verify="required" autocomplete="off"
                                       value="${infor.locar}" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" pane="">
                            <label class="layui-form-label">类型</label>
                            <div class="layui-input-block">
                                <c:if test="${infor.genre=='失物信息'}">
                                    <input type="radio" name="genre" value="失物信息" title="失物信息" checked="">
                                    <input type="radio" name="genre" value="拾物信息" title="拾物信息">
                                </c:if>
                                <c:if test="${infor.genre=='拾物信息'}">
                                    <input type="radio" name="genre" value="失物信息" title="失物信息">
                                    <input type="radio" name="genre" value="拾物信息" title="拾物信息" checked="">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">物品描述</label>
                            <div class="layui-input-block">
                                <textarea class="layui-textarea" name="infor">${infor.infor}</textarea>
                            </div>
                        </div>

                        <div class="item-btn">
                            <button class="layui-btn" lay-filter="*" lay-submit>提交</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p>
        <span>&copy; 2020</span>
        <span>闲言失物招领平台</span>
    </p>
    <p><span>日行一善</span></p>
</div>
</div>
<script src="../res/layui/layui.js">

</script>
<script>
    layui.config({
        base: '../res/static/js/'
    }).use('blog');
</script>

</body>
