<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="该角色挂的资源" cssStyle="padding:0">
        <g:grid id="permissionList" action="${ctx}/permissionPath/queryBoundRolePermission">
            <input type="hidden" name = "roleId" value="${roleId}">
            <g:form-field label="url地址" placeholder="url地址" type="text" id="url" name="url" inline="true"/>
            <g:form-field label="url描述" placeholder="url描述" type="text" id="name" name="name" inline="true"/>
        </g:grid>
        <div id="permissionListToolbar">
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="conPermission" title="关联资源"><i class="glyphicon glyphicon-play-circle"></i> 关联资源</button>
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="cancelPermission" title="解除资源"><i class="glyphicon glyphicon-play-circle"></i> 解除资源</button>
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
            width: '240px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "url地址",
            name: "url",
            index: "url",
            width: '280px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "创建人",
            name: "createBy",
            index: "createBy",
            width: '220px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "上一次修改人",
            name: "lastModifyBy",
            index: "lastModifyBy",
            width: '220px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '240px',
            sortable: false,
            editable: true,
            align: 'center'
        }
    ], {
        shrinkToFit: false
    });
    function refreshFun() {
        searcher.query(true);
    }
    function conPermissionFun() {
        var row = parent.searcher.getSelectedRows();
        var id = row[0].id;
        var name = row[0].name;
        Dialog.openUrl('给['+name+']角色关联资源', '${ctx}/permissionPath/conPermission?id='+id,{
            area : ['800px' , '400px'],
            end: function () {
                //刷新列表
                searcher.query();
            }
        });
    }
    function cancelPermissionFun() {
        layer.alert("解除资源");
    }
    $(function () {
        $("#refresh").click(refreshFun);
        $("#conPermission").click(conPermissionFun);
        $("#cancelPermission").click(cancelPermissionFun);
    })
</script>
