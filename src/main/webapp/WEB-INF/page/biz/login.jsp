<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/header.jsp"%>
<html>
<head>
    <title>用户登录</title>

</head>
<body>
    <p>Fill the form and submit it.</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="login" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" method="post">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="username"   style="width:100%" data-options="label:'UserName:',required:true,missingMessage:'请输入用户名'">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="password" type="password" style="width:100%" data-options="label:'Password:',required:true,missingMessage:'请输入密码'">
            </div>
            <%--<div style="margin-bottom:20px">
                <input class="easyui-textbox" name="subject" style="width:100%" data-options="label:'Subject:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="message" style="width:100%;height:60px" data-options="label:'Message:',multiline:true">
            </div>
            <div style="margin-bottom:20px">
                <select class="easyui-combobox" name="language" label="Language" style="width:100%"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
            </div>--%>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="login.userLogin()" style="width:80px">Login</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="login.signIn()" style="width:80px">Sign in</a>
        </div>
    </div>
    <script type="text/javascript">
        seajs.use("${contextPath}/js/commodity/login");
    </script>
</body>
</html>
<%@ include file="/WEB-INF/page/common/footer.jsp"%>
