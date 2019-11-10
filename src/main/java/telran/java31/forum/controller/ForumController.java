package telran.java31.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostResponseDto;
import telran.java31.forum.service.PostService;

@RestController
public class ForumController {
	
	@Autowired
	PostService postService;

	@PostMapping("/forum/post/{author}") 
	public PostResponseDto addPost(@RequestBody PostDto postDto, @PathVariable String author) {
		return postService.addPost(postDto, author);
	}
	
	@GetMapping("/forum/post/{id}")
	public PostResponseDto findPost(@PathVariable String id) {
		return postService.findPost(id);
	}
	
	@DeleteMapping("/forum/post/{id}")
	public PostResponseDto removePost(@PathVariable String id) {
		return postService.deletePost(id);
	}
	
	@PutMapping("/forum/post/{id}")
	public PostResponseDto editPost(@PathVariable String id, @RequestBody PostDto postDto) {
		return postService.editPost(id, postDto);
	}
	
	@PutMapping("/forum/post/{id}/like")
	public boolean addLikeToPost(@PathVariable String id) {
		return postService.addLikeToPost(id);
	}
	
	@PutMapping("/forum/post/{id}/comment/{author}")
	public PostResponseDto addCommentToPost(@PathVariable String id, @RequestBody CommentDto commentDto, @PathVariable String author) {
		return postService.addCommentToPost(id, commentDto, author);
	}
	
	@GetMapping("/forum/posts/author/{author}")
	public List<PostResponseDto> findPostsByAuthor(@PathVariable String author) {
		return postService.findPostsByAuthor(author);
	}
}
