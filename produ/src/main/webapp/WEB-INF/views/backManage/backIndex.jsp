<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H 后台管理</title>

    <link rel="shortcut icon" href="../../../favicon.ico"> <link href="../../../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../../../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="../../../css/animate.min.css" rel="stylesheet">
    <link href="../../../css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg top-navigation">
<div id="wrapper">
    <div id="page-wrapper" class="gray-bg page-header">
    <div class="row border-bottom white-bg page-header-menu">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <i class="fa fa-reorder"></i>
                    </button>
                    <a href="#" class="navbar-brand">环时教育</a>
                </div>
                <div class="navbar-collapse collapse hor-menu" id="navbar" style="min-width: 1024px;">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="active">
                            <a aria-expanded="false" role="button" href="/paltform"> 返回首页</a>
                        </li>
                        <li class="menu-dropdown mega-menu-dropdown  mega-menu-full">
                            <a  href="#" aria-expanded="false" role="button" class="dropdown-toggle" data-toggle="dropdown"> 系统设置 <span class="caret"></span></a>
                            <ul  class="dropdown-menu">
                                    <li><a class="J_menuItem" href="${ctx}/backManage/userPage" data-index="1">用户管理</a>
                                    </li>
                                    <li><a class="J_menuItem" href="${ctx}/rolePath/list">角色管理</a>
                                    </li>
                                    <li><a class="J_menuItem" href="${ctx}/permissionPath/list">资源管理</a>
                                    </li>
                                    <li><a class="J_menuItem" href="${ctx}/codeLogs/list">代码修改说明</a>
                                    </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 功能菜单 <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a class="J_menuItem" href="${ctx}/backManage/qrCode/list">二维码管理</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">M菜单列表</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 菜单 <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 菜单 <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a class="J_menuItem" href="#">菜单列表</a>
                                </li>
                                <li><a href="#">菜单列表</a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <a href="/logout">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
    </div>
        <%--<div class="wrapper wrapper-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-success pull-right">月</span>
                                <h5>浏览量</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">386,200</h1>
                                <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i>
                                </div>
                                <small>总计浏览量</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-info pull-right">年</span>
                                <h5>订单</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">80,800</h1>
                                <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                                </div>
                                <small>新订单</small>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-primary pull-right">今天</span>
                                <h5>访问人次</h5>
                            </div>
                            <div class="ibox-content">

                                <div class="row">
                                    <div class="col-md-6">
                                        <h1 class="no-margins">&yen; 406,420</h1>
                                        <div class="font-bold text-navy">44% <i class="fa fa-level-up"></i> <small>增长较快</small>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <h1 class="no-margins">206,120</h1>
                                        <div class="font-bold text-navy">22% <i class="fa fa-level-up"></i> <small>增长较慢</small>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>月收入</h5>
                                <div class="ibox-tools">
                                    <span class="label label-primary">2015.02 更新</span>
                                </div>
                            </div>
                            <div class="ibox-content no-padding">
                                <div class="flot-chart m-t-lg" style="height: 55px;">
                                    <div class="flot-chart-content" id="flot-chart1"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <div>
                                        <span class="pull-right text-right">
                                        <small>在过去的一个月销售的平均值：<strong>山东</strong></small>
                                            <br/>
                                            所有销售： 162,862
                                        </span>
                                    <h3 class="font-bold no-margins">
                                        半年收入利润率
                                    </h3>
                                    <small>市场部</small>
                                </div>

                                <div class="m-t-sm">

                                    <div class="row">
                                        <div class="col-md-8">
                                            <div>
                                                <canvas id="lineChart" height="114"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <ul class="stat-list m-t-lg">
                                                <li>
                                                    <h2 class="no-margins">2,346</h2>
                                                    <small>总订单</small>
                                                    <div class="progress progress-mini">
                                                        <div class="progress-bar" style="width: 48%;"></div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <h2 class="no-margins ">4,422</h2>
                                                    <small>最近一个月订单</small>
                                                    <div class="progress progress-mini">
                                                        <div class="progress-bar" style="width: 60%;"></div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                </div>

                                <div class="m-t-md">
                                    <small class="pull-right">
                                        <i class="fa fa-clock-o"> </i>
                                        2015.02.30更新
                                    </small>
                                    <small>
                                        <strong>说明：</strong> 本期销售额比上期增长了23%。
                                    </small>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>用户行为统计</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">访问页面 / 浏览量</small>
                                        <h4>236 321.80</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% 新访客</small>
                                        <h4>46.11%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">最后一周</small>
                                        <h4>432.021</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">访问页面 / 浏览量</small>
                                        <h4>643 321.10</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% 新访客</small>
                                        <h4>92.43%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">最后一周</small>
                                        <h4>564.554</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">访问页面 / 浏览量</small>
                                        <h4>436 547.20</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% 新访客</small>
                                        <h4>150.23%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">最后一周</small>
                                        <h4>124.990</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                &lt;%&ndash;<div class="row">

                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>自定义响应表格</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="#">设置选项1</a>
                                        </li>
                                        <li><a href="#">设置选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-sm-9 m-b-xs">
                                        <div data-toggle="buttons" class="btn-group">
                                            <label class="btn btn-sm btn-white">
                                                <input type="radio" id="option1" name="options">天</label>
                                            <label class="btn btn-sm btn-white active">
                                                <input type="radio" id="option2" name="options">周</label>
                                            <label class="btn btn-sm btn-white">
                                                <input type="radio" id="option3" name="options">月</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="input-group">
                                            <input type="text" placeholder="搜索" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary">搜索</button> </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>项目</th>
                                            <th>进度</th>
                                            <th>任务</th>
                                            <th>日期</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>米莫说｜MiMO Show</td>
                                            <td><span class="pie">0.52/1.561</span>
                                            </td>
                                            <td>20%</td>
                                            <td>2014.11.11</td>
                                            <td><a href="../../../table_basic.html#"><i class="fa fa-check text-navy"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>商家与购物用户的交互试衣应用</td>
                                            <td><span class="pie">6,9</span>
                                            </td>
                                            <td>40%</td>
                                            <td>2014.11.11</td>
                                            <td><a href="../../../table_basic.html#"><i class="fa fa-check text-navy"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>天狼---智能硬件项目</td>
                                            <td><span class="pie">3,1</span>
                                            </td>
                                            <td>75%</td>
                                            <td>2014.11.11</td>
                                            <td><a href="../../../table_basic.html#"><i class="fa fa-check text-navy"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>线下超市+线上商城+物流配送互联系统</td>
                                            <td><span class="pie">4,9</span>
                                            </td>
                                            <td>18%</td>
                                            <td>2014.11.11</td>
                                            <td><a href="../../../table_basic.html#"><i class="fa fa-check text-navy"></i></a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>&ndash;%&gt;

            </div>
        </div>--%>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <%--<a href="/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>--%>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}/backManage/welcome" frameborder="0"  seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">
                By：<a href="http://www.huanshijiaoyu.com" target="_blank">环时教育</a>
            </div>
            <div>
                <strong>环时教育</strong> H &copy; 2017
            </div>
        </div>
    </div>
