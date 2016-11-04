package blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blog.domains.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
