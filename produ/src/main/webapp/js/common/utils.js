console.log("进入JS util工具类");
// 设置jqgrid的样式
/*$.jgrid.defaults.styleUI = "Bootstrap";*/
/*$(document).ready(function () {
    $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green"})
});*/
var Util = {
    Alert:function (value) {
        $("#"+value).click(function () {
            layer.alert("111111")
        })
    }

};
// upload设置
$.fn.iUploadify = function (options) {
    if (typeof(options) === 'object') {
        var uploadOptions = $.extend({
            auto: false,
            multi: false,
            buttonText: '选择文件...',
            itemTemplate: '<div id="${fileID}" class="uploadify-queue-item"><span class="up_filename">${fileName}</span><i style="margin:0;border:0;color:red" class="delfilebtn fa fa-close"></i></div>',
            onUploadSuccess: function (file, data_, response) {
                var data = JSON.parse(data_);
                if (data.success) {
                    if (options.uploadSuccess) {
                        options.uploadSuccess(data);
                    } else {
                        Dialog.msg(data.successMessage);
                        Dialog.closeCurrentFrame();
                    }
                } else {
                    if (options.uploadFail) {
                        options.uploadFail(data);
                    } else {
                        Dialog.alert(data.errorMessages ? data.errorMessages.join('<br/>') : '操作失败！');
                    }
                }
            },
            onUploadStart: function () {
                $(document).trigger('ajaxStart');
            },
            onUploadComplete: function () {
                $(document).trigger('ajaxStop');
            },
            onUploadError: function () {
                $(document).trigger('ajaxStop');
            }
        }, options);

        // 初始化上传控件
        $(this).Huploadify(uploadOptions);
    }
};

// 全局ajax进度条控制
var __index__ = -1;
$(document).ajaxStart(function () {
    try {
        __index__ = layer.load(3, {
            shade: [0.7, '#fff'], time: 0
        });
    } catch (e) {
    }
}).ajaxStop(function () {
    try {
        if (__index__ !== -1) layer.close(__index__);
    } catch (e) {
    }
});

/**
 * 弹出框
 * @type {{open: Dialog.open, openByUrl: Dialog.openByUrl, openUrl: Dialog.openUrl, alert: Dialog.alert, confirm: Dialog.confirm, msg: Dialog.msg}}
 */
var Dialog = {
    lastIndex: -1,
    /**
     * 打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param content 必须。窗口内容。任意的文本或html或dom元素
     * @param options 可选。其他layer参数
     */
    open: function (title, content, options) {
        options = $.extend({
            type: 1,
            shadeClose: false,
            title: title,
            content: content,
            end: typeof(options) === 'function' ? options : null
        }, options);

        var idx = layer.open(options);
        if (options.full === true) {
            layer.full(idx);
        }
        Dialog.lastIndex = idx;
        return idx;
    },
    /**
     * 根据URL打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param url 必须。URL，需返回HTML片段，而不是完整的HTML内容
     * @param options 可选。其他layer参数
     */
    openByUrl: function (title, url, options) {
        $.post(url, {}, function (data) {
            Dialog.lastIndex = Dialog.open(title, data, options);
        }, 'html');
    },
    /**
     * 打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param url 必须。URL，需返回HTML内容，如果返回的是HTML片段，请使用openByUrl方法
     * @param options 可选。其他layer参数
     */
    openUrl: function (title, url, options) {
        options = $.extend({
            type: 2,
            shadeClose: false,
            title: title,
            content: url,
            area: ['500px', '300px'],
            end: typeof(options) === 'function' ? options : null
        }, options);

        var idx = layer.open(options);
        if (options.full === true) {
            layer.full(idx);
        }
        Dialog.lastIndex = idx;
        return idx;
    },
    /**
     * 警告框
     * @param message 必须。提示信息
     * @param okFn 可选。点击确定的回调函数
     * @param options 可选。其他layer参数
     */
    alert: function (message, okFn, options) {
        options = $.extend({
            icon: 2,
            title: '系统提示'
        }, options);

        var idx = layer.alert(message, options, function (index) {
            if (okFn) {
                okFn();
            }
            layer.close(index);
        });
        Dialog.lastIndex = idx;
        return idx;
    },
    /**
     * 信息框
     * @param message 必须。提示信息
     * @param okFn 可选。点击确定的回调函数
     * @param options 可选。其他layer参数
     */
    info: function (message, okFn, options) {
        options = $.extend({
            icon: 1
        }, options);
        this.alert(message, okFn, options);
    },
    /**
     * 操作确认框
     * @param message 必须。提示信息
     * @param okFn 可选。点击确定的回调函数
     * @param options 可选。其他layer参数
     */
    confirm: function (message, okFn, options) {
        options = $.extend({
            icon: 3,
            title: '操作提示'
        }, options);

        var idx = layer.confirm(message, options, function (index) {
            if (okFn) {
                okFn();
            }
            layer.close(index);
        });
        Dialog.lastIndex = idx;
        return idx;
    },
    /**
     * 提示操作框
     * @param title 必须。提示信息
     * @param content 必须。操作内容
     * @param okFn 可选。确定的的回调函数
     * @param options 可选。其他layer参数
     */
    prompt: function (title, content, okFn, options) {
        options = $.extend({
            title: title,
            area: '400px',
            autoClose: true
        }, options);

        var idx = layer.confirm(content, options, function (index) {
            if (okFn) {
                okFn();
            }
            if (options.autoClose) {
                layer.close(index);
            }
        });
        Dialog.lastIndex = idx;
        return idx;
    },
    /**
     * 提示框
     * @param message 必须。提示信息
     * @param endFn 可选。关闭的的回调函数
     * @param options 可选。其他layer参数
     */
    msg: function (message, endFn, options) {
        options = $.extend({
            // icon: 1,
            anim: 1,
            time: 2000
        }, options);

        return layer.msg(message, options, function () {
            if (endFn) {
                endFn();
            }
        });
    },
    /**
     * 关闭Frame
     * @param frameName window的name
     */
    closeFrame: function (frameName) {
        var index = parent.layer.getFrameIndex(frameName); //获取窗口索引
        parent.layer.close(index);
    },
    /**
     * 关闭Frame
     * @param frameName window的name
     */
    closeCurrentFrame: function () {
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
    },
    /**
     * 设置dialog 宽度
     * @param offset 偏移量
     */
    width: function (fixHeight) {
        if (isNaN(fixHeight)) {
            fixHeight = 0;
        }

        return $(window).width() / 3 - fixHeight;
    },

    /**
     * 设置dialog 高度
     * @param offset
     * @returns {*}
     */
    height: function (fixHeight) {
        if (isNaN(fixHeight)) {
            fixHeight = 0;
        }
        return $(window).height() / 2 + fixHeight;
    }
};

