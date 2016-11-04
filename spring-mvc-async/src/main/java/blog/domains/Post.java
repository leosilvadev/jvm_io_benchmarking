package blog.domains;

import java.util.ArrayList;
import java.util.List;

public class Post {

	private Long id;
	
	private String title;
	
	private String content;
	
	private List<Comment> comments;
	
	public Post() {
		this.comments = new ArrayList<>();
	}
	
	public Post(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.getComments().add(comment);
	}
	
}
