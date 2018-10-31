<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="g" tagdir="/WEB-INF/tags/g" %>
<%--属性列表--%>
<%@ attribute name="id" type="java.lang.String" required="true" rtexprvalue="true" %>
<%@ attribute name="action" type="java.lang.String" required="true" rtexprvalue="true" %>
<%@ attribute name="pager" type="java.lang.Boolean" required="false" rtexprvalue="true" description="是否需要分页。默认true" %>
<%@ attribute name="search" type="java.lang.Boolean" required="false" rtexprvalue="true"
              description="是否需要搜索条件。默认true" %>
<%@ attribute name="mySubAction" type="java.lang.String" required="false" rtexprvalue="true" %>
<%--默认值设置--%>
<c:set var="pager" value="${not empty pager ? pager : true}"/>
<c:set var="search" value="${not empty search ? search : true}"/>

<%--标签内容--%>
<div class="row">
    <div class="col-sm-12">
        <c:if test="${search}">
            <!-- 查询表单 -->
            <form id="${id}Form" class="form-inline" action="${action}" mySubAction="${mySubAction}" onsubmit="return false;">
                <jsp:doBody/>

                <div class="form-group col-sm-4 text-right p-xs m-t-n" style="display: none;padding-right:0">
                    <a class="collapse-link m-r" href="#"><i class="fa fa-chevron-up"></i> 高级搜索</a>

                    <button type="submit" class="btn btn-sm btn-primary" id="${id}Button"><i class="fa fa-search"></i>
                        搜索
                    </button>
                </div>
            </form>
        </c:if>
        <!-- 操作按钮组 -->
        <div id="${id}_Toolbar" class="col-sm-12" style="padding: 5px 0">
        </div>
    </div>
</div>
<div class="table-responsive">
    <div class="jqGrid_wrapper">
        <table id="${id}"></table>
        <c:if test="${pager}">
            <div id="${id}Pager"></div>
        </c:if>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        // 控制高级查询展开和收缩
        $('.collapse-link').click(function () {
            if (conditionLength <= 2) { // 小于3个条件，需要隐藏高级查询按钮
                $('#${id}Form > div:last a').hide();
                $('#${id}Form div:last').removeClass('col-sm-4 col-sm-8 col-sm-12').addClass('col-sm-' + (3 - conditionLength) * 4);
                return;
            }
            // 隐藏显示搜索条件
            $('#${id}Form div.form-group:gt(1):not(:last)').toggle(1, function () {
                autoWidth('#${id}');
            });
            // 切换向上向下箭头
            var chevron = $('.collapse-link .fa');
            if (chevron.hasClass('fa-chevron-down')) { // 展开
                chevron.removeClass('fa-chevron-down').addClass('fa-chevron-up');
                $('#${id}Form div:last').removeClass('col-sm-4 col-sm-8 col-sm-12').addClass('col-sm-' + (3 - conditionLength % 3) * 4);
            } else { // 收缩
                chevron.removeClass('fa-chevron-up').addClass('fa-chevron-down');
                $('#${id}Form div:last').removeClass('col-sm-4 col-sm-8 col-sm-12').addClass('col-sm-4');
            }
        });

        // 如果没有搜索条件，自动隐藏高级查询
        var conditionLength = $('#${id}Form').children('.form-group').length - 1;
        if (conditionLength > 0) {
            $('#${id}Form div:last').show();
            $('.collapse-link').trigger('click');
        }

        // 添加工具栏
        $('#${id}_Toolbar').prepend($('#${id}Toolbar').children());
        $('#${id}_Toolbar .btn').addClass('m-r-sm');

        // 自适应宽度
        setTimeout(function () {
            autoWidth('#${id}');
        }, 1000);

        $('.chosen-select').chosen({
            placeholder_text_multiple:'',
            single_backstroke_delete:false
        });
        $('.chosen-select').next('.chosen-container').width('100%');

        //下拉选择框多选时  处理选择值又清空后参数传递问题
        $('.chosen-select').chosen().change(function(){
            if( $(this).val() == null){
                $(this).parents("form").append($('<input type="hidden" name='+this.name+' value="">'));
            }
        });
    });

    // 自适应宽度
    function autoWidth(grid) {
        $(grid).setGridWidth($(grid).parents('.jqGrid_wrapper').width() - 1);
        $(grid).closest(".ui-jqgrid-bdiv").css({"overflow-x": "auto"});
    }

    $(function () {
        $(window).resize(function () {
            autoWidth('#${id}');
        });
    });
</script>