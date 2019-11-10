package telran.java31.forum.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java31.forum.model.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

	String id;
	String title;
	String content;
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime dateCreated;
	String[] tags;
	int likes;
	Set<Comment> comments;

}
