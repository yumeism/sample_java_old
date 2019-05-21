<%@ page import="java.sql.*, etudes.common.ConnectDB"  contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/etudes.css" />
	<title>ランドマーク登録</title>
	<script type="text/javascript" src="/Etudes/js/jquery-1.9.1.js"></script>
 	<script type="text/javascript" src="/Etudes/js/table.js"></script>
</head>
<body>
<div id="body">
	<div id="err">
		<s:property value="%{msg}" />
	</div>
	<div id="form">
	<s:form>
		<div>
		キーワード検索
		<s:textfield name="word" size="20" /><br/><br/>
		<s:submit action="srclm" cssClass="btn" value="検索" />
		</div>
	</s:form>
	</div>
	<div>
	<s:if test="%{flg}"><table></s:if>
	<s:else><table style="display:none"></s:else>
		<tr>
			<td>名称</td>
			<td>住所</td>
		</tr>
	<s:iterator value="%{list}" status="st" >
		<tr>
		    <td><s:property value="key" /></td>
			<td><s:property value="value" /></td>
		</tr>
	</s:iterator>
	</table>
	</div>
	<s:a href="%{'/Etudes/menu'}" cssClass="link">MENUに戻る</s:a>
</div>
</body>
</html>
