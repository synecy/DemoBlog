<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="errorHandler.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="style.css" />
		<c:set var="totalArticles"><%= session.getAttribute("articleCount") %></c:set>
		<title>Demo Blog</title>
	</head>
	<body>
		<div id="topBlock">
		<h1>Demo Blog</h1>
		</div>
		<br>
		<c:if test="${param['new'] != null }">
			<a href="ViewArticles" id="hiddenPageUpdate"></a>	
			<script type="text/javascript">
				function updatePage() {
					window.location=document.getElementById('hiddenPageUpdate').href;
			    };
			    updatePage();
			</script>
		</c:if>
		<br>
		<br>
		<center>
		<div id="blogMessages">
			<c:forEach items="${sessionScope.articleList}" var="item">
				<div class="blogMessage" id="${item.msgId}">
					<div class="blogMessageDetails">
						<table width="100%">
							<tr>
								<td>
									<div class="messageTitle">Otsikko: ${item.title}</div>
									Suoralinkki: <a href="#${item.msgId}">#${item.msgId}</a><br>
									Lähettäjä: ${item.author}<br>
									Päivämäärä: ${item.date}<br>
								</td>
								<td class="msgDeleteBtn">
									<form action="DeleteArticle" method="post" class="deleteButtonForm">
										<button name="deleteId" value="${item.msgId}" type="submit">Poista</button>
									</form>
								</td>
							</tr>
						</table>
					</div>
					<br>
					${item.content}<br>
					<br>
				</div>
				<br>
			</c:forEach>
		</div>
		<br>
		</center>
		<center>
		<div id="blogWrite">
			<h2>Kirjoita uusi viesti:</h2>
			<form id="newMessageForm" action="PostArticle" method="post">
				<b>Otsikko:</b>
				<br>
				<input type="text" name="title" size="60"/>
				<br><br>
				<b>Viesti:</b>
				<br>
				<textarea name="message" rows="15" cols="60"></textarea>
				<br>
				<input type="submit" value="Lähetä">
			</form>
		</div>
		</center>
		<div id="bottomBlock">
			<br><br><br><br>
		</div>
	</body>
</html>




