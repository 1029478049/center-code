<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<%-- 属性列表 --%>
<%@ attribute name="id"          type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="name"        type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="value"       type="java.lang.String"  required="false" rtexprvalue="true" %>
<%@ attribute name="label"       type="java.lang.String"  required="true"  rtexprvalue="true" %>
<%@ attribute name="type"        type="java.lang.String"  required="true"  rtexprvalue="true" description="表单类型。text|password|select|radio|checkbox|file|dialog|date|dateReport" %>
<%@ attribute name="data"        type="java.lang.String"     required="false" rtexprvalue="true" description="数据。当type=select|radio|checkbox时有效" %>
<%@ attribute name="labelcol"    type="java.lang.Integer" required="false" rtexprvalue="true" description="文本占用列表。默认3" %>
<%@ attribute name="inputcol"    type="java.lang.Integer" required="false" rtexprvalue="true" description="表单占用列数。默认9" %>
<%@ attribute name="inline"      type="java.lang.Boolean" required="false" rtexprvalue="true" description="是否一行中显示。默认false" %>
<%@ attribute name="placeholder" type="java.lang.String"  required="false" rtexprvalue="true" description="默认提示信息" %>
<%@ attribute name="maxlength"   type="java.lang.Integer" required="false" rtexprvalue="true" description="最大输入字符数" %>
<%@ attribute name="className"   type="java.lang.String"  required="false" rtexprvalue="true" description="对应 class" %>
<%@ attribute name="rowcol"      type="java.lang.Integer"  required="false" rtexprvalue="true" description="文本和表单占用列表。默认12" %>
<%@ attribute name="required"    type="java.lang.Boolean"  required="false" rtexprvalue="true" description="lable前边加红色*号" %>
<%-- 设置默认值 --%>
<c:set var="name"     value="${not empty name     ? name     : id   }" />
<c:set var="labelcol" value="${not empty labelcol ? labelcol : 3    }" />
<c:set var="inputcol" value="${not empty inputcol ? inputcol : 9    }" />
<c:set var="inline"   value="${not empty inline   ? inline   : false}" />
<c:set var="rowcol"   value="${not empty rowcol   ? rowcol   : 12}" />
<c:set var="required" value="${not empty required   ? required   : false}" />


