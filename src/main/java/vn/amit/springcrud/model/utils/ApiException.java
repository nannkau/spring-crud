package vn.amit.springcrud.model.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private int code;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }



    public ApiException(ERROR error){
        super(error.getMessage());
        this.code =  error.getCode();
    }
    public ApiException(ERROR error, String message){
        super(message);
        this.code =  error.getCode();
    }
    
}
