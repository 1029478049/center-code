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
    <g:box id="l" title="用户管理" cssStyle="padding:0">
        <g:grid id="invoceList" action="${ctx}/userPath/queryUser">
            <g:form-field label="用户名称" placeholder="用户名称" type="text" id="userName" name="userName" inline="true"/>
            <g:form-field label="邮箱" placeholder="邮箱" type="text" id="email" name="email" inline="true"/>
            <g:form-field label="是否有效登陆" type="select" id="status" name="status" inline="true">
                <option value="0">否</option>
                <option value="1">是</option>
            </g:form-field>
        </g:grid>
        <div id="invoceListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="updateId" title="修改"><i class="glyphicon glyphicon-play-circle"></i> 修改</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="impower" title="查看角色"><i class="glyphicon glyphicon-play-circle"></i>查看角色</button>
        </div>
    </g:box>
</div>
<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#invoceList', [
        {name: "id", hidden: true},
        {
            label: "用户名称",
            name: "userName",
            index: "userName",
            width: '185px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "邮箱",
            name: "email",
            index: "email",
            width: '280px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "创建人",
            name: "createBy",
            index: "createBy",
            width: '155px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "上一次修改人",
            name: "lastModifyBy",
            index: "lastModifyBy",
            width: '200px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "是否有效登陆",
            name: "status",
            index: "status",
            width: '155px',
            sortable: false,
            editable: true,
            align: 'center',
            formatter:Formatter.showDesc({0:"否",1:"是"})
        },
        {
            label:"创建时间",
            name:"createTime",
            index:"createTime",
            width: '222px',
            sortable: false,
            editable: true,
            align: 'center'
        },
    ], {
        shrinkToFit: false
    });
    function addFun() {
        Dialog.openUrl('添加用户', '${ctx}/userPath/toAdd',{
            area : ['560px' , '380px'],
            end: function () {
                //刷新列表
                searcher.query();
            }
        });
    }
    function updateFun() {
        var row = searcher.getSelectedRows();
        if (row.length == 0) {
            Dialog.alert("请选择一行数据进行操作!");
        }else {
            if (row.length != 1) {
                Dialog.alert("请选择一行数据进行操作!");
            } else {
                var id = row[0].id;
                Dialog.openUrl('修改用户', '${ctx}/userPath/toEdit?id='+id,{
                    area : ['560px' , '355px'],
                    end: function () {
                        //刷新列表
                        searcher.query();
                    }
                });
            }
        }
    }
    function deletedFun() {
        var result = searcher.getSelectedRows();
        console.log(result);
        if (result.length == 0) {
            Dialog.alert("请选择一行数据进行操作");
            return;
        }
        Dialog.confirm("确认要删除？", function () {
            Page.ajaxPOST("${ctx}/userPath/deletedUser", {id:result[0].id}, function(data) {
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
        $("#updateId").click(updateFun);
        $("#deletedId").click(deletedFun);
        $("#refresh").click(refreshFun);
        $("#impower").click(impowerFun);
    })
</script>
