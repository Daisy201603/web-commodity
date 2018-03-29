<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/common/header.jsp"%>
<html>
<head>
    <title>用户信息列表</title>
</head>

<body>
<div id="header" style="margin: 80px">
    <h1>用户列表</h1>
</div>
<div id="featured" style="margin-left: 20px">
    <table>
        <tr>
            <td>姓名</td>
            <td>籍贯</td>
            <td>性别</td>
        </tr>
        <c:if test="${!empty userList}">
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.address}</td>
                    <td>${user.sex}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<!-- Live800在线客服图标:[固定型] 开始-->
<script language="javascript" src="http://care60.dev.live800.com/live800/chatClient/staticButton.js?companyID=8818&configID=405&codeType=custom" charset="UTF-8"></script>
<!-- Live800在线客服图标:[固定型] 结束-->
</body>
</html>
<%@ include file="/WEB-INF/page/common/footer.jsp"%>
