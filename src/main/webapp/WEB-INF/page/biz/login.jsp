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
</head>
    <body class="personal-text-center">
        <div >
            <form class="form-signin">
                <label for="username" class="sr-only">用户名</label>
                <input type="text" id="username" name="username" class="form-control" value="${user.userName}" placeholder="Username" required autofocus>
                <label for="password" class="sr-only">密码</label>
                <input type="password" id="password" name="password" class="form-control" style="margin-top: 10px" value="${user.password}" placeholder="Password" required>
                <div class="checkbox mb-3" style="margin-left: 80px">
                    <label>
                        <input type="checkbox" value="remember-me">记住我
                    </label>
                </div>
            </form>
            <a href="javascript:void(0)" class="btn btn-lg btn-primary btn-block" style="width: 250px;margin-left: 3px" onclick="login.userLogin()" style="width:80px">Login</a>

            <p class="mt-5 mb-3 text-muted" style="margin-left: 80px">&copy; 2017-2018</p>
        </div>

        <script type="text/javascript">
            seajs.use("${contextPath}/js/commodity/login");
            seajs.data = "${contextPath}";
        </script>

    </body>
</html>
