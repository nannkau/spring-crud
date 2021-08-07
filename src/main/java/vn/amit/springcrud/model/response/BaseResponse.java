package vn.amit.springcrud.model.response;

import lombok.Getter;
import lombok.Setter;
import vn.amit.springcrud.model.utils.ERROR;

@Getter
@Setter
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public BaseResponse( T data){
        this.data=data;
    }
    public BaseResponse(){
        this.code = ERROR.SUCCESS.getCode();
        this.message = ERROR.SUCCESS.getMessage();
    }

    public BaseResponse(ERROR error){
        this.code = error.getCode();
        this.message = error.getMessage();
    }
    
}
