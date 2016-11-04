package blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import blog.domains.Comment;
import blog.domains.Post;
import blog.repositories.PostRepository;

@RestController
@RequestMapping("/v1/posts/{postId}/comments")
public class CommentController {

	private PostRepository postRepository;
	
	@Autowired
	public CommentController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@GetMapping
	public Iterable<Comment> all(@PathVariable Long postId) {
		Post post = postRepository.findOne(postId);
		return post.getComments();
	}
	
	@Transactional
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Comment create(@RequestBody @PathVariable Long postId, Comment comment) {
		Post post = postRepository.findOne(postId);
		post.addComment(comment);
		return comment;
	}
	
}
