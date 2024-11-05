package ie.atu.labexam;

import jakarta.validation.ValidationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String,String>> ValidationErrors(MethodArgumentNotValidException ex){
        Map<String,String> errorList = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            String errorName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorList.put(errorName, errorMessage);

        }

        return ResponseEntity.status(400).body(errorList);
    }
}
