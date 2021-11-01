(function ($){
	$.extend({
		myoperate:{
			//-----------------------------------------------------------------
			download: function(id){
				/*console.log($(this))
				console.log(id)*/
				window.location.href="/hrm/contract/download/"+id
			},
			view: function(id) {
				//alert(1);
				//console.log('--table.view--');
            	table.set();
				//open: function (title, url, width, height, callback)就是打开窗口的函数
				//这个窗口的返回函数应该是由layer管理的，存在open之中。
            	$.mymodal.open2("viewing:" + table.options.modalName, $.myoperate.viewUrl(id));
            },
			viewUrl: function(id) {
            	var url = $.common.isEmpty(id) ? table.options.viewUrl.replace("{id}", "") : table.options.viewUrl.replace("{id}", id);
                return url;
            },
			receive: function() {
				//console.log("-receive-");
				table.set();
				table.options.url = table.options.listUrl;
				table.options.method = "post";
				table.options.removeUrl = table.options.removeUrl1;
				table.options.viewUrl = table.options.viewUrl1;
				table.options.onLoadSuccess = function(){
                	$("tr[data-index]:has(td:eq(6))").each(function(){
            			if($(this).find("td:eq(5)").html()=="0")$(this).css("background","#ff7")
            		})
                }
				$('#'+table.options.id).bootstrapTable("destroy");
				$.table.init(table.options);
			},
			send: function() {
				//console.log("-send-");
				table.set();
				table.options.url = table.options.sendUrl;
				table.options.method = "post";
				table.options.removeUrl = table.options.removeUrl2;
				table.options.viewUrl = table.options.viewUrl2;
				table.options.onLoadSuccess = function(){
                }
				//销毁是必须的，不然调用bootstrapTable(options)不会重建
				$('#'+table.options.id).bootstrapTable("destroy");
				$.table.init(table.options);
			},
			// 新增方法： 保存信息 刷新表格 没有提示框
            save2: function(url, data, callback) {
            	var config = {
        	        url: url,
        	        type: "post",
        	        dataType: "json",
        	        data: data,
        	        beforeSend: function () {
        	            $.modal.loading("正在处理中，请稍后...");
        	            $.modal.disable();
        	        },
        	        success: function(result) {
        	            if (typeof callback == "function") {
        	                callback(result);
        	            }
						//.log("success")
        	            $.myoperate.successCallback2(result);
        	        }
        	    };
        	    $.ajax(config)
            },
			// 新增方法： 成功回调执行事件2（不弹出提示信息）
            successCallback2: function(result) {
                if (result.code == web_status.SUCCESS) {
                    var parent = window.parent;
                    if (parent.table.options.type == table_type.bootstrapTable) {
                        $.modal.close();
                        //parent.$.modal.msgSuccess(result.msg);
                        parent.$.table.refresh();
                    } else if (parent.table.options.type == table_type.bootstrapTreeTable) {
                        $.modal.close();
                        //parent.$.modal.msgSuccess(result.msg);
                        parent.$.treeTable.refresh();
                    } else {
                        //$.modal.msgReload("保存成功,正在刷新数据请稍后……", modal_status.SUCCESS);
                    }
                } else if (result.code == web_status.WARNING) {
                    $.modal.alertWarning(result.msg)
                }  else {
                    $.modal.alertError(result.msg);
                }
                $.modal.closeLoading();
                $.modal.enable();
            },
		//--------------------------------------------------------------------
		},
		mymodal:{
			//无反馈确认
			open2: function(title, url, width, height, callback){
				//console.log('--open2-- callback:');
				//console.log(callback);
            	// 如果是移动端，就使用自适应大小弹窗
				//自己给自己加了一个callback函数。
            	if ($.common.isMobile()) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                }
                if ($.common.isEmpty(url)) {
            	    url = "/404.html";
                }
                if ($.common.isEmpty(width)) {
            	    width = 800;
                }
                if ($.common.isEmpty(height)) {
            	    height = ($(window).height() - 50);
                }
                if ($.common.isEmpty(callback)) {
                    callback = function(index, layero) {
                        var iframeWin = layero.find('iframe')[0];
						//这句话赋予了默认的callback函数，没有传进来而是在当前那个iframe的页面中定义一个submitHandler函数去执行
                        iframeWin.contentWindow.submitHandler(index, layero);
                    }
                }
            	layer.open({
            	    type: 2,//iframe
            	    area: [width + 'px', height + 'px'],
            	    fix: false,
            	    //不固定
            	    maxmin: true,
            	    shade: 0.3,
            	    title: title,
            	    content: url,//iframe层载入的网页网址。输入这个就会跳转。
            	    btn: ['确定'],
            	    // 弹层外区域关闭
            	    shadeClose: true,
            	    yes: callback,
            	});
            },
		}
	})
})(jQuery);