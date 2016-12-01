<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 测试</title>
</head>
<body>
	<input type="text" placeholder="请输入指令" id="command" />
	<button id="btn-send" type="button">发送ajax</button>
	<div id="result"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn-send").on("click",function(){
				var command = $("#command").val();
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/json/command",
					dataType:"json",
					data:{command:command},
					success:function(data){
						var $result = $("#result");
						$result.empty();
						if(data.contentList){
							for(var i = 0; i<data.contentList.length; i++){
								$result.append("<p>"+data.contentList[i].content+"</p>");
							}
						}else{
							$result.append("<p style='color:red;'>无数据</p>");
						}
						$result.append()
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						debugger;
					}
				})
			});
		});
	</script>
</body>
</html>