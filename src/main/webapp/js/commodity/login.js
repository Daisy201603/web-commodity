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

            $.ajax({
                type: "POST",
                url: "user/login",
                async:false,
                data: {username:name, password:password},
                dataType: "json",
                success: function(data){
                    if(null != data && data.id != ""){
                        //如果直接跳转至jsp的话不行 因为WEB-INF下的jsp是访问不到的
                        //所以应该是跳转至控制器然后由控制器跳转
                        forwardFlag = true;
                    }
                },
                error : function () {
                    $.messager.alert('alert','Username or password is incorrect!');
                    login.clearForm();

                }
            });
            if(forwardFlag){
                window.location.href = "user/showUser";
                window.event.returnValue=false;
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
