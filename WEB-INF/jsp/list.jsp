<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Etudes/css/etudes.css" />
	<title>LANDMARK</title>
	<script type="text/javascript" src="/Etudes/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/Etudes/js/table.js"></script>
</head>
<body>
<div id="body">
<s:form>
	<table>
		<tr><td></td>
		    <td>名称</td>
			<td>住所</td>
		</tr>
	<s:iterator value="%{list}" status="st" >
		<tr>
			<td><s:checkbox name="id" fieldValue="%{key}" /></td>
		    <td><s:property value="value[0]" /></td>
			<td><s:property value="value[1]" /></td>
		</tr>
	</s:iterator>
	</table>
	<div id="menu">
	<ul>
		<li><s:submit cssClass="btn" action="menu" value="MENUに戻る" /></li>
		<li><s:submit cssClass="btn" action="reglm" value="ランドマークを追加する" /></li>
		<li><s:submit cssClass="btn" action="delete" value="削除" /></li>
	</ul>
	</div>
</s:form>
</div>
</body>
</html>
