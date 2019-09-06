<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jspf"%>
<%@include file="../common/resources-js.jsp" %>
<%@include file="../common/resources-css.jsp" %>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="工作人员管理" cssStyle="padding:0">
        <g:grid id="stuList" action="${ctx}/workPath/queryWork">
            <g:form-field label="姓名" placeholder="姓名" type="text" id="name" name="name" inline="true"/>
            <g:form-field label="职位" type="select" id="position" name="position" inline="true">
                <option value="0">招生顾问</option>
                <option value="1">前台</option>
            </g:form-field>
        </g:grid>
        <div id="stuListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="updateId" title="修改"><i class="glyphicon glyphicon-play-circle"></i> 修改</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="right" id="queryTarget" title="查看目标学员"><i class="glyphicon glyphicon-play-circle"></i> 查看目标学员</button>
        </div>
    </g:box>
</div>
<%--<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>--%>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#stuList', [
        {name: "id", hidden: true},
        {
            label:"职位",
            name:"position",
            index:"position",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center',
            formatter:Formatter.showDesc({0:"招生顾问",1:"前台"})
        },
        {
            label: "姓名",
            name: "name",
            index: "name",
            width: '85px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "性别",
            name: "gender",
            index: "gender",
            width: '50px',
            sortable: false,
            editable: true,
            align: 'center',
            formatter:Formatter.showDesc({0:"女",1:"男"})
        },
        {
            label: "年龄",
            name: "age",
            index: "age",
            width: '50px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label: "工作年龄",
            name: "workerAge",
            index: "workerAge",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "最高学历",
            name: "maxEducation",
            index: "maxEducation",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },
       {
            label:"家庭地址",
            name:"address",
            index:"address",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"邮件",
            name:"email",
            index:"email",
            width: '120px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"紧急联系人电话",
            name:"emergencyContactPhone",
            index:"emergencyContactPhone",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"紧急联系人",
            name:"emergencyContact",
            index:"emergencyContact",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"入职时间",
            name:"workTime",
            index:"workTime",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"电话",
            name:"phone",
            index:"phone",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        }
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
    function queryTargetFun() {
        var row = searcher.getSelectedRows();
        if (row.length == 0) {
            Dialog.alert("请选择一名工作人员进行操作!");
        }else {
            if (row.length != 1) {
                Dialog.alert("请选择一名工作人员进行操作!");
            } else {
                var id = row[0].id;
                Dialog.openUrl('['+row[0].name+']发展的目标学生列表', '${ctx}/stuPath/targetList?id='+id,{
                    area : ['1000px' , '520px'],
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
        $("#queryTarget").click(queryTargetFun);
    })
</script>