</div>
<script src="../../../js/jquery.min.js?v=2.1.4"></script>
<script src="../../../js/bootstrap.min.js?v=3.3.6"></script>
<script src="../../../js/content.min.js?v=1.0.0"></script>
<script src="../../../js/plugins/flot/jquery.flot.js"></script>
<script src="../../../js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="../../../js/plugins/flot/jquery.flot.resize.js"></script>
<script src="../../../js/plugins/chartJs/Chart.min.js"></script>
<script src="../../../js/plugins/peity/jquery.peity.min.js"></script>
<script src="../../../js/demo/peity-demo.min.js"></script>
<script type="text/javascript">
    $(function(){
        windowResize();
        // 绑定菜单点击事件
        $('.J_menuItem').click(function () {
            var dd = $(this).parents('.dropdown');
            dd.find('a[aria-expanded=true]').attr('aria-expanded', false);
            dd.removeClass('open');
        });
        // 绑定窗口变化事件
        $(window).resize(windowResize);
        // 绑定点击iframe时，关隐藏关闭选项的弹出层
        $(window).blur(function () {
            top.$('.content-tabs .J_tabClose').parent().removeClass('open');
            top.$('.navbar .dropdown').removeClass('open');
        });
    });

    function windowResize() {
        var width = $(window).width(), height = $(window).height();
        $('#content-main').width(width).height(Math.max(height, 768) - 239);
    }
</script>
</body>
</html>