<%-- 标签内容 --%>
<div class="form-group m-b-xxs col-xs-${rowcol} ${inline ? ' col-xs-4 p-xxs' : ' '}">
    <label style="padding:0;line-height:40px;white-space: nowrap;text-align: center" class="col-xs-${labelcol} control-label ${inline ? 'p-xxs m-t-n' : ''}" for="${id}">${required?'<a style="color: red"><b>* </b></a>':''}${label}</label>
    <div class="col-xs-${inputcol} input-group ${inline ? 'p-xxs m-t-n m-b-n' : ''}">
        <c:choose>
            <%-- 隐藏框 --%>
            <c:when test="${type == 'hidden'}">
                <input id="${id}" name="${name}" type="hidden"  placeholder="${placeholder}" class="${className} input-sm form-control p-xxs" value="${value}" />
            </c:when>
            <%-- 只读输入框 --%>
            <c:when test="${type == 'onlyRead'}">
                <input id="${id}" name="${name}" type="text" readonly="readonly" style="border: 0px;background-color: #fefffd;" placeholder="${placeholder}" class="${className} input-sm form-control p-xxs" value="${value}" />
            </c:when>
            <%-- 文本框 --%>
            <c:when test="${type == 'text'}">
                <input id="${id}" name="${name}" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control p-xxs" value="${value}" />
            </c:when>
            <%-- 范围文本框 --%>
            <c:when test="${type == 'doubleText'}">
                <input id="${id}Start" name="${name}Start" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control col-xs-5 p-xxs" style="width:41.66%" value="${value}"/>
                <span class="col-xs-2" align="center">至</span>
                <input id="${id}End" name="${name}End" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control col-xs-5 p-xxs" style="width:41.66%" value="${value}"/>
            </c:when>
            <%-- 密码框 --%>
            <c:when test="${type == 'password'}">
                <input id="${id}" name="${name}" type="password" placeholder="${placeholder}" class="${className} input-sm form-control p-xxs" value="${value}" />
            </c:when>
            <%-- 文本域 --%>
            <c:when test="${type == 'textarea'}">
                <textarea id="${id}" name="${name}" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control p-xxs">${value}</textarea>
            </c:when>
            <%-- 下拉选择框 --%>
            <c:when test="${type == 'select'}">
                <select id="${id}" name="${name}" ${fn:contains(className, 'multiple')?'multiple':''} data-placeholder="${not empty placeholder ? placeholder : '请选择...'}" class="${className} input-sm form-control p-xxs chosen-select">
                    <c:if test="${!fn:contains(className, 'not-all') && !fn:contains(className, 'multiple')}">
                        <option value="">全部</option>
                    </c:if>
                    <c:if test="${not empty data}">
                        <c:forEach items="${data}" var="dataItem">
                            <option value="${dataItem.key}" ${dataItem.key == value ? 'selected' : ''}>${not empty dataItem.value ? dataItem.value : dataItem.key}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty data}">
                        <jsp:doBody />
                    </c:if>
                </select>
                <%--<c:if test="${empty data}">--%>
                    <%--<script>$('#${id}').val('');</script>--%>
                <%--</c:if>--%>
            </c:when>
            <%-- 单选框 --%>
            <c:when test="${type == 'radio'}">
                <c:forEach items="${fn:split(data, ',')}" var="dataItem" varStatus="i">
                    <c:set var="dataItems" value="${fn:split(dataItem, ':')}" />
                   <%-- ${fn:split(data, ',')[0]}--%>
                    <div class="${inline ? 'radio-inline' : 'radio'} i-checks">
                        <label><input type="radio"  checked="${i.index == 0 ? "checked" :'' }"  id="${name}${i.index}" name="${name}" class="${className}" value="${dataItems[0]}" ${dataItems[0] == value ? 'selected' : ''} /><i></i> ${dataItems[1]}</label>
                    </div>
                </c:forEach>
            </c:when>
            <%-- 多选框 --%>
            <c:when test="${type == 'checkbox'}">
                <c:forEach items="${data}" var="dataItem" varStatus="i">
                    <div class="${inline ? 'checkbox-inline' : 'checkbox'} i-checks">
                        <label><input type="checkbox" id="${name}${i.index}" name="${name}" class="${className}" value="${dataItem.key}" ${dataItem.key == value ? 'checked' : ''} /><i></i> ${dataItem.value}</label>
                    </div>
                </c:forEach>
            </c:when>
            <%-- 文件框 --%>
            <c:when test="${type == 'file'}">
                <div id="${id}" name="${name}" class="uploadify" style="padding: 8px 0"></div>
                <%--<input id="${id}" name="${name}" readonly="readonly" type="file" class="${className} input-sm form-control p-xxs" />--%>
            </c:when>
            <%-- 弹出框 --%>
            <c:when test="${type == 'dialog'}">
                <input id="${id}" name="${name}" readonly="readonly" type="text" class="${className} input-sm form-control p-xxs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
            </c:when>
            <%-- 时间框 --%>
            <c:when test="${type == 'date'}">
                <input readonly="readonly" id="${id}Start" name="${name}Start" class="${className} input-sm laydate-icon layer-date col-xs-5 p-xxs" style="height:auto" aria-invalid="false">
                <span class="col-xs-2" align="center">至</span>
                <input readonly="readonly" id="${id}End" name="${name}End" class="${className} input-sm laydate-icon layer-date col-xs-5 p-xxs" style="height:auto" aria-invalid="false">
                <script>laydate({elem: "#${id}Start", event: "click"});laydate({elem: "#${id}End", event: "click"});</script>
            </c:when>
            <%-- 报表时间框 --%>
            <c:when test="${type == 'dateReport'}">
                <input readonly="readonly" id="${id}Start" name="${name}Start" class="${className} input-sm laydate-icon layer-date col-xs-5 p-xxs" style="height:auto" aria-invalid="false">
                <span class="col-xs-2" align="center">至</span>
                <input readonly="readonly" id="${id}End" name="${name}End" class="${className} input-sm laydate-icon layer-date col-xs-5 p-xxs" style="height:auto" aria-invalid="false">
            </c:when>
            <%-- 单个时间框 --%>
            <c:when test="${type == 'singleDate'}">
                <input readonly="readonly" id="${id}" name="${name}" value="${value}" class="${className} input-sm laydate-icon  layer-date col-sm-10 p-xxs" style="height:auto" aria-invalid="false">
                <script>laydate({elem: "#${id}", event: "click"})</script>
            </c:when>
            <%-- 金额框 --%>
            <c:when test="${type == 'number'}">
                <input id="${id}Start" name="${name}Start" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control col-xs-5 p-xxs" style="width:41.66%" value="${value}" />
                <span class="col-xs-2" align="center">至</span>
                <input id="${id}End" name="${name}End" type="text"  placeholder="${placeholder}" class="${className} input-sm form-control col-xs-5 p-xxs" style="width:41.66%" value="${value}" />
                <script>
                    $("#${id}Start,#${id}End").keypress(function(event) {
                        var keyCode = event.which;
                        if((!isNaN(this.value) && (keyCode >= 48 && keyCode <=57))//如果存在.只能输入数字
                            || (/^\d+$/.test(this.value) && keyCode == 46 ))//如果没有.可以输.
                            return true;
                        else
                            return false;
                    }).focus(function() {
                        this.style.imeMode='disabled';
                    });
                </script>
            </c:when>
            <%-- 公司选择框 --%>
            <%--<c:when test="${type == 'companyCode'}">
                <input id="${id}"  name="${name}" type="hidden" class="${className} input-sm form-control p-xxs" />
                <input id="${id}name" name="${name}name" type="text" readonly="readonly" class="${className} input-sm form-control p-xxs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
                <script>
                    function clickCompanyTree(node) {
                        $("#${id}").val(node.text.split("_")[0]);
                        $("#${id}name").val(node.text.split("_")[1]);
                    }

                    $("#${id}Button").click(function () {
                        // 是否限制选择，如果限制，设置为disabled
                        if ($("#${id}Button").hasClass("disabled")) {
                            return true;
                        }
                        Dialog.openUrl("选择公司","${ctx}${masterdataPath}/company",{ area : ['400px','563px']});
                    });

                    $("#${id}ButtonCancel").click(function(){
                        $("#${id}").val("");
                        $("#${id}name").val("");
                    });
                </script>
            </c:when>--%>

            <%-- 公司选择框 --%>
            <%--<c:when test="${type == 'company'}">
                <input id="${id}"  name="${name}" type="text" class="${className} input-sm form-control p-xxs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
                <script>
                    function clickCompanyTree(node) {
                        $("#${id}").val(node.text.split("_")[1]);
                    }

                    $("#${id}Button").click(function () {
                        // 是否限制选择，如果限制，设置为disabled
                        if ($("#${id}Button").hasClass("disabled")) {
                            return true;
                        }
                        Dialog.openUrl("选择公司","${ctx}${masterdataPath}/company",{ area : ['400px','563px']});
                    });

                    $("#${id}ButtonCancel").click(function(){
                        $("#${id}").val("");
                    });
                </script>
            </c:when>--%>
            <%-- 供应商选择框 --%>
            <%--<c:when test="${type == 'vendor'}">
                <input id="${id}" name="${name}" type="text" class="${className} input-sm form-control p-xs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
                <script>
                    function clickVendorTree(node) {
                        $("#${id}").val(node.text.split("_")[1]);
                    }

                    $("#${id}Button").click(function () {
                        // 是否限制选择，如果限制，设置为disabled
                        if ($("#${id}Button").hasClass("disabled")) {
                            return true;
                        }
                        Dialog.openUrl("选择供应商","${ctx}${masterdataPath}/vendor",{ area : ['400px','563px']});
                    });

                    $("#${id}ButtonCancel").click(function(){
                        $("#${id}").val("");
                    });
                </script>
            </c:when>--%>

            <%-- 供应商选择框 --%>
            <%--<c:when test="${type == 'vendorCode'}">
                <input id="${id}" name="${name}" type="hidden" class="${className} input-sm form-control p-xs" />
                <input id="${id}Name" name="${name}Name" type="text" class="${className} input-sm form-control p-xs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
                <script>
                    function clickVendorTree(node) {
                        $("#${id}").val(node.vcOrgCode);
                        $("#${id}Name").val(node.vcOrgNameZh);
                    }

                    $("#${id}Button").click(function () {
                        // 是否限制选择，如果限制，设置为disabled
                        if ($("#${id}Button").hasClass("disabled")) {
                            return true;
                        }
                        Dialog.openUrl("选择供应商","${ctx}${masterdataPath}/vendor",{ area : ['400px','563px']});
                    });

                    $("#${id}ButtonCancel").click(function(){
                        $("#${id}").val("");
                        $("#${id}Name").val("");
                    });
                </script>
            </c:when>--%>

            <%-- 快递公司选择框 --%>
            <%--<c:when test="${type == 'expCompany'}">
                <input id="${id}Code" name="${name}Code" type="hidden" class="${className} input-sm form-control p-xxs" />
                <input id="${id}Id" name="${name}Id" type="hidden" class="${className} input-sm form-control p-xxs" />
                <input id="${id}Name" name="${name}Name" readonly="readonly" type="text" class="${className} input-sm form-control p-xxs" />
                <span class="input-group-btn" style="width: 25px;">
                    <button type="button" id="${id}Button" class="${className} btn btn-sm btn-primary" style="margin-bottom: 0"><i class="fa fa-search" style="line-height:18px;"></i></button>
                </span>
                <script>
                    function clickExpTypeTree(node) {
                        $("#${id}Code").val(node.expCode);
                        $("#${id}Name").val(node.expName);
                        $("#${id}Id").val(node.id);
                    }

                    $("#${id}Button").click(function () {
                        // 是否限制选择，如果限制，设置为disabled
                        if ($("#expTypeName").hasClass("disabled")) {
                            return true;
                        }
                        Dialog.openUrl("选择快递公司","${ctx}${masterdataPath}/expCompany",{ area : ['400px','563px']});
                    });

                    $("#${id}ButtonCancel").click(function(){
                        $("#${id}Code").val("");
                        $("#${id}Name").val("");
                        $("#${id}Id").val("");
                    });
                </script>
            </c:when>--%>

            <%-- 根据当前登陆名获得所属app应用 --%>
            <%--<c:when test="${type == 'app'}">
                <select id="${id}" name="${name}" placeholder="${placeholder}" class="${className} input-sm form-control p-xxs">
                    <option value="">请选择</option>
                </select>
                <script>
                    Page.ajaxPOST('${ctx}${authorityPath}/app/loadAppByLoginName',{},function(data){
                        for(var i = 0; i < data.result.length; i++){
                            $('#${id}').append('<option value="'+ data.result[i].id+'">'+ data.result[i].appName+'</option>');
                        }
                    });
                </script>
            </c:when>--%>
            <%--查询所有所属app应用--%>
            <%--<c:when test="${type == 'allApp'}">
                <select id="${id}" name="${name}" placeholder="${placeholder}" class="${className} input-sm form-control p-xxs">
                    <option value="">请选择</option>
                </select>
                <script>
                    Page.ajaxPOST('${ctx}${authorityPath}/app/findAll',{},function(data){
                        for(var i = 0; i < data.result.length; i++){
                            $('#${id}').append('<option value="'+ data.result[i].id+'">'+ data.result[i].appName+'</option>');
                        }
                    });
                </script>
            </c:when>--%>
        </c:choose>
    </div>
</div>