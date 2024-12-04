package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import example.dao.ArticleDaoImplementation;
import example.main.Article;


@WebServlet("/ListArticlesServlet")
public class ListArticlesServlet extends HttpServlet {
	private ArticleDao articleDAO = new ArticleDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           
            List<Article> articles = articleDAO.getAllArticles();

            request.setAttribute("articles", articles);

            request.getRequestDispatcher("listArticles.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving the list of articles.");
        }
    }
}
