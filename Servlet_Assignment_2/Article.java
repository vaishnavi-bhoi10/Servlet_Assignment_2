package example.main;

import java.util.Date;

public class Article {
	private int id;               
    private String title;         
    private String description;    
    private Date dateAdded;       

    
    public Article() {}

    
    public Article(int id, String title, String description, Date dateAdded) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
