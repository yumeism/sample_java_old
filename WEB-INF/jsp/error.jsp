<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Etudes/css/etudes.css" />
	<title>ERROR</title>
	<meta http-equiv="refresh" content="10; url=/Etudes/">
</head>
<body>
<div id="body">
	<div>
	<p>エラーが起こってしまいました。<br />
	10秒後にTOPページ(MENU)に移動します<p/>
	</div>
	<s:a href="%{'/Etudes/menu'}" cssClass="link">今すぐMENUに戻る</s:a>
	
</div>
</body>
</html>
