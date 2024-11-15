package dev.pravallika.product.advices;

import dev.pravallika.product.ExceptionHandler.ProductNotFound;
import dev.pravallika.product.ExceptionHandler.ProductNotUpdated;
import dev.pravallika.product.dto.ErrorsDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(ProductNotUpdated.class)
    public ResponseEntity<ErrorsDTO> handleException(ProductNotUpdated ex){
        ErrorsDTO err = new ErrorsDTO();
        String message = ex.getMessage();
       // err.setMessage("please pass correct id");
        err.setMessage(message);
        ResponseEntity<ErrorsDTO> response = new ResponseEntity<>(err, HttpStatusCode.valueOf(501));
        return response;
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorsDTO> handleException(ProductNotFound ex){
        ErrorsDTO err = new ErrorsDTO();
        String message = ex.getMessage();
        // err.setMessage("please pass correct id");
        err.setMessage(message);
        ResponseEntity<ErrorsDTO> response = new ResponseEntity<>(err, HttpStatusCode.valueOf(501));
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorsDTO> handleAll(Exception e){
        ErrorsDTO err = new ErrorsDTO();
        String message = e.getMessage();
        err.setMessage(message);
        ResponseEntity<ErrorsDTO> response = new ResponseEntity<>(err, HttpStatusCode.valueOf(501));
        return response;
    }


}