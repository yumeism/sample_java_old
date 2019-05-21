<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Etudes/css/etudes.css" />
	<title>DELETE</title>
</head>
<body>
<div id="body">
	<p>削除しました<p/>

<s:form>
	<div id="menu">
	<ul>
		<li><s:submit cssClass="btn" action="menu" value="MENUに戻る" /></li>
		<li><s:submit cssClass="btn" action="showli" value="一覧に戻る" /></li>
	</ul>
	</div>
</s:form>
</div>
</body>
</html>
