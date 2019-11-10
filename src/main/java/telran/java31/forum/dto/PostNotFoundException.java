package telran.java31.forum.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class PostNotFoundException extends RuntimeException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PostNotFoundException (String id) {
		super("Post with "+id+" is not found");
	}
}
