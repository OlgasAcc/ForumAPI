package telran.java31.forum.service;

import java.util.List;

import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostResponseDto;


public interface PostService {
	PostResponseDto addPost(PostDto postDto, String author);
	
	PostResponseDto findPost(String id);
	
	PostResponseDto deletePost(String id);
	
	PostResponseDto editPost(String id, PostDto postUpdateDto);
	
	boolean addLikeToPost(String id);
	
	PostResponseDto addCommentToPost(String id, CommentDto commentDto, String author);
	
	List<PostResponseDto> findPostsByAuthor(String name);
}
