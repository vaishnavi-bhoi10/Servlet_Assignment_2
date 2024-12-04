package example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import example.main.Article;

public class ArticleDaoImplementation {
	private static final String URL = "jdbc:mysql://localhost:3306/museumdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void addArticle(Article article) {
        String sql = "INSERT INTO Articles (title, description, date_added) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getDescription());
            ps.setDate(3, new java.sql.Date(article.getDateAdded().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM Articles";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setDateAdded(rs.getDate("date_added"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public Article getArticleById(int id) {
        Article article = null;
        String sql = "SELECT * FROM Articles WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setDescription(rs.getString("description"));
                    article.setDateAdded(rs.getDate("date_added"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public void updateArticle(Article article) {
        String sql = "UPDATE Articles SET title = ?, description = ?, date_added = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getDescription());
            ps.setDate(3, new java.sql.Date(article.getDateAdded().getTime()));
            ps.setInt(4, article.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int id) {
        String sql = "DELETE FROM Articles WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

