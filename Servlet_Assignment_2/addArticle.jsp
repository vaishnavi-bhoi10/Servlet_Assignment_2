<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addArticle" method="post">
		Title: <input type="text" name="title" required><br>
		Description:
		<textarea name="description" required></textarea>
		<br> Date Added: <input type="date" name="dateAdded" required><br>
		<button type="submit">Add Article</button>
	</form>

</body>
</html>