package blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import blog.domains.Post;
import blog.repositories.PostRepository;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

	private PostRepository postRepository;
	
	@Autowired
	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@GetMapping
	public Iterable<Post> all() {
		return postRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Post create(@RequestBody Post post) {
		postRepository.save(post);
		return post;
	}
	
}
