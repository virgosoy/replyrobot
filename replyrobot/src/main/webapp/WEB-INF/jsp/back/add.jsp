<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>新增内容页面</title>
		<link href="${pageContext.request.contextPath}/resources/css/all.css" rel="stylesheet" type="text/css" />
	</head>
	<body style="background: #e1e9eb;">
		<form action="${pageContext.request.contextPath}/add" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 新增内容</div>
				<div class="rightCont">
					<p class="g_title fix">新增内容 <a class="btn03" href="javascript:history.back();">返 回</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<input name="command" type="text" class="allInput" value=""/>
								</td>
							</tr>
							<tr>
								<td width="90" align="right">描述：</td>
								<td>
									<input name="description" type="text" class="allInput" value=""/>
								</td>
							</tr>
							<tr>
								<td width="90" align="right">回复内容：</td>
								<td>
									<textarea name="content" class="allInput" style="width:150px;height:90px;" ></textarea>
								</td>
	       					</tr>
	       					<tr>
	                            <td colspan="2" width="85" align="right"><input type="submit" class="tabSub" value="添 加" /></td>
                            </tr>
						</tbody>
					</table>
				</div>
			</div>
	    </form>
	</body>
</html>