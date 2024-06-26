package ex1.exception.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
	OK(2000,HttpStatus.OK,"OK"),
	BAD_REQUEST(4000,HttpStatus.BAD_REQUEST,"잘못된 파라미터");
	private final int code;
	private final HttpStatus httpStatus;
	private final String message;

	ErrorCode(int code, HttpStatus httpStatus, String message) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
