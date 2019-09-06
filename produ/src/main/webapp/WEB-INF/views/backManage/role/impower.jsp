<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="当前用户对应的角色" cssStyle="padding:0">
        <g:grid id="roleList" action="${ctx}/rolePath/queryUserRole">
            <input type="hidden" name = "uId" value="${uId}">
            <g:form-field label="角色名称" placeholder="角色名称" type="text" id="name" name="name" inline="true"/>
            <g:form-field label="角色类型" placeholder="角色类型" type="text" id="type" name="type" inline="true"/>
        </g:grid>
        <div id="roleListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="conUser" title="解除授权"><i class="glyphicon glyphicon-play-circle"></i> 解除授权</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="doImpower" title="授权"><i class="glyphicon glyphicon-play-circle"></i> 授权</button>
        </div>
    </g:box>
</div>
<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#roleList', [
        {name: "id", hidden: true},
        {
            label: "角色名称",
            name: "name",
            index: "name",
            width: '160px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "角色类型",
            name: "type",
            index: "type",
            width: '160px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "角色描述",
            name: "roleDesc",
            index: "roleDesc",
            width: '200px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "创建人",
            name: "createBy",
            index: "createBy",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '160px',
            sortable: false,
            editable: true,
            align: 'center'
        }
    ], {
        shrinkToFit: false
    });
    function conUserFun() {
        var roleRow = searcher.getSelectedRows();
        var userRow = parent.searcher.getSelectedRows()[0];
        if (roleRow.length == 0) {
            Dialog.alert("解除授权,起码要选一个吧!");
            return;
        }
        var uId = userRow.id;
        var rId = "";
        for(var i=0;i< roleRow.length;i++){
            rId += roleRow[i].id + ",";
        }
        rId = rId.substring(0,rId.length-1);
        Dialog.confirm("确认要解除授权？", function () {
            Page.ajaxPOST("${ctx}/rolePath/relieveImpowerOper", {uId:uId,rId:rId}, function(data) {
                if (data.success) {
                    Dialog.msg(data.successMessage);
                    searcher.query();
                }
            });
        });
    }
    function doImpowerFun() {
        var row = parent.searcher.getSelectedRows();
                var id = row[0].id;
                var userName = row[0].userName;
                Dialog.openUrl('查看['+userName+']未绑定的角色', '${ctx}/rolePath/doImpower?id='+id,{
                    area : ['800px' , '400px'],
                    end: function () {
                        //刷新列表
                        searcher.query();
                    }
                });
    }
    $(function () {
        $("#conUser").click(conUserFun);
        $("#doImpower").click(doImpowerFun);
    })
</script>
