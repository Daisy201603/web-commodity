<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/common/header.jsp"%>
<html>
<head>
    <title>主页</title>
</head>

<body class="personal-text-center">
    <div style="float: left; width: 30%">
        <div class="panel panel-default" style="height: 30%">
            <div class="panel-heading">用户批量导入</div>
            <div class="panel-body">
                <button type="button" class="btn btn-default">下载导入模板</button>
                <form method="POST" enctype="multipart/form-data" action="${contextPath}/file/uploadHeadPortrait">
                    <input type="submit" class="btn btn-default" value="上传用户头像"/><br/>
                    <input type="file" name="headPortrait" accept="image/jpeg,image/png,image/gif"/>
                </form>

            </div>
        </div>
    </div>

</body>
</html>
