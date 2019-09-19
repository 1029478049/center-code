<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>

<div class="wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>二维码管理</h5>
                </div>
                <div class="ibox-content">
                    <img alt="qrcode" id="qrcode" class="qrcode" src=""/>
                    <button class="btn btn-sm btn-primary" id="downloadButton" onclick="downloadIamge()">下载</button>
                    <button class="btn btn-sm btn-primary" style="margin-left: 10px" onclick="cancelIamge()">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        qriCodeUrl = "${ctx}/backManage/qrCode/generatorCode";
        $("#qrcode").attr("src", qriCodeUrl);

    });

    function downloadIamge(selector, name) {
        var proName = "xxx商户";

        // 通过选择器获取img元素，
        var img = document.querySelector("#qrcode");
        // 将图片的src属性作为URL地址
        var url = img.src;
        var a = document.createElement('a');
        var event = new MouseEvent('click');

        a.download = proName + ".jpg" || '下载图片名称';
        a.href = url;

        a.dispatchEvent(event)
    }

    function cancelIamge() {
        parent.location.reload();
    }
</script>
