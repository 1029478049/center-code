<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="用户未绑定的角色" cssStyle="padding:0">
        <g:grid id="roleList" action="${ctx}/rolePath/queryUnboundUserRole">
            <input type="hidden" name = "uId" value="${uId}">
            <g:form-field label="角色名称" placeholder="角色名称" type="text" id="name" name="name" inline="true"/>
            <g:form-field label="角色类型" placeholder="角色类型" type="text" id="type" name="type" inline="true"/>
        </g:grid>
        <div id="roleListToolbar">
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="doImpower" title="授权"><i class="glyphicon glyphicon-play-circle"></i> 授权</button>
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
            width: '120px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "角色类型",
            name: "type",
            index: "type",
            width: '120px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "角色描述",
            name: "roleDesc",
            index: "roleDesc",
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
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '140px',
            sortable: false,
            editable: true,
            align: 'center'
        }
    ], {
        shrinkToFit: false
    });
    function doImpowerFun() {
        var roleRow = searcher.getSelectedRows();
        if (roleRow.length == 0) {
            Dialog.alert("至少选择一个角色进行授权");
            return;
        }
        var userRow = parent.parent.searcher.getSelectedRows()[0];
        var uId = userRow.id;
        var rId = "";
        for(var i=0;i< roleRow.length;i++){
            rId += roleRow[i].id + ",";
        }
        rId = rId.substring(0,rId.length-1);
        Dialog.confirm("确认要授权？", function () {
            Page.ajaxPOST("${ctx}/rolePath/doImpowerOper", {uId:uId,rId:rId}, function(data) {
                if (data.success) {
                    Dialog.msg(data.successMessage);
                    searcher.query();
                }
            });
        });
    }
    $(function () {
        $("#doImpower").click(doImpowerFun);
    })
</script>
