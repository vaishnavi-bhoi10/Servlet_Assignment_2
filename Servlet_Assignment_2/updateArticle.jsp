<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="example.main.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Article article = (Article) request.getAttribute("article");
	%>
	<form action="updateArticle" method="post">
		<input type="hidden" name="id" value="<%=article.getId()%>">
		Title: <input type="text" name="title"
			value="<%=article.getTitle()%>" required><br>
		Description:
		<textarea name="description" required><%=article.getDescription()%></textarea>
		<br> Date Added: <input type="date" name="dateAdded"
			value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(article.getDateAdded())%>"
			required><br>
		<button type="submit">Update Article</button>
	</form>
</body>
</html>