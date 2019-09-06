<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../common/taglibs.jspf"%>
<%@include file="../../common/resources-js.jsp" %>
<%@include file="../../common/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="权限管理" cssStyle="padding:0">
        <g:grid id="permissionList" action="${ctx}/permissionPath/queryPermission">
            <g:form-field label="url地址" placeholder="url地址" type="text" id="url" name="url" inline="true"/>
            <g:form-field label="url描述" placeholder="url描述" type="text" id="name" name="name" inline="true"/>
        </g:grid>
        <div id="permissionListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="updateId" title="修改"><i class="glyphicon glyphicon-play-circle"></i> 修改</button>
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
    function addFun() {
        Dialog.openUrl('添加权限', '${ctx}/userPath/toAdd',{
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
                Dialog.openUrl('修改权限', '${ctx}/userPath/toEdit?id='+id,{
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
    $(function () {
        $("#addId").click(addFun);
        $("#updateId").click(updateFun);
        $("#deletedId").click(deletedFun);
        $("#refresh").click(refreshFun);
    })
</script>
