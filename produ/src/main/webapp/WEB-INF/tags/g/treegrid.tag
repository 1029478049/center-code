<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--属性列表--%>
<%@ attribute name="id"      type="java.lang.String"  required="true"  rtexprvalue="true" %>
<%@ attribute name="action"  type="java.lang.String"  required="true"  rtexprvalue="true" %>

<%--标签内容--%>
<div class="row">
    <div class="col-sm-12">
        <!-- 查询表单 -->
        <form id="${id}Form" class="form-inline" action="${action}" onsubmit="return false;">
            <jsp:doBody />

            <div class="form-group col-sm-4 text-right p-xs m-t-n" style="display: none;padding-right:0">
                <a class="collapse-link m-r" href="#"><i class="fa fa-chevron-up"></i> 高级搜索</a>
                <button type="submit" class="btn btn-sm btn-primary"> <i class="fa fa-search"></i> 搜索</button>
            </div>
        </form>

        <!-- 操作按钮组 -->
        <div id="${id}_Toolbar" class="col-sm-12" style="padding: 5px 0">
        </div>
    </div>
</div>
<div class="table-responsive">
    <div class="jqGrid_wrapper" id="${id}_TreeTable">
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        // 控制高级查询展开和收缩
        $('.collapse-link').click(function () {
            if(conditionLength <= 2){ // 小于3个条件，需要隐藏高级查询按钮
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
        var conditionLength = $('#${id}Form').children().length - 1;
        if(conditionLength > 0){
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

        //
        $('#${id}TreeTable').appendTo($('#${id}_TreeTable'));
    });

    // 自适应宽度
    function autoWidth(grid) {
        $(grid).setGridWidth($(grid).parents('.jqGrid_wrapper').width() - 1);
    }

    $(function () {
        $(window).resize(function () {
            autoWidth('#${id}');
        });
    });
</script>