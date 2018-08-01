/**
 * Created by Administrator on 2017/8/10.
 */
define(function (require,exports,module) {

    var login = {

        /**
         * 初始化
         * */
        init:function () {

        },

        /**
         * 用户登录
         * */
        userLogin : function () {
            var me = this;
            var forwardFlag = false;
            var account = $("#account").val();
            var password = $("#password").val();
            if(!me.valueCheck(account)){
                $("#account").focus();
                return;
            }else if(!me.valueCheck(password)){
                $("#password").focus();
                return;
            }

            var user = {};
            user.account = account;
            user.password = password;

            $.ajax({
                type: "POST",
                url: "../user/userLogin",
                async:false,
                data: JSON.stringify(user),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function(data){
                    if(data){
                        // 直接跳转至jsp的话不行 因为WEB-INF下的jsp是访问不到的
                        // 且ajax访问spring控制器再重定向是不行的
                        // 所以应该是跳转至控制器然后由控制器跳转
                        forwardFlag = true;
                    }
                }
            });
            if(forwardFlag){
                //登录成功，跳转至主页
                window.location.href = "homepage";
            } else {
                alert("账号或密码错误！");
            }
        },

        /**
         * 注册
         */
        signIn : function(){
            $('#ff').form('clear');
        },

        /**
         * 参数判断
         */
        valueCheck : function (value) {
            if (value == null || value == "" || value === "" || value == "undefined") {
                return false;
            }
            return true;
        },

        /**
         * 注册
         */
        register : function () {
            var obj = $("#register");
            obj.show();
        },

        /**
         * 关闭注册框
         */
        closeRegister : function () {
            $("#register").hide();
        },

        /**
         * 保存
         */
        save : function () {
            var me = this;
            var username = $("#username").val();
            var phone = $("#phone").val();
            var email = $("#email").val();
            var registerPassword = $("#registerPassword").val();
            if(!me.valueCheck(username)){
                $("#username").focus();
                return;
            }else if(!me.valueCheck(phone)){
                $("#phone").focus();
                return;
            }else if(!me.valueCheck(email)){
                $("#email").focus();
                return;
            }else if(!me.valueCheck(registerPassword)){
                $("#registerPassword").focus();
                return;
            }

            var user = {};
            user.username = username;
            user.phone = phone;
            user.email = email;
            user.password = registerPassword;
            // 下面代码中的url路径为什么这么写 原因有2
            // 如果你项目配置了项目名在tomcat里面 那么可能使用相对路径访问不到controller
            // 所以加两个点表示上层目录
            // 可以参考：https://blog.csdn.net/qq_27740983/article/details/76125627
            $.ajax({
                type: "POST",
                url: "../user/userRegister",
                async:true,
                data: JSON.stringify(user),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function(data){
                    alert(data.msg);
                    me.closeRegister();
                }
            });
        }
    }


    login.init();
    module.exports = login;
    window.login = login;
});
