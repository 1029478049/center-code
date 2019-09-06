<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--属性列表--%>
<%@ attribute name="id"        type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="title"     type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="info"     type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="className" type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="cssStyle"  type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="toggle"    type="java.lang.Boolean" required="false" rtexprvalue="true" description="是否可以隐藏显示该box，生成的元素ID为 ${id}Toggle" %>
<%--默认值设置--%>
<c:set var="className" value="${not empty className ? className : 'col-sm-12'}" />
<c:set var="toggle"    value="${not empty toggle    ? toggle    : false}" />

<%--标签内容--%>
<c:if test="${toggle}">
    <!-- 显示/隐藏按钮 -->
    <a id="${id}Toggle" style="z-index:9999;position: fixed;top:200px;width:15px;text-align: center;height: 100px;background: #1ab394;color: white;cursor: pointer"><i style="line-height: 100px" class="fa fa-chevron-left"></i></a>
</c:if>

<div id="${id}" class="${className}" style="${cssStyle}">
    <div class="ibox" style="margin-bottom: 0">
        <!-- TITLE -->
        <c:if test="${not empty title}">
            <div class="ibox-title">
                <h5>${title}</h5>
                <c:if test="${not empty info}">
                    <h6 style="color:red;margin-top:2px;">${info}</h6>
                </c:if>
                <div class="ibox-tools" id="${id}Tools"></div>
            </div>
        </c:if>
        <!-- CONTENT -->
        <div class="ibox-content">
             <jsp:doBody />
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        // 添加工具栏
        $('#${id}Tools').prepend($('#${id}Toolbar').children());
        // 绑定toggle
        $('#${id}Toggle').click(function () {
            if($('#${id}').is(':visible')){ // 显示
                $(this).find('i').removeClass('fa-chevron-left').addClass('fa-chevron-right');
            } else {
                $(this).find('i').removeClass('fa-chevron-right').addClass('fa-chevron-left');
            }
            $('#${id}').toggle();
        });
    });
</script>