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
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Date Added</th>
			<th>Actions</th>
		</tr>
		<%
		List<Article> articles = (List<Article>) request.getAttribute("articles");
		for (Article article : articles) {
		%>
		<tr>
			<td><%=article.getId()%></td>
			<td><%=article.getTitle()%></td>
			<td><%=article.getDescription()%></td>
			<td><%=article.getDateAdded()%></td>
			<td><a href="updateArticle?id=<%=article.getId()%>">Edit</a> |
				<a href="deleteArticle?id=<%=article.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>