var Page = {
    /**
     * 表单提交初始化方式
     * @param form 表单
     * @param options jqueryValidate参数, submitSuccess: 提交成功回调函数,submitFail：提交失败回调函数
     */
    validateForm: function (form, options) {
        form = $(form);

        // 初始化上传控件
        var fileInput;
        form.find('.uploadify').each(function (i, item) {
            $(this).iUploadify({
                uploader: form.attr('action'),
                fileTypeExts: form.attr('accepts') || '',
                uploadSuccess: options.submitSuccess,
                uploadFail: options.submitFail,
                formData: function () {
                    return form.serializeObject()
                }
            });
            fileInput = this;
        });

        options = $.extend({
            highlight: function (element) {
                if ($(element).closest("table").length > 0) {
                    var $this = $(element).closest("td");
                    /* $this.prev().removeClass("has-success").addClass("has-error");
                     $this.removeClass("has-success").addClass("has-error");*/
                } else {
                    /*$(element).closest(".form-group").removeClass("has-success").addClass("has-error");*/
                }
            },
            success: function (element, r) {
                layer.close($(element).attr("tipsIndex"));
                if ($(element).closest("table").length > 0) {
                    var $this = $(element).closest("td");
                    $this.removeClass("has-error").addClass("has-success");
                    $this.prev().removeClass("has-error").addClass("has-success");
                } else {
                    $(r).closest(".form-group").removeClass("has-error").addClass("has-success");
                }
            },
            errorElement: "span",
            errorPlacement: function (e, r) {
                if (r.is(':hidden') && e[0].innerText !== '') {
                    Dialog.alert(e.text(), null, {zIndex: 20000000});
                    return false;
                }
                layer.close($(r).attr("tipsIndex"));
                //console.log(e[0].innerText);
                if (e[0].innerText !== '') {
                    $(r).attr("tipsIndex", layer.tips(e.text() + "(" + r.parent().prev().text() + ")", r, {
                        tips: [3, '#ffcc99'],
                        tipsMore: true,
                        time: 0
                    }));
                } else {
                    layer.close($(r).attr("tipsIndex"));
                }
            },
            errorClass: "help-block m-b-none",
            validClass: "m-b-none",
            beforeSubmit: null, // 提交前处理
            // 默认提交方式
            submitHandler: function (_form) {
                if (form.valid()) {
                    var submitFn = function () {
                        if (fileInput) {
                            $(fileInput).trigger('upload');
                            return false;
                        } else {
                            var data = undefined;
                            if (options.beforeSubmit) {
                                data = form.serializeJson();
                                options.beforeSubmit(_form, data);
                            } else {
                                data = form.serialize();
                            }

                            if ("json" == options.submitType) {
                                Page.ajaxPOST(form.attr('action'), JSON.stringify(data), options.submitSuccess, options.submitFail, {
                                    dataType: "json",
                                    contentType: "application/json"
                                });
                            } else {
                                Page.ajaxPOST(form.attr('action'), data, options.submitSuccess, options.submitFail);
                            }

                        }
                    };
                    if (options.tips) { // 有提示信息
                        Dialog.confirm(options.tips, function () {
                            submitFn();
                        });
                    } else {
                        submitFn();
                    }
                }
            },
            // 提交成功
            submitSuccess: function (data) {
                Dialog.msg(data.successMessage);
            },
            // 提交失败
            submitFail: function (data) {
                Dialog.alert(data.errorMessages ? data.errorMessages.join('<br/>') : '操作失败！');
            },
            submitType: 'form'
        }, options);

        return form.validate(options);
    },
    /**
     * ajax请求
     * @param method 请求方法  GET / POST
     * @param url 请求URL
     * @param data 请求参数
     * @param successFn 成功回调函数
     * @param failFn 失败回调函数
     * @param options 重载属性
     */
    ajax: function (method, url, data, successFn, failFn, options) {
        if (typeof (successFn) === 'object') {
            options = successFn;
            successFn = false;
        }
        if (typeof (failFn) === 'object') {
            options = failFn;
            failFn = false;
        }

        options = $.extend({
            url: url,
            type: method,
            data: data,
            success: function (data) {
                if (data.success) {
                    if (successFn) {
                        successFn(data);
                    } else {
                        Dialog.msg(data.successMessage); // 默认
                    }
                } else {
                    if (failFn) {
                        failFn(data);
                    } else {
                        Dialog.alert(data.errorMessages ? data.errorMessages.join('<br/>') : '操作失败！'); // 默认
                    }
                }
            },
            error: function (r) {
                Dialog.alert('服务器忙，请您稍后再试！');
            }
        }, options);

        $.ajax(options);
    },
    /**
     * 加载表单数据
     * @param form
     * @param data
     */
    loadForm: function (form, data) {
        var _from = $(form);
        for (var name in data) {
            var element = _from.find('[name="' + name + '"]');
            element.val(data[name]);
        }
    },
    /**
     * ajax  GET 请求
     * @param url
     * @param data
     * @param successFn
     * @param failFn
     */
    ajaxGET: function (url, data, successFn, failFn, options) {
        this.ajax('GET', url, data, successFn, failFn, options);
    },
    /**
     * ajax  POST 请求
     * @param url
     * @param data
     * @param successFn
     * @param failFn
     */
    ajaxPOST: function (url, data, successFn, failFn, options) {
        this.ajax('POST', url, data, successFn, failFn, options);
    },

    /**
     * 下拉列表
     * data: {
     *    idField: , nameField:
     * }
     */
    selector: function (selectorId, options) {

        if (typeof(options) == 'string') {
            options = {url: options};
        }

        options = $.extend({
            url: '',
            data: {},
            valueField: 'id',
            textField: 'name'
        }, options);

        options.data.pageSize = -1;

        var selector = $(selectorId);
        var selectedValue = selector.attr('selectedValue');
        var valueField = options.valueField;
        var textField = options.textField;

        this.ajaxPOST(options.url, options.data, function (data) {
            var list = data.result, optionStr = "";
            for (var i in list) {
                var jsonObj = list[i];
                if (selectedValue == jsonObj[valueField]) {
                    optionStr += "<option value=\"" + jsonObj[valueField] + "\" selected='selected'>" + jsonObj[textField] + "</option>";
                } else {
                    optionStr += "<option value=\"" + jsonObj[valueField] + "\" >" + jsonObj[textField] + "</option>";
                }
            }
            selector.html(optionStr);
        });
    }
};

