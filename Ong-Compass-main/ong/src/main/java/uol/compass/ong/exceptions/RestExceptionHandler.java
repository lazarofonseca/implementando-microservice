package uol.compass.ong.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DefaultException.class)
	public ResponseEntity<StandardError> handleDefaultException(DefaultException ex) {
		StandardError exception = new StandardError(ex.getStatus(), ex.getError(), ex.getMessage(), Instant.now());
		return ResponseEntity.status(ex.getStatus()).body(exception);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> handleIllegalArgumentException(IllegalArgumentException ex) {
		StandardError exception = new StandardError(400, "BAD_REQUEST", ex.getMessage(), Instant.now());
		return ResponseEntity.status(400).body(exception);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex,
			HttpHeaders headers, 
			HttpStatus status, 
			WebRequest web) {
		StandardError exception = new StandardError(status.value(), "BAD_REQUEST", "Required request body is missing",
				Instant.now());
		return new ResponseEntity<>(exception, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, 
			HttpStatus status, 
			WebRequest web) {
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		String message = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

		StandardError exception = new StandardError(status.value(), "BAD_REQUEST", message, Instant.now());
		return new ResponseEntity<>(exception, headers, status);
	}
}
