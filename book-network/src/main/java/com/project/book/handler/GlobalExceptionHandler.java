package com.project.book.handler;

// import com.alibou.book.exception.ActivationTokenException;
// import com.alibou.book.exception.OperationNotPermittedException;
import jakarta.mail.MessagingException;

import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.project.book.handler.BusinessErrorCodes.ACCOUNT_DISABLED;
import static com.project.book.handler.BusinessErrorCodes.ACCOUNT_LOCKED;
import static com.project.book.handler.BusinessErrorCodes.BAD_CREDENTIALS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ExceptionResponse> handleException(LockedException exp) {

    }
}
