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
        userLogin:function () {
            var forwardFlag = false;
            var name = $("input[name = username]").val();
            var password = $("input[name = password]").val();
            if(null == name || name == "" || name === ""){
                $("input[name = username]").focus();
                return;
            }else if(null == password || password == "" || password === ""){
                $("input[name = password]").focus();
                return;
            }

            var user = {};
            user.userName = name;
            user.password = password;

            $.ajax({
                type: "POST",
                url: "userLogin",
                async:false,
                data: JSON.stringify(user),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function(data){
                    if(data){
                        //如果直接跳转至jsp的话不行 因为WEB-INF下的jsp是访问不到的
                        //所以应该是跳转至控制器然后由控制器跳转
                        forwardFlag = true;
                    }
                },
                error : function () {
                    $.messager.alert('alert','Username or password is incorrect!');
                }
            });
            if(forwardFlag){
                //登录成功，跳转至主页
                window.location.href = "showUser";
            }
        },
        /**
         * 注册
         */
        signIn : function(){
        $('#ff').form('clear');
    }
    }


    login.init();
    module.exports = login;
    window.login = login;
});
