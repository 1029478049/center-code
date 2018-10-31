<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/3/17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<title><sitemesh:write property='title'/></title>--%>
    <%@include file="../common/resources/resources-js.jsp" %>
    <%--<%@include file="../common/resources/resources-css.jsp" %>--%>
    <%--<sitemesh:write property="head"/>--%>
</head>
<body class="gray-bg top-navigation" style="overflow: auto;">
<sitemesh:write property='body'/>
<%--<script type="text/javascript">if(top===window)window.document.body.style.overflow='hidden';</script>--%>
<%--<script type="text/javascript">
    $(document).ajaxError(function (event, xhr, options) {
        try {
            $.get('${ctx}/checkLogin', function (data) {
                if(String(data) !== 'true') {
                    layer.close(Dialog.lastIndex);
                    top.Dialog.confirm('登录超时，点击确定重新登录。', function () {
                        top.location.href = "${ctx}/login";
                    });
                }
            });
            return false;
        } catch (e) {
        }
    })
</script>--%>
<script type="text/javascript">
    console.log("进入default");
</script>
</body>
</html>
