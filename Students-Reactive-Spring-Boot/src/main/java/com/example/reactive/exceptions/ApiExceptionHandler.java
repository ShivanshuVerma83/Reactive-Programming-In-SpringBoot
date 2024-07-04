package com.example.reactive.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;


@ExceptionHandler(value = ApiRequestException.class)
public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
    ApiException apiException = new ApiException(e.getMessage());

}

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                ZonedDateTime.now()
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND.toString(),
                HttpStatus.NOT_FOUND.value(),
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    // Any other exception
    @ExceptionHandler()
    public ResponseEntity<ApiException> handleApiRequestException(Exception e) {
        ModelMapper modelMapper = new ModelMapper();
        ErrorDTO err = modelMapper.map(e, ErrorDTO.class);

        if (err.getBody() != null) {
            ApiException apiException = new ApiException(
                    err.getBody().getDetail(),
                    e,
                    err.getBody().getTitle(),
                    err.getBody().getStatus(),
                    ZonedDateTime.now()
            );

            return ResponseEntity.status(err.getBody().getStatus()).body(apiException);

        } else {
            ApiException apiException = new ApiException(
                    e.getMessage(),
                    e,
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    ZonedDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiException);

        }
    }
}
