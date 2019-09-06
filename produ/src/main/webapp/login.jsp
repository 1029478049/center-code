<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <meta name="keywords"
          content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates"/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <%@ include file="WEB-INF/layouts/default.jsp" %>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function (c) {
        $('.close').on('click', function (c) {
            $('.login-form').fadeOut('slow', function (c) {
                $('.login-form').remove();
            });
        });
    });
</script>
<!--SIGN UP-->
<h1>环时教育</h1>
<div class="login-form">
    <div class="close"></div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="images/avtar.png" alt="头像"/>
    </div>
    <h4 id="erro" style="color: red"></h4>
    <form>
        <input type="text" class="text" id="username" name="username" placeholder="请输入用户名"/>
        <div class="key">
            <input type="password" id="password" name="password" placeholder="请输入密码"/>
        </div>
        <div class="signin">
            <input type="button" id="loginSys" value="Login"/>
        </div>
    </form>

</div>
<div class="copy-rights">
    <p>Copyright &copy; 2017.Company <a href="http://www.huanshijiaoyu.com" target="_blank" title="环时教育">环时教育</a>.More
        Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a
                href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
</div>
<script type="text/javascript">
    $(function () {
        //绑定输入框，这里只能 是ID
        $("#username").keydown(function (event) {
            event = document.all ? window.event : event;
            if ((event.keyCode || event.which) == 13) {
                if ($("#username").val().trim() == "") {
                    layer.alert("请输入用户名");
                    //$("#usernameMiss").html("请输入用户名");
                    return;
                } else {
                    $("#password").focus();
                }
            }
        });
        $("#password").keydown(function (event) {
            event = document.all ? window.event : event;
            if ((event.keyCode || event.which) == 13) {
                if ($("#password").val().trim() == "") {
                    layer.alert("请输入密码");
                    return;
                } else {
                    $("#loginSys").trigger('click');
                }
            }
        });
    });
    $("#loginSys").click(function () {
        var userNameVar = $("#username").val();
        var passwordVar = $("#password").val();
        $.post("/ajaxLogin", {username: userNameVar, password: passwordVar}, function (result) {
            if (result.success) {
                location.href = "/paltform";
            } else {
                $("#erro").html(result.errorMessages);
            }
        });
    });

    /*密码加密*/
    function Encrypt(word){
        var key = CryptoJS.enc.Utf8.parse("login_ashare_sys");
        var srcs = CryptoJS.enc.Utf8.parse(word);
        var encrypted = CryptoJS.AES.encrypt(srcs, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
        return encrypted.toString();
    }
</script>
</body>
</html>