<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/etudes.css" />
	<title>MENU</title>
</head>
<body>
<div id="body">
<s:form>
	<div id="menu">
	<ul>
		<li><s:submit cssClass="btn" action="search" value="探してみる" /></li>
		<li><s:submit cssClass="btn" action="showli" value="ランドマーク一覧" /></li>
		<li><s:submit cssClass="btn" action="reglm" value="追加する" /></li>
	</ul>
	</div>
</s:form>
</div>
</body>
</html>

