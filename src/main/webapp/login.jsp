<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/header.jsp"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${contextPath}/images/favicon.ico">
    <title>用户登录</title>
    <link href="${contextPath}/css/signin.css" rel="stylesheet">
    <style>
        .white_content {
            display: none;
            position: absolute;
            top: 25%;
            left: 35%;
            width: 20%;
            height: 55%;
            padding: 20px;
            border: 10px solid #2aabd2;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
    </style>
</head>
    <body class="personal-text-center">
        <div >
            <form class="form-signin">
                <input type="text" id="account" class="form-control" value="${user.account}" placeholder="电子邮箱或手机号码" required autofocus>
                <input type="password" id="password" class="form-control" style="margin-top: 10px" value="${user.password}" placeholder="密码" required>
                <div class="checkbox mb-3" style="margin-left: 45px">
                    <label>
                        <input type="radio" name="remember">记住我
                    </label>

                    <a style="margin-left: 20px" onclick="login.register()">注册</a>

                </div>
            </form>
            <a href="javascript:void(0)" class="btn btn-lg btn-primary btn-block" style="width: 250px;margin-left: 3px" onclick="login.userLogin()" style="width:80px">登录</a>

            <p class="mt-5 mb-3 text-muted" style="margin-left: 80px">&copy;  2015 - 2018</p>
        </div>

        <div id="register" class="white_content" style="display: none; float:left">
            <label>昵称：</label>
            <input type="text" id="username" class="form-control">
            <label>电话：</label>
            <input type="text" id="phone" class="form-control">
            <label>邮箱：</label>
            <input type="text" id="email" class="form-control">
            <label>密码：</label>
            <input type="password" id="registerPassword" class="form-control">
            <button class="btn btn-lg btn-primary btn-block" style="width: 100px" onclick="login.save()">提交</button>
            <button class="btn btn-lg btn-primary btn-block" style="width: 100px" onclick="login.closeRegister()">关闭</button>
        </div>

        <script type="text/javascript">
            seajs.use("${contextPath}/js/commodity/login");
            seajs.data = "${contextPath}";
        </script>

    </body>
</html>
