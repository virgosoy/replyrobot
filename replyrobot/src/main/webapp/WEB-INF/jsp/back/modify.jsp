<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>修改内容页面</title>
		<link href="${pageContext.request.contextPath}/resources/css/all.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/back/modify.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="${pageContext.request.contextPath}/update" id="mainForm" method="post">
			<input type="hidden" name="id" value="${command.id}" />
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 修改内容</div>
				<div class="rightCont">
					<p class="g_title fix">修改内容 <a class="btn03" href="javascript:history.back();">返 回</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<input name="command" type="text" class="allInput" value="${command.command}"/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input name="description" type="text" class="allInput" value="${command.description}"/>
								</td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>序号</th>
								    <th>内容</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${command.contentList}" var="content" varStatus="status">
									<tr<c:if test="${status.count % 2 == 0}"> style="background-color:#ECF6EE;"</c:if>>
										<td><input type="checkbox" /><input type="hidden" name="ccid" value="${content.id}" /></td>
										<td>${status.count}</td>
										<td><textarea cols="80" rows="5" style="resize:none;" name="content" >${content.content}</textarea></td>
										<td>
											<a href="javascript:void(0);" onclick="remove(this);">删 除</a>
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td><input type="checkbox" name="id" value=""/></td>
									<td colspan="2"><input type="submit" class="tabSub" value="保 存" /></td>
									<td>
										<a href="javascript:void(0);" onclick="add(this);">添 加</a>
									</td>
								</tr>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>