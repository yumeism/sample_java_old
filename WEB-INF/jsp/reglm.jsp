<%@ page import="java.sql.*, etudes.common.ConnectDB"  contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/etudes.css" />
	<title>ランドマーク登録</title>

	<script type="text/javascript" src="/Etudes/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript" src="/Etudes/js/etudes.js"></script>
</head>
<body>
<div id="body">

	<div id="err">
		<s:property value="%{error}" escape="false" />
	</div>
	
 	<s:form action="addlm">
 	<div id="form">
		<table>
			<tr><td colspan="2" >ランドマーク登録フォーム</td></tr>
			<tr><th>名称</th>
				<td><s:textfield name="name" id="landmark" size="40" /></td>
			</tr>
			<tr><th>郵便番号</th>
				<td><s:textfield name="post" id="post" size="10" />
				<input type="button" id="postBtn" value="住所検索" /></td>
			</tr>
			<tr><th>住所</th>
				<td><s:textfield name="addr" id="addr" size="60" />
					<s:hidden name="lat" id="lat" />
					<s:hidden name="lng" id="lng" /></td>
			</tr>
			<tr><td colspan="2"><s:submit cssClass="btn" value="登録" /></td></tr>
		</table>
	</div>
	<s:submit cssClass="btn" action="menu" value="MENUに戻る" />
	</s:form>
	
</div>
</body>
</html>
