package telran.java31.forum.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "id" })
@Document(collection = "posts")

public class Post {

	String id;
	@Setter
	String title;
	@Setter
	String content;
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime dateCreated;
	@Setter
	String[] tags;
	int likes = 0;
	Set<Comment> comments;

	@JsonIgnore
	public Post(String title, String content, String[] tags, String author) {
		id = new ObjectId().toString();
		this.title = title;
		this.content = content;
		this.author = author;
		dateCreated = LocalDateTime.now();
		likes = 0;
		this.tags = tags;
		comments = new HashSet<Comment>();
	}


	public boolean addLikes() {
		return (this.likes += 1) != 0;
	}
}
