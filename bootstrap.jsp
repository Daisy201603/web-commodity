<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/header.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="icon" href="${contextPath}/images/favicon.ico">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Starter Template for Bootstrap</title>
    
</head>
<body>
<div style="height: 40px">

</div>
<div class="container">
    <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
    </div>
</div>
<div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Action <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group">
    <input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
    <span class="input-group-addon" id="basic-addon2">@example.com</span>
</div>

<div class="input-group">
    <span class="input-group-addon">$</span>
    <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
    <span class="input-group-addon">.00</span>
</div>

<label for="basic-url">Your vanity URL</label>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon3">https://example.com/users/</span>
    <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
</div>
</body>
</html>