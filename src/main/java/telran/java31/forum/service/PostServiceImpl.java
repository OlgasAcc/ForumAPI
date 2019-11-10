package telran.java31.forum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.java31.forum.dao.ForumRepository;
import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostNotFoundException;
import telran.java31.forum.dto.PostResponseDto;
import telran.java31.forum.model.Comment;
import telran.java31.forum.model.Post;

@Component
public class PostServiceImpl implements PostService {
	@Autowired
	ForumRepository forumRepository;

	@Override
	public PostResponseDto addPost(PostDto postDto, String author) {
		Post post = new Post(postDto.getTitle(), postDto.getContent(), postDto.getTags(), author);
		forumRepository.save(post);
		return postToPostResponseDto(post);
	}

	@Override
	public PostResponseDto findPost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		return postToPostResponseDto(post);
	}

	@Override
	public PostResponseDto deletePost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		forumRepository.delete(post);
		return postToPostResponseDto(post);
	}

	@Override
	public PostResponseDto editPost(String id, PostDto postDto) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		if (postDto.getTitle() != null) {
			post.setTitle(postDto.getTitle());
		}
		if (postDto.getContent() != null) {
			post.setContent(postDto.getContent());
		}
		if (postDto.getTags() != null) {
			post.setTags(postDto.getTags());
		}
		forumRepository.save(post);
		return postToPostResponseDto(post);
	}

	@Override
	public boolean addLikeToPost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		int temp = post.getLikes();
		post.addLikes();
		forumRepository.save(post);
		return post.getLikes() - temp == 1;
	}

	@Override
	public PostResponseDto addCommentToPost(String id, CommentDto commentDto, String author) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		Comment comment = new Comment(author, commentDto.getMessage());
		post.getComments().add(comment);
		forumRepository.save(post);
		return postToPostResponseDto(post);
	}

	@Override
	public List<PostResponseDto> findPostsByAuthor(String author) {		
		return forumRepository.findByAuthor(author)
				.map(this::postToPostResponseDto)
				.collect(Collectors.toList());
	}

	private PostResponseDto postToPostResponseDto(Post post) {
		return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(),
				post.getDateCreated(), post.getTags(), post.getLikes(), post.getComments());
	}

}
