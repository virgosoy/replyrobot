//常量
var MY_CLASS_NAME = "talk_recordboxme";
var COMPUTER_CLASS_NAME = "talk_recordbox";
//全局变量
var basePath;
var $content;
var $talkRecord;
$(function(){
	//全局变量初始化
	basePath = $("#basePath").val();
	$content = $("#content");
	$talkRecord = $("#talk-record");
	//事件绑定
	$content.on("keydown",function(event){
		var x = event.which || event.keyCode; 
		if(x==13){
			send();
		}
	})
	//初始化执行
	var msg = "客官，请问您需要什么服务？<br>回复[帮助]可以查看帮助列表。"
	appendDialog(COMPUTER_CLASS_NAME,"公众号",msg);
});

/**
 * 发送
 * @returns
 */
function send(){
	var content = $content.val();
	$content.val("");
	var isScrollBottom = false;
	//判断滚动条是否在底部
	if($talkRecord.scrollTop()+$talkRecord.innerHeight()>=$talkRecord[0].scrollHeight){
		isScrollBottom = true;
	}
	appendDialog(MY_CLASS_NAME,"我自己",content);
	if(isScrollBottom){
		//滚动到底部，实际赋值的数大于底部数值，但会自动到底部。
		$talkRecord.scrollTop($talkRecord[0].scrollHeight);
	}
	$.ajax({
		type:"post",
		url:basePath+"/autoReply",
		data:{content:content},
		success:function(data){
			//判断滚动条是否在底部
			if($talkRecord.scrollTop()+$talkRecord.innerHeight()>=$talkRecord[0].scrollHeight){
				isScrollBottom = true;
			}
			appendDialog(COMPUTER_CLASS_NAME,"公众号",data.trim());
			if(isScrollBottom){
				//滚动到底部，实际赋值的数大于底部数值，但会自动到底部。
				$talkRecord.scrollTop($talkRecord[0].scrollHeight);
			}
		}
	});
	
}

/**
 * 向聊天记录中添加聊天内容
 * @param myClass 添内容的样式
 * @param name 发送消息的账号名称
 * @param content 发送的内容
 */
function appendDialog(className,name,content) {
	var html = "<div class='" + className + "'>"+
			"	<div class='user'>"+
			"		<img src='" + basePath + "/resources/images/thumbs/" + className + ".jpg' />"+ name +
			"	</div>"+
			"	<div class='talk_recordtextbg'>&nbsp;</div>"+
			"	<div class='talk_recordtext'>"+
			"		<h3>" + content + "</h3>"+
			"		<span class='talk_time'>" + getCurrentDate() + "</span>"+
			"	</div>"+
			"</div>";
	$('#jp-container').append(html);
}

/**
 * 获取当前系统时间
 * @returns {String} 当前系统时间
 */
function getCurrentDate() {
	var date = new Date();
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + (date.getHours() < 10 ? "0" + date.getHours() : date.getHours()) + ":" + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes());
}
