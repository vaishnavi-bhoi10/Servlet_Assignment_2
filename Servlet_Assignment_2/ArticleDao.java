package example.dao;

import java.util.List;

import example.main.Article;

public interface ArticleDao {
	@param 
   void addArticle(Article article);

   
   List<Article> getAllArticles();

   
   Article getArticleById(int id);

   
   void updateArticle(Article article);

  
   void deleteArticle(int id);
}
