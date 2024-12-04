package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

import example.main.Article;


@WebServlet(description = "adding article", urlPatterns = { "/AddArticle" })
public class AddArticleServlet extends HttpServlet {
	 private ArticleDao articleDAO = new ArticleDaoImplementation();

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String title = request.getParameter("title");
	        String description = request.getParameter("description");
	        String dateAdded = request.getParameter("dateAdded");

	        try {
	            Article article = new Article();
	            article.setTitle(title);
	            article.setDescription(description);
	            article.setDateAdded(new SimpleDateFormat("yyyy-MM-dd").parse(dateAdded));
	            articleDAO.addArticle(article);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("listArticles");
	    }

}
