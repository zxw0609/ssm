<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>失物招领平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/mian.css">
</head>
<body class="lay-blog">
<c:if test="${empty act1}">
    <jsp:forward page="/Infor/findAll"/>
</c:if>
<%HttpSession s=request.getSession();%>
<c:if test="${not empty error}">
    <script type="text/javascript" language="javascript">alert("${error}");</script>
    <%s.removeAttribute("error");%>
</c:if>
<%s.removeAttribute("act1");%>

<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="index.jsp">
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
                <li class="layui-nav-item layui-this"><a href="index.jsp">首页</a></li>
                <li class="layui-nav-item"><a href="informationPublish.jsp">信息发布</a></li>
                <li class="layui-nav-item"><a href="login.jsp">登录/注册</a></li>
                <li class="layui-nav-item">
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
        <li><a href="index">首页</a></li>
        <li><a href="informationPublish.jsp">信息发布</a></li>
        <li><a href="login">登录/注册</a></li>
    </ul>
</div>
<div class="container-wrap">
    <div class="container container-message">
        <div class="contar-wrap">
            <h4 class="item-title">
                <p><i class="layui-icon layui-icon-speaker"></i>公告：<span>欢迎来到闲言失物招领平台</span></p>
            </h4>
            <c:if test="${empty inforList}">
                <h3 align="center">什么都没找到唉~</h3>
            </c:if>
            <c:if test="${not empty inforList}">
                <c:forEach items="${inforList}" var="Infor">
                    <div class="item">
                        <div class="item-box  layer-photos-demo1 layer-photos-demo">
                            <img class="info-img" src="../uploads/${Infor.headPortrait}" alt="" style="width:auto;heigth:auto; max-width:48px; max-height:48px;margin-top: 10px;">
                            <h3><a href="">${Infor.username }</a></h3>
                            <h5>发布于：<span>${Infor.stape }</span></h5>
                            <p>物品名：${Infor.tname}<br>时间：${Infor.tape}<br>地点：${Infor.locar}<br>类型：${Infor.genre}<br>物品描述： ${Infor.infor }</p>
                            <c:if test="${not empty Infor.image}">
                                <img src="../uploads/${Infor.image}" alt="" style="width:auto;heigth:auto; max-width:300px; max-height:300px;">
                            </c:if>
                        </div>
                        <div class="comment count" >
                            <a href="../Message/find?inforId=${Infor.id}" style="width: 100%;">留言</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>
        <!-- <div class="item-btn">
            <button class="layui-btn layui-btn-normal">下一页</button>
        </div> -->
    </div>
</div>
<div class="footer">
    <p>
        <span>&copy; 2020</span>
        <span>闲言失物招领平台</span>
    </p>
    <p><span>日行一善</span></p>
</div>
<script src="../res/layui/layui.js"></script>
<script>
    layui.config({
        base: '../res/static/js/'
    }).use('blog');
</script>
</body>
</html>

