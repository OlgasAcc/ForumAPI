package telran.java31.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter

public class PostDto {
	String title;
	String content;
	String[] tags;
}