var JSTree = {
    loading: function (jsTree, url, callback, options) {

        options = $.extend({
            multiple: false
        }, options);

        var jsTreeObj = $(jsTree);
        //清空树
        jsTreeObj.data('jstree', false).empty();

        //重新加载
        jsTreeObj.jstree({
            plugins: ["wholerow", "json_data"],
            core: {
                data: {
                    dataType: "json",
                    url: function (node) {
                        var _url = url.replace(/\{nodeId\}/g, (node && node.id == '#' ? '0' : node.id));

                        return _url + '&' + $('.tree-param').serialize();
                    }
                },
                multiple: options.multiple
            }
        }).on("dblclick.jstree", function () {
            var tree = $.jstree.reference(jsTree);
            var node = tree.get_selected(true);
            if (callback) {
                callback(tree, node);
            }
        });
    }
};

/**
 * 查询类
 */
var Searcher = {
    /**
     * 创建查询器（根据规范来限制表单元素）
     * <pre>
     *   查询表单ID：jqGrid + 'Form'
     *   查询按钮ID：jqGrid + 'Button'
     *   分页条ID： jqGrid + 'Pager'
     * </pre>
     * @param jqGrid 必须。jqGrid对象
     * @param colModel 必须。展示的列表定义
     * @param options 可选。其他jqGrid参数, 如果为false，则不主动加载数据
     * @returns {{options, query: searcher.query, getSelectedRows: searcher.getSelectedRows}}
     */

    create: function (jqGrid, colModel, options) {
        var jqGridObject = $(jqGrid);
        var jqGridId = jqGridObject.attr('id');
        var searchForm = $('#' + jqGridId + 'Form');
        var searchButton = searchForm.find(':submit');
        var searchUrl = searchForm.attr('action');
        var mySubGridUrl = searchForm.attr('mySubAction');
        var rawData = null;
        var jqGridOptions = $.extend({
            url: searchUrl,
            mtype: 'POST',
            datatype: "json",
            height: '265px',
            autowidth: true,
            shrinkToFit: true,
            autoScroll: true,
            styleUI:'Bootstrap',
            rownumbers: true,//展现行号
            rowNum: 10,
            rowList: [10, 50, 100, 200, 300, 500, 800, 1000],
            colModel: colModel,
            pager: "#" + jqGridId + "Pager",
            viewrecords: true,
            caption: jqGridObject.attr('title'),
            multiselect: true, // 复选框
            hidegrid: false,
            postData: searchForm.serializeObject(),
            subGrid: false,//子表格
            subGridOptions: {"reloadOnExpand": false},
            subGridRowExpanded: function (subgrid_id, row_id) {
                var subgrid_table_id = subgrid_id + "_t";
                $("#" + subgrid_id).html(" <div class='jqGrid_wrapper'><table id='" + subgrid_table_id + "'class='scroll'></table></div>");
                $("#" + subgrid_table_id).jqGrid({
                    url: mySubGridUrl + "?pId=" + row_id,
                    mtype: 'POST',
                    datatype: "json",
                    height: 'auto',
                    autowidth: true,
                    shrinkToFit: true,
                    autoScroll: true,
                    rownumbers: true,//展现行号
                    colModel: options.mySubGridModel,
                    rowNum: -1,
                    viewrecords: true,
                    hidegrid: false,
                    subGrid: false,//子表格
                    beforeProcessing: function (data) {
                        if (data.success) {
                            rawData = data;
                            if (data.result.rows == undefined) {
                                data.rows = data.result;
                            } else {
                                for (var k in data.result) {
                                    data[k] = data.result[k];
                                }
                            }
                            return true;
                        } else {
                            if (data.result == undefined) {
                                data.rows = [];
                            }
                            return true;
                        }
                    }
                });
            },
            loadError: function () {
                Dialog.alert('数据加载失败！');
            },
            serializeGridData: function (data) {
                return $.param(data, true);
            },
            onSelectRow: function (rowid, status) {

            }, beforeSelectRow: function (rowid, e) {

            }, onSelectAll: function (aRowids, status) {

            },
            beforeProcessing: function (data) {
                if (data.success) {
                    rawData = data;
                    if (data.result.rows == undefined) {
                        data.rows = data.result;
                    } else {
                        for (var k in data.result) {
                            data[k] = data.result[k];
                        }
                    }
                    return true;
                } else {
                    if (data.result == undefined) {
                        data.rows = [];
                    }
                    return true;
                }
            },
            footerConfig: null
        }, options);

        if ($(jqGridOptions.pager).length === 0) {
            jqGridOptions.rowNum = -1;
        }


        // ------------------- 自定义参数设置 开始---------------------
        // 是否主动加载数据
        if (options === false || jqGridOptions.firstLoad === false) { // 不主动加载数据
            jqGridOptions.datatype = 'local';
        }
        // 设置Footer，例如：footerConfig: {'saleCompanyName': '已选中 [{R.count}] 条','invAmount': 'sum()', 'invTax': 'sum()', 'invTotalAmount': 'sum()'}
        /*if (jqGridOptions.footerConfig && typeof (jqGridOptions.footerConfig) === 'object') {
            jqGridOptions.footerrow = true;
            jqGridOptions.refreshFooter = function () {
                // 处理结果
                var R = {
                    /!** 总数 *!/
                    count: 0,
                    /!** 选中的ID *!/
                    selectedIds: jqGridObject.jqGrid("getGridParam", "selarrrow"),
                    /!**
                     * 根据模板计算值
                     * @param object 数据
                     * @param name 字段名称
                     * @param express 模板表达式
                     * @returns {*}
                     *!/
                    _evalValue: function (object, name, express) {
                        var R = this, I = object;
                        if (express === 'sum()') {                     // 固定值：sum()
                            return addCalc(R[name] || 0, object[name] || 0, 2);
                        } else if (typeof (express) === 'function') { // 函数：functionName(字段名，数据，当前结果)
                            return express(name, object, R);
                        } else if (typeof (express) === 'string') {   // 模板字符串：“已选择 {R.count} 行”
                            var pattern = /\{(.*?)\}/gi, result;
                            while ((result = pattern.exec(express)) != null) {
                                express = express.replace(result[0], eval(result[1]));
                            }
                            return express;
                        } else {
                            return express;
                        }
                    }
                };
                // 计算默认值
                for (var name in jqGridOptions.footerConfig) {
                    R[name] = R._evalValue({}, name, jqGridOptions.footerConfig[name]);
                }
                // 计算最终的值
                for (var i = 0; i < R.selectedIds.length; i++) {
                    // 统计总数
                    R.count = R.count + 1;
                    // 行数据
                    var item = jqGridObject.jqGrid("getRowData", R.selectedIds[i]);
                    // 计算
                    for (var name in jqGridOptions.footerConfig) {
                        R[name] = R._evalValue(item, name, jqGridOptions.footerConfig[name]);
                    }
                }
                // 刷新Footer
                jqGridObject.footerData('set', R);
            };
            jqGridOptions._onPaging = clone(jqGridOptions.onPaging);
            jqGridOptions._onSelectRow = clone(jqGridOptions.onSelectRow);
            jqGridOptions._onSelectAll = clone(jqGridOptions.onSelectAll);
            jqGridOptions._loadBeforeSend = clone(jqGridOptions.loadBeforeSend);
            jqGridOptions.onPaging = function () {
                jqGridOptions._onPaging && jqGridOptions._onPaging();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.onSelectRow = function () {
                jqGridOptions._onSelectRow && jqGridOptions._onSelectRow();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.onSelectAll = function () {
                jqGridOptions._onSelectAll && jqGridOptions._onSelectAll();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.loadBeforeSend = function () {
                jqGridOptions._loadBeforeSend && jqGridOptions._loadBeforeSend();
                jqGridOptions.refreshFooter();
            };
        }*/

        // 重写完成事件
        jqGridOptions._loadComplete = clone(jqGridOptions.loadComplete);
        jqGridOptions.loadComplete = function () {
            jqGridOptions._loadComplete && jqGridOptions._loadComplete();

            jqGridObject.setGridWidth(jqGridObject.parents('.jqGrid_wrapper').width() - 1);
            jqGridObject.closest(".ui-jqgrid-bdiv").css({"overflow-x": "auto"});
        };
        // ------------------- 自定义参数设置 结束---------------------
        // 初始化表格
        jqGridObject.jqGrid(jqGridOptions);//.navGrid("#" + jqGridId + "Pager", {edit: false, add: false, del: false});

        // 设置基本函数
        var searcher = {
            getRawData: function (id) {
                var rows = rawData.rows ? rawData.rows : rawData;
                if (id) {
                    for (var i = 0; i < rows.length; i++) {
                        if (rows[i]['id'] == id) {
                            return rows[i];
                        }
                    }
                    return null;
                }
                return rows;
            },
            jqGrid: jqGridObject,
            options: jqGridOptions,
            query: function (currentPage) {
                if (searchForm.valid && !searchForm.valid()) {
                    return false;
                }
                var params = {
                    datatype: 'json',
                    postData: searchForm.serializeObject()
                };
                if (!currentPage) params.page = 1;
                params.rowNum = $(".ui-pg-selbox").val();//刷新jqgrid每页条数取页面显示数据
                jqGridObject.jqGrid('setGridParam', params).trigger("reloadGrid");
            },
            getSelectedRows: function (field) { // 可以只获取指定字段的值
                var rowData = [];
                var rowIds;
                if(searcher.options.multiselect){
                    rowIds = jqGridObject.jqGrid("getGridParam", "selarrrow");
                } else {
                    rowIds = [jqGridObject.jqGrid("getGridParam", "selrow")];
                }
                for (var i = 0; i < rowIds.length; i++) {
                    if(rowIds[i]) {
                        var item = jqGridObject.jqGrid("getRowData", rowIds[i]);
                        rowData.push(typeof field === 'string' ? item[field] : item);
                    }
                }
                return rowData;
            },
            getSelectedOriginalRows: function (field) {//可以获取指定字段的原始值,例子参考views/masterdata/vendoruser/edit[145-148]
                var rowData = [];
                var rowIds;
                if(searcher.options.multiselect){
                    rowIds = jqGridObject.jqGrid("getGridParam", "selarrrow");
                } else {
                    rowIds = [jqGridObject.jqGrid("getGridParam", "selrow")];
                }
                for (var i = 0; i < rowIds.length; i++) {
                    if(rowIds[i]) {
                        var item = this.getRawData(rowIds[i]);
                        rowData.push(typeof field === 'string' ? item[field] : item);
                    }
                }
                return rowData;
            },
            callback: function (msg) {
                return function (msg, searcher) {
                    Dialog.msg(msg, searcher.query);
                }
            },
            refreshFooter: function () {
                this.options.refreshFooter && this.options.refreshFooter();
            }
            // 其他常用函数
        };

        // 取消form的默认提交事件
        if (searchForm[0]) {
            searchForm[0].onsubmit = function () {
                return false;
            };
        }
        // 绑定查询按钮
        searchButton.click(function () {
            searcher.query();
            return false;
        });
        // 加载尾行
        searcher.refreshFooter();

        // 返回jqGrid句柄
        return searcher;
    },
    createTreeTable: function (table, rowTpl, options) {
        var treeTable = $(table), treeTableId = treeTable.attr('id');
        var treeTableList = $('#' + treeTableId + 'List');
        var searchForm = $('#' + treeTableId + 'Form');
        var searchButton = searchForm.find(':submit');
        var searchUrl = searchForm.attr('action');

        var treeTableOptions = $.extend({
            //请求对象
            postData: {},
            constant: {},
            parentId: 'parentId'
        }, options);

        var operation = {
            url: searchUrl,
            tpl: rowTpl,
            tableList: treeTableList,
            options: treeTableOptions,
            addRow: function (data, pid, root) {
                for (var i = 0; i < data.length; i++) {
                    var row = data[i];
                    this.constantData(row);
                    if ((!row ? '' : !row[options.parentId] ? '' : row[options.parentId]) == pid) {
                        treeTableList.append(Mustache.render(this.getTplContent(), {
                            pid: (root ? 0 : pid), row: row
                        }));
                        this.addRow(data, row.id);
                    }
                }
            },
            constantData: function (data) {
                for (var field in data) {
                    if(options.constant[field]){
                        data[field] = options.constant[field][data[field]] || options.constant[field]['-1'] || data[field];
                    }
                }
            },
            query: function (option) {
                option = $.extend({postDate: {}}, option);
                option.constant = options.constant;
                option.parentId = options.parentId;
                $(treeTableId + "List").html("");
                this.refresh(option);
            },
            refresh: function (options) {
                var tpl = operation.getTplContent();
                if (typeof (this.url) == 'string') {
                    Page.ajaxPOST(this.url, options.postData, function (data) {
                        operation.addRow(treeTableId + "List", tpl, data.result, 0, true);
                        // 取消所有事件
                        treeTable.unbind('click mouseover mouseout');
                        treeTable.treeTable({expandLevel: 5});
                    });
                } else {
                    alert('url参数必须是string类型');
                    return false;
                }
            },
            getTplContent: function () {
                return $(this.tpl).html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            }
        };

        operation.refresh({postData: searchForm.serialize()});

        // 取消form的默认提交事件
        searchForm[0].onsubmit = function () {
            return false;
        };
        // 绑定查询按钮
        // searchButton.click(function () {
        //     options.query({postData: searchForm.serialize()});
        //     return false;
        // });

        return operation;
    }
};

