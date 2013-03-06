package Model;

public class Article {
	private int id;
	private int authorId;
	private String author;
	private String title;
	private String content;
	private String date;
	
	
	public Article() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}
	
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	

}



