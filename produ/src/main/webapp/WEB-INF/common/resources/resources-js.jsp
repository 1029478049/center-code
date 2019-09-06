<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<base href="${ctx}/">
<script>
    var ctx = '${ctx}';
</script>

<%--JQuery js 引入--%>
<script src="${ctx}/src/main/webapp/js/jquery.min.js?v=2.1.4"></script>
<!--自定义js -->
<script src="${ctx}/src/main/webapp/js/common/utils.js"></script>

<script src="${ctx}/src/main/webapp/js/common/layer/layer.min.js"></script>
<script src="${ctx}/src/main/webapp/js/bootstrap.min.js?v=3.3.6"></script>

<script src="${ctx}/src/main/webapp/js/content.min.js?v=1.0.0"></script>
<script src="${ctx}/src/main/webapp/js/plugins/jqGrid/i18n/grid.locale-cnffe4.js?0820"></script>
<script src="${ctx}/src/main/webapp/js/plugins/jqGrid/jquery.jqGrid.minffe4.js?0820"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fns" uri="http://java.sun.com/jsp/jstl/functionss" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="g" tagdir="/WEB-INF/tags/g" %>
<%@ taglib prefix="sys" uri="http://java.sun.com/jsp/jstl/functionss" %>
<fmt:setTimeZone value="Asia/Shanghai"/><%-- 设置jsp时区 --%>

<script src="${ctx}/src/main/webapp/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<%--<script src="${ctx}/src/main/webapp/js/hplus.min.js?v=4.1.0"></script>--%>
<script src="${ctx}/src/main/webapp/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/src/main/webapp/js/contabs.min.js" type="text/javascript"></script>
<script src="${ctx}/src/main/webapp/js/plugins/pace/pace.min.js"></script>

<script src="${ctx}/src/main/webapp/js/plugins/iCheck/icheck.min.js"></script>

<script src="${ctx}/src/main/webapp/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/jsKnob/jquery.knob.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/nouslider/jquery.nouislider.min.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/switchery/switchery.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

<script src="${ctx}/src/main/webapp/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/clockpicker/clockpicker.js"></script>
<script src="${ctx}/src/main/webapp/js/plugins/cropper/cropper.min.js"></script>

<%--<script src="${ctx}/src/main/webapp/js/plugins/echarts/echarts.common.min.js"></script>--%>
<!-- jquery validate -->
<script src="${ctx}/src/main/webapp/static/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/src/main/webapp/static/plugins/validate/messages_zh.min.js"></script>

<script src="${ctx}/src/main/webapp/static/js/tree_table/jeeplus.js"></script>
<script src="${ctx}/src/main/webapp/static/js/tree_table/mustache.min.js"></script>
<script src="${ctx}/src/main/webapp/static/js/tree_table/jquery.treeTable.min.js"></script>

<!-- jquery-json -->
<script type="text/javascript" src="${ctx}/src/main/webapp/static/js/jquery-json/jquery.json.min.js"></script>