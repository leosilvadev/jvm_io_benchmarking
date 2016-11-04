package blog.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import blog.domains.Post;

@Repository
public class PostRepository {
	
    private JdbcTemplate jdbcTemplate;

    @Autowired
	public PostRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    public List<Post> findAll() {
    	return jdbcTemplate.query("SELECT id, title, content FROM posts", (resultSet, rowNum) -> {
    		Long id = resultSet.getLong(1);
    		String title = resultSet.getString(2);
    		String content = resultSet.getString(3);
    		return new Post(id, title, content);
    	});
    }
    
    public void save(Post post) {
    	jdbcTemplate.update("INSERT INTO posts (title, content) VALUES (?, ?)", post.getTitle(), post.getContent());
    }
	
}
