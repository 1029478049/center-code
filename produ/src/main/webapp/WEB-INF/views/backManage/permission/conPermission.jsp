<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="该角色未绑定的资源" cssStyle="padding:0">
        <g:grid id="permissionList" action="${ctx}/permissionPath/queryUnboundRolePermission">
            <input type="hidden" name = "roleId" value="${roleId}">
            <g:form-field label="url地址" placeholder="url地址" type="text" id="url" name="url" inline="true"/>
            <g:form-field label="url描述" placeholder="url描述" type="text" id="name" name="name" inline="true"/>
        </g:grid>
        <div id="permissionListToolbar">
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="connet" title="关联资源"><i class="glyphicon glyphicon-play-circle"></i> 关联</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
        </div>
    </g:box>
</div>
<%--<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>--%>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#permissionList', [
        {name: "id", hidden: true},
        {
            label: "url描述",
            name: "name",
            index: "name",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "url地址",
            name: "url",
            index: "url",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "创建人",
            name: "createBy",
            index: "createBy",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "上一次修改人",
            name: "lastModifyBy",
            index: "lastModifyBy",
            width: '120px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '130px',
            sortable: false,
            editable: true,
            align: 'center'
        }
    ], {
        shrinkToFit: false
    });
    function connetFun() {
        var perRow = searcher.getSelectedRows();
        if (perRow.length == 0) {
            Dialog.alert("至少选择一个资源进行关联");
            return;
        }
        var roleRow = parent.parent.searcher.getSelectedRows()[0];
        var rId = roleRow.id;
        var pId = "";
        for(var i=0;i< perRow.length;i++){
            pId += perRow[i].id + ",";
        }
        pId = pId.substring(0,pId.length-1);
        Dialog.confirm("确认要关联？", function () {
            Page.ajaxPOST("${ctx}/permissionPath/doConnet", {roleId:rId,pId:pId}, function(data) {
                if (data.success) {
                    Dialog.msg(data.successMessage);
                    searcher.query();
                }
            });
        });
    }
    function refreshFun() {
        searcher.query(true);
    }
    $(function () {
        $("#connet").click(connetFun);
        $("#refresh").click(refreshFun);
    })
</script>
