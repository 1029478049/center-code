<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
    /*.ui-jqgrid .ui-jqgrid-title{font-size:10px;}    !*修改grid标题的字体大小*!

    .ui-jqgrid-sortable {font-size:15px;}   !*修改列名的字体大小*!

    .!*ui-jqgrid tr.jqgrow td {font-size:20px; font-family:"宋体"}*! !*修改表格内容字体*!*/
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="代码修改说明" cssStyle="padding:0">
        <g:grid id="logList" action="${ctx}/codeLogs/queryLogs">
            <g:form-field label="版本" placeholder="版本" type="text" id="version" name="version" inline="true"/>
        </g:grid>
        <div id="logListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
        </div>
    </g:box>
</div>
<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#logList', [
        {name: "id", hidden: true},
        {
            label: "版本",
            name: "version",
            index: "version",
            width: '240px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "更新内容",
            name: "recommend",
            index: "recommend",
            width: '500px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "创建人",
            name: "createBy",
            index: "createBy",
            width: '300px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '300px',
            sortable: false,
            editable: true,
            align: 'center'
        }
    ], {
        shrinkToFit: false
    });
    function addFun() {
        Dialog.openUrl('添加日志', '${ctx}/codeLogs/add',{
            area : ['560px' , '380px'],
            end: function () {
                //刷新列表
                searcher.query();
            }
        });
    }
    function deletedFun() {
        var result = searcher.getSelectedRows();
        if (result.length == 0) {
            Dialog.alert("请选择一行数据进行操作");
            return;
        }
        Dialog.confirm("确认要删除？", function () {
            Page.ajaxPOST("${ctx}/codeLogs/deletedLog", {id:result[0].id}, function(data) {
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
    function impowerFun() {
        var row = searcher.getSelectedRows();
        if (row.length == 0) {
            Dialog.alert("请选择一个用户进行授权!");
        }else {
            if (row.length != 1) {
                Dialog.alert("请选择一个用户进行授权!");
            } else {
                var id = row[0].id;
                var userName = row[0].userName;
                Dialog.openUrl('查看['+userName+']绑定的角色', '${ctx}/rolePath/toImpower?id='+id,{
                    area : ['1000px' , '500px'],
                    end: function () {
                        //刷新列表
                        searcher.query();
                    }
                });
            }
        }
    }
    $(function () {
        $("#addId").click(addFun);
        $("#deletedId").click(deletedFun);
        $("#refresh").click(refreshFun);
    })
</script>
