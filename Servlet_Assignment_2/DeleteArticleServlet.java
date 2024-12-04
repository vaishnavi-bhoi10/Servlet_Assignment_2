package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private ArticleDao articleDAO = new ArticleDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            articleDAO.deleteArticle(id);
            response.sendRedirect("listArticles");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid article ID.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting the article.");
        }
    }

}
