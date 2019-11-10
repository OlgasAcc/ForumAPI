package telran.java31.forum.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "user", "dateCreated" })
@Document(collection = "comments")

public class Comment {

	String user;
	@Setter
	String message;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime dateCreated;
	int likes;

	@JsonIgnore
	public Comment(String user, String message) {
		this.user = user;
		this.message = message;
		dateCreated = LocalDateTime.now();
		likes = 0;
	}
	
	public boolean addLikes() {
		return (this.likes += 1) != 0;
	}
}
