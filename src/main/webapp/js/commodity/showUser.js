/**
 * Created by Administrator on 2017/8/10.
 */
define("commodity/showUser",function (require,exports,module) {

    var showUser = {
        init:function () {
            $.ajax({
                url : "../user/showUser",
                async : false,
                type : "POST",
                dataType : "json",
                contentType : "application/json"
            });
        }
    }


    showUser.init();
    module.exports = showUser;
    window.showUser = showUser;
});
