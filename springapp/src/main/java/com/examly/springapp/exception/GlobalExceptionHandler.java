// package com.examly.springapp.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.converter.HttpMessageNotReadableException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {
//     @ExceptionHandler(HttpMessageNotReadableException.class)
//     public ResponseEntity<String> handleNoBody(HttpMessageNotReadableException ex) {
//         return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
//     }
//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleAll(Exception ex) {
//         return new ResponseEntity<>("Internal Server Errr",
//                 HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
