package vn.amit.springcrud.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.amit.springcrud.model.response.BaseResponse;
import vn.amit.springcrud.model.utils.ApiException;
import vn.amit.springcrud.model.utils.ERROR;

@ControllerAdvice
public class GlobalExceptionHandle {
    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleCustomizedException(ApiException e) {
        LOGGER.info("Exception {}", e.getMessage());
        return new ResponseEntity<>(new BaseResponse<>(e.getCode(), e.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleInternalException(Exception ex) {
        try {
            LOGGER.error("Exception ", ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new BaseResponse<>(ERROR.SYSTEM_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
