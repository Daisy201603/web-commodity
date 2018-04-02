<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>
<html>
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
                    <li><a href="#about">关于</a></li>
                    <li><a href="#contact">联系我们</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</body>
</html>
