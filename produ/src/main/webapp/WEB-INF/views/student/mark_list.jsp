<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jspf"%>
<%@include file="../common/resources-js.jsp" %>
<%@include file="../common/resources-css.jsp" %>
<div class="wrapper-content animated fadeInRight">
    <g:box id="l" title="学生管理" cssStyle="padding:0">
        <g:grid id="stuList" action="${ctx}/stuMarkPath/queryMark?stuId=${stuId}">
            <%--<g:form-field label="" type="hidden" id="stuId" value = "${stuId}" name="stuId"/>--%>
            <g:form-field label="考试排名" placeholder="考试排名" type="text" id="examRank" name="examRank" inline="true"/>
            <g:form-field label="考试类别" type="select" id="examType" name="examType" inline="true">
                <option value="0">周考</option>
                <option value="1">月考</option>
                <option value="2">期中考试</option>
                <option value="3">期末考试</option>
                <option value="4">中考</option>
                <option value="5">高考</option>
            </g:form-field>
        </g:grid>
        <%--<div id="stuListToolbar">
            <button type="button" class="btn btn-warning btn-sm" data-toggle="tooltip" data-placement="left" id="addId" title="增加"><i class="glyphicon glyphicon-th-list"></i> 增加</button>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="left" id="deletedId" title="删除"><i class="glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" data-placement="left" id="updateId" title="修改"><i class="glyphicon glyphicon-play-circle"></i> 修改</button>
            <button type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" id="refresh" title="刷新表单"><i class="glyphicon glyphicon-play-circle"></i> 刷新表单</button>
        </div>--%>
    </g:box>
</div>
<%--<script src="../../../../js/plugins/metisMenu/jquery.metisMenu.js"></script>--%>
<script type="text/javascript">
    // 创建操作器，可以完成各种基本操作
    var searcher = Searcher.create('#stuList', [
        {name: "id", hidden: true},{
            label:"考试时间",
            name:"examTime",
            index:"examTime",
            width: '130px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"考试类别",
            name:"examType",
            index:"examType",
            width: '110px',
            sortable: false,
            editable: true,
            align: 'center',
            formatter:Formatter.showDesc({0:"周考",1:"月考",2:"期中考试",3:"期末考试",4:"中考",5:"高考"})
        },{
            label:"考试排名",
            name:"examRank",
            index:"examRank",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "语文成绩",
            name: "chinese",
            index: "chinese",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "数学成绩",
            name: "math",
            index: "math",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "英语成绩",
            name: "english",
            index: "english",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "物理成绩",
            name: "physics",
            index: "physics",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label: "化学成绩",
            name: "chemistry",
            index: "chemistry",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },
        {
            label:"生物成绩",
            name:"biology",
            index:"biology",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"体育成绩",
            name:"sports",
            index:"sports",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"政治成绩",
            name:"politics",
            index:"politics",
            width: '80px',
            sortable: false,
            editable: true,
            align: 'center'
        },{
            label:"地理成绩",
            name:"geography",
            index:"geography",
            width: '80px',
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
    $(function () {
        $("#addId").click(addFun);
        $("#updateId").click(updateFun);
        $("#deletedId").click(deletedFun);
        $("#refresh").click(refreshFun);
    })
</script>
