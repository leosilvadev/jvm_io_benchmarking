package blog.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.leosilvadev.groovypgasync.PgDb;

import blog.domains.Post;
import rx.Observable;

@Repository
public class PostRepository {
	
    private PgDb pgDb;

    @Autowired
	public PostRepository(PgDb pgDb) {
		this.pgDb = pgDb;
	}
    
    public Observable<List<Post>> findAll() {
    	return pgDb.find("SELECT id, title, content FROM posts", Post.class);
    }
    
    public Observable<Long> save(Post post) {
    	return pgDb.insert("INSERT INTO posts (title, content) VALUES (:title, :content)", post);
    }
	
}
