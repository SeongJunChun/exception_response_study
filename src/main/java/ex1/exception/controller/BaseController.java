package ex1.exception.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ex1.exception.ApiResponse;
import ex1.exception.exception.CustomException;
import jakarta.servlet.http.HttpServletResponse;

abstract public class BaseController {
	@ExceptionHandler(CustomException.class)
	public <T> ApiResponse<T> customExceptionHandler(HttpServletResponse response, CustomException customException) {
		response.setStatus(customException.getErrorCode().getHttpStatus().value());

		return new ApiResponse<T>(
			customException.getErrorCode().getCode(),
			customException.GetMessage(),
			customException.getData());
	}

	public <T> ApiResponse<T> makeApiResponse(List<T> result) {
		return new ApiResponse<>(result);
	}

	public <T> ApiResponse<T> makeApiResponse(T result) {
		return new ApiResponse<>(result);
	}
}