/**
 * 格式化类
 */
var Formatter = {
    Date: function (value) {
        if (value != null || value != '') {
            var date = new Date(value);
            return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        }
        return value;
    },
    Currency: function (value, row, index) {
        return formatCurrency(value);
    },
    TaxRate: function (value, row, index) {
        return ((value && value != '' ? value : 0) / 100.0).toFixed(2) + '';
    },
    Price: function (value, row, index) {
        return Number(formatCurrency(value)).toFixed(12);
    },
    Amount: function (value, row, index) {
        return formatCurrency(value);//((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Number: function (value, row, index) {
        return ((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Remark: function (value, row, index) {
        return '<textarea id="invRemark' + row.id + '" style="display: none">' + value + '</textarea>'
            + '<a href="javascript:void(0);" onclick="clickRemark($(\'#invRemark' + row.id + '\').val())">查看备注</a>';
    },
    LongText: function (length, alertText, showText) {//例子:vendor/list.jsp[103]
        return function (value, options, row) {
            value = value || '';
            if (value == null || value.length <= length) {
                return value;
            }
            var alertText_ = alertText || value;
            var showText_ = showText || '......';
            alertText_ = typeof(alertText_) == 'function' ? alertText_(value, options, row) : alertText_;
            showText_ = typeof(showText_) == 'function' ? showText_(value, options, row) : showText_;
            var html = $('<label style="font-weight:normal!important;margin:0!important;" onclick="layer.alert(this.title,{shadeClose:true})">' + value.substring(0, length) + showText_ + '</label>');
            html.attr('title', alertText_);
            return html[0].outerHTML;
        };
    },
    showDesc: function (map, defvalue) { //例子:vendor/list.jsp[96,98]
        defvalue = defvalue || '';
        return function (value, options, row) {
            return map[value] ? map[value] : defvalue;
        }
    },
    aHref: function (hrefUrl, attr) { //表单指定字段增加a标签跳转 例子：资源维护
        attr = (attr == null) ? "id" : attr;
        return function (value, options, row) {
            return "<a href='" + hrefUrl + "?" + attr + "=" + row[attr] + "'>" + value + "</a>";
        }
    }
};


/**
 * ztree
 * @type {{init: ZTree.init}}
 */
var ZTree = {
    init: function (treeId, url, options) {
        options = $.extend({
            postData: {},
            clickTree: function (treeId, treeNode, clickFlag) {
            },
            getFirstNode: function (treeNode) {
            },
            dblClickTree: function (event, treeId, treeNode) {

            },
            check: {
                enable: false
            },
            view: {
                showLine: false,
                selectedMulti: false,
                nameIsHTML: true
            },
            data: {
                key: {
                    name: "text"
                },
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: "0"
                }
            }
        }, options);

        var setting = {
            check: options.check,
            view: options.view,
            data: options.data,
            callback: {
                beforeClick: function (treeId, treeNode, clickFlag) {
                    options.clickTree(treeId, treeNode, clickFlag);
                },
                onDblClick: function (event, treeId, treeNode) {
                    options.dblClickTree(event, treeId, treeNode);
                }
            }
        }
        if (typeof (url) == 'string') {
            Page.ajaxPOST(url, options.postData, function (data) {
                $.fn.zTree.init($("#" + treeId), setting, data.result);
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                var rootnodes = zTree.getNodes();
                if (rootnodes[0] == undefined) {
                    return;
                }
                options.getFirstNode(rootnodes[0]);

            });
        }


        var operation = {
            add: function (nodes, pId, newNode, zTree) {
                $.each(nodes, function (i, obj) {
                    if (obj.id == pId) {
                        zTree.addNodes(nodes[i], newNode);
                        $.each(nodes[i].children, function (i, obj) {
                            if (obj.id == newNode.id) {
                                zTree.selectNode(obj);
                            }
                        })
                        //options.clickTree(null, newNode, null);
                        return;
                    }
                    if (undefined != nodes[i].children) {
                        operation.add(nodes[i].children, pId, newNode, zTree);
                    }
                })
            },
            update: function (nodes, id, currentNode, zTree) {
                $.each(nodes, function (i, obj) {
                    if (obj.id == id) {
                        var node = nodes[i];
                        node.text = currentNode.text;
                        node.pId = currentNode.pId;
                        zTree.updateNode(node);
                        zTree.selectNode(node);
                        options.clickTree(null, node, null);
                        return;
                    }
                    if (undefined != nodes[i].children) {
                        operation.update(nodes[i].children, id, currentNode, zTree);
                    }
                })
            },
            remove: function (nodes, id, newNode, zTree) {
                for (var i = 0; i < nodes.length; i++) {
                    if (nodes[i].id == id) {
                        zTree.removeNode(nodes[i]);
                        // options.clickTree(null, nodes[i], null);
                        return;
                    }
                    if (nodes[i].children) {
                        operation.remove(nodes[i].children, id, newNode, zTree);
                    }
                }
            }
        };

        return {
            getOptions: options,
            getTreeObj: function () {
                return $.fn.zTree.getZTreeObj(treeId);
            },
            selectNodeIndex: function (index) {
                if (index >= 0) {
                    var nodes = this.getTreeObj().getNodes();
                    this.getTreeObj().checkNode(nodes[index]);
                }
            },
            getSelected: function (field) { // 指定返回指定field的值,，如 'id'
                var result = [];
                var selectedNodes = this.getTreeObj().getSelectedNodes();
                for (var i = 0; i < selectedNodes.length; i++) {
                    result.push(field ? selectedNodes[i][field] : selectedNodes[i])
                }
                return result;
            },
            addNode: function (newNode) {
                operation.add(this.getTreeObj().getNodes(), newNode.pId, newNode, this.getTreeObj());
            },
            updateTreeNode: function (currentNode) {
                operation.update(this.getTreeObj().getNodes(), currentNode.id, currentNode, this.getTreeObj());
            },
            removeNode: function (newNode) {//例子:vendor/list.jsp[192]
                operation.remove(this.getTreeObj().getNodes(), newNode.id, newNode, this.getTreeObj());
            },
        };
    }
};

/**
 *  注：  name属性值和对象属性名一样
 * @type {{init: FORM.init}}
 */
var FORM = {
    init: function (formId, url, options) {
        options = $.extend({
            postDate: {}
        }, options);
        if (typeof (url) == 'string') {
            Page.ajaxPOST(url, options.postDate, function (data) {
                data = data.result;
                for (var Key in data) {
                    $("#" + formId + " :input").each(function () {
                        var $this = $(this);
                        if (Key == $this.attr("name")) {
                            $this.val(data[Key])
                        }
                    });
                }
            });
        }

    }
}

/**
 * 详见 views/masterdata/companytree_table_demo.jsp
 * @type {{}}
 */
var TREE_TABLE = {
    init: function (url, table, tplId, options) {
        var operation = {
            addRow: function (list, tpl, data, pid, root) {
                for (var i = 0; i < data.length; i++) {
                    var row = data[i];
                    this.constantData(row);
                    if ((!row ? '' : !row[options.parentId] ? '' : row[options.parentId]) == pid) {
                        $(list).append(Mustache.render(tpl, {
                            pid: (root ? 0 : pid), row: row
                        }));
                        this.addRow(list, tpl, data, row.id);
                    }
                }
            },
            constantData: function (data) {
                for (var field in data) {
                    if(options.constant[field]){
                        data[field] = options.constant[field][data[field]] || options.constant[field]['-1'] || data[field];
                    }
                }
            }
        };

        options = $.extend({
            //请求对象
            postDate: {},
            constant: {},
            parentId: 'parentId'

        }, options);
        var tpl = $(tplId).html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        if (typeof (url) == 'string') {
            Page.ajaxPOST(url, options.postData, function (data) {
                debugger;
                operation.addRow(table + "List", tpl, data.result, 0, true);
                // 取消所有事件
                $(table).unbind('click mouseover mouseout');
                try{
                    $(table).treeTable({expandLevel: 5});
                }catch (e){
                    //此处try..catch特殊处理条件查询子维度时无法返回父维度导致遮罩层不消失的情况（数据维度管理列表）
                }

            });
        }
        return {
            query: function (option) {
                option = $.extend({postDate: {}}, option)
                option.constant = options.constant;
                option.parentId = options.parentId;
                $(table + "List").html("");
                TREE_TABLE.init(url, table, tplId, option);
            }
        }
    }
}
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push($.trim(this.value) || '');//去除前后空格
        } else {
            o[this.name] =$.trim(this.value) || '';//去除前后空格
        }
    });
    return o;
};

$.fn.serializeJson = function () {
    var serializeObj = {};
    $(this.serializeArray()).each(function () {
        serializeObj[this.name] = $.trim(this.value);//去除前后空格
    });
    return serializeObj;
};


function clone(obj) {
    var o;
    if (typeof obj == "object") {
        if (obj === null) {
            o = null;
        } else {
            if (obj instanceof Array) {
                o = [];
                for (var i = 0, len = obj.length; i < len; i++) {
                    o.push(clone(obj[i]));
                }
            } else {
                o = {};
                for (var j in obj) {
                    o[j] = clone(obj[j]);
                }
            }
        }
    } else {
        o = obj;
    }
    return o;
}

/**
 * 获取URL参数
 * @param name
 * @returns {null}
 */
$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
};

/**
 * 将数值四舍五入(保留2位小数)后格式化成金额形式
 *
 * @param num 数值(Number或者String)
 * @return 金额格式的字符串,如'1,234,567.45'
 * @type String
 */
function formatCurrency(num) {
    if (num == null) {
        num = "0";
    }
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num)) {
        num = "0";
    }
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();
    if (cents < 10) {
        cents = "0" + cents;
    }
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++) {
        num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
    }
    return (((sign) ? '' : '-') + num + '.' + cents);
}
