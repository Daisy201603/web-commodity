<%@ page import="com.commodity.ssm.model.User" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>
<html>
<%
    User currentUser = (User) request.getSession().getAttribute("user");
    String username;
    Integer userId;
    if (currentUser != null) {
        username = currentUser.getUsername();
        userId = currentUser.getUserId();
    } else {
        username = "";
        userId = -1;
    }
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${contextPath}/js/seaJs/sea.js"></script>
    <script src="${contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${contextPath}/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="${contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/personalCss.css">
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextPath}/user/homepage">Commodity</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${contextPath}/user/homepage">主页</a>
                    </li>
                    <li>
                        <% if (currentUser != null) { %>
                            <li><a href="#about">账号：<%= username%></a></li>
                            <input id="userId" type="text" value="<%= userId%>" hidden="hidden"/>
                            <li><a href="#about" onclick="header.logout()">退出</a></li>
                        <% } %>
                        <li>
                            <img id="userHeadPortrait" width="50px" height="50px" style="background: white"/>
                        </li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <script type="text/javascript">
        seajs.use("${contextPath}/js/commodity/header");
        seajs.data = "${contextPath}";
    </script>
</body>
</html>
