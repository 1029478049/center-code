<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../layouts/default.jsp" %>
<%@ include file="../../common/resources/resources-css.jsp" %>
<style>
</style>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="目标招生学生名单" cssStyle="padding:0">
        <g:grid id="stuList" action="${ctx}/stuPath/queryTargetStu?workerId=${workerId}">
            <g:form-field label="学生名字" placeholder="学生名字" type="text" id="name" name="name" inline="true"/>
            <g:form-field label="邮箱" placeholder="邮箱" type="text" id="email" name="email" inline="true"/>
            <g:form-field label="性别" type="select" id="gender" name="gender" inline="true">
                <option value="0">女</option>
                <option value="1">男</option>
            </g:form-field>
        </g:grid>
        <div id="stuListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="updateId" title="修改"><i class="glyphicon glyphicon-play-circle"></i> 修改</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="printPDF" title="打印PDF"><i class="glyphicon glyphicon-play-circle"></i> 打印PDF</button>
            <%--<button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="right" id="queryMark" title="查看成绩"><i class="glyphicon glyphicon-play-circle"></i> 查看成绩</button>--%>
        </div>
    </g:box>
</div>
<%--<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>--%>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#stuList', [
        {name: "id", hidden: true},
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
            label: "英文名字",
            name: "engName",
            index: "engName",
            width: '90px',
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
        },
        {
            label: "小学",
            name: "primarySchool",
            index: "primarySchool",
            width: '135px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"初中",
            name:"middleSchool",
            index:"middleSchool",
            width: '135px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"高中",
            name:"highSchool",
            index:"highSchool",
            width: '132px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"家庭地址",
            name:"address",
            index:"address",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"父亲电话",
            name:"fatherPhone",
            index:"fatherPhone",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"母亲电话",
            name:"matherPhone",
            index:"matherPhone",
            width: '100px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"邮件",
            name:"email",
            index:"email",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"是否为正式学员",
            name:"isFormal",
            index:"isFormal",
            width: '150px',
            sortable: false,
            editable: true,
            align: 'center',
            formatter:Formatter.showDesc({0:"是",1:"否"})
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
    function printPDFFun() {
        layer.alert("正在建设中...")
    }
    function queryMarkFun() {
        var row = searcher.getSelectedRows();
        if (row.length == 0) {
            Dialog.alert("请选择一名学生进行操作!");
        }else {
            if (row.length != 1) {
                Dialog.alert("请选择一名学生进行操作!");
            } else {
                var id = row[0].id;
                Dialog.openUrl('['+row[0].name+']同学成绩列表', '${ctx}/stuPath/targetList?id='+id,{
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
        $("#printPDF").click(printPDFFun);
        $("#queryMark").click(queryMarkFun);
    })
</script>